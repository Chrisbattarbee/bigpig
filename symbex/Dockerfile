# Standartising the base distro
FROM amazonlinux

MAINTAINER Ivan Kotegov <ivankotegov2@gmail.com>

#############################################################################
# Bootstrap java
#############################################################################

RUN yum -y update && yum -y install sudo && yum -y install wget && yum -y install ant
RUN wget --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u191-b12/2787e4a523244c269598db4e85c51e0c/jdk-8u191-linux-x64.rpm 
RUN sudo yum -y install jdk-8u191-linux-x64.rpm && rm -f jdk-8u191-linux-x64.rpm
 
RUN wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
RUN sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
RUN yum -y install apache-maven && yum -y install which
 
RUN yum -y install gcc && yum -y install make

#############################################################################
# Get the latest version of Symbex
#############################################################################

ENV PROJ_DIR /root/jpf
# Some are built and ready to go, some need a bit of clever copying
COPY jpf-core/        ${PROJ_DIR}/jpf-core
COPY z3/              ${PROJ_DIR}/z3
COPY jconstraints/    ${PROJ_DIR}/jconstraints
COPY jconstraints-z3/ ${PROJ_DIR}/jconstraints-z3
COPY jdart/           ${PROJ_DIR}/jdart

# Needs to be rebuilt, since jars are compiled against each other and are dependent on the os
#RUN cd ${PROJ_DIR}/jconstraints && mvn install
#RUN cd ${PROJ_DIR}/z3/bin && mvn install:install-file -Dfile=com.microsoft.z3.jar -DgroupId=com.microsoft -DartifactId=z3 -Dversion=4.4.1 -Dpackaging=jar
ENV LD_LIBRARY_PATH ${PROJ_DIR}/z3/bin
#RUN cd ${PROJ_DIR}/jconstraints-z3 && mvn install

RUN mkdir -p /root/.jconstraints/extensions
RUN cp ${PROJ_DIR}/jconstraints-z3/target/jconstraints-z3-0.9.0.jar /root/.jconstraints/extensions
RUN cp ${PROJ_DIR}/z3/bin/com.microsoft.z3.jar /root/.jconstraints/extensions

COPY entrypoint.sh    ${PROJ_DIR}
RUN  chmod +x ${PROJ_DIR}/entrypoint.sh
COPY Std.jpf          ${PROJ_DIR}
COPY Main.java        ${PROJ_DIR}

#############################################################################
# JPF-Core configs
#############################################################################

# Set up jpf conf 
RUN mkdir /root/.jpf
RUN echo "jpf-core = ${PROJ_DIR}/jpf-core" >> /root/.jpf/site.properties
RUN echo "jpf-jdart = ${PROJ_DIR}/jdart" >> /root/.jpf/site.properties
RUN echo "extensions=\${jpf-core},${jpf-jdart}" >> /root/.jpf/site.properties


#############################################################################
# Getting the project that will be inspected
#############################################################################

RUN cp ${PROJ_DIR}/Main.java /mnt
RUN mkdir /mnt/build

ENTRYPOINT .${PROJ_DIR}/entrypoint.sh
