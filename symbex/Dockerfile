# Standartising the base distro
FROM amazonlinux

MAINTAINER Ivan Kotegov <ivankotegov2@gmail.com>

#############################################################################
# Bootstrap java
#############################################################################

RUN yum -y update && yum -y install sudo && yum -y install wget && yum -y install ant
#RUN wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
#RUN yum -y install apache-maven
RUN wget --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u191-b12/2787e4a523244c269598db4e85c51e0c/jdk-8u191-linux-x64.rpm 
RUN sudo yum -y install jdk-8u191-linux-x64.rpm && rm -f jdk-8u191-linux-x64.rpm

RUN wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
RUN sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
RUN yum -y install apache-maven && yum -y install which
RUN ls /usr/java
RUN export JAVA_HOME=/usr/java/jdk1.8.0_191-amd64
RUN mvn -v

#############################################################################
# Get the latest version of Symbex
#############################################################################

ENV PROJ_DIR /usr/lib/jpf
# Some are built and ready to go, some need a bit of clever copying
COPY jpf-core/        ${PROJ_DIR}/jpf-core
COPY z3/              ${PROJ_DIR}/z3
COPY jconstraints/    ${PROJ_DIR}/jconstraints
COPY jconstraints-z3/ ${PROJ_DIR}/jconstraints-z3
COPY jdart/           ${PROJ_DIR}/jdart

RUN mkdir -p /root/.jconstraints/extensions
RUN cp ${PROJ_DIR}/jconstraints-z3/target/jconstraints-z3-0.9.0.jar /root/.jconstraints/extensions
RUN cp ${PROJ_DIR}/z3/bin/com.microsoft.z3.jar /root/.jconstraints/extensions
RUN ls ~/.jconstraints/extensions

RUN cp ${PROJ_DIR}/z3/bin/libz3java.so /usr/lib
RUN cp ${PROJ_DIR}/z3/bin/libz3.so /usr/lib
RUN cd ${PROJ_DIR}/jdart && ant
RUN ls /usr/lib
#RUN java -XshowSettings:properties 

COPY entrypoint.sh    ${PROJ_DIR}
RUN  chmod +x ${PROJ_DIR}/entrypoint.sh

#############################################################################
# JPF-Core configs
#############################################################################

# Set up jpf conf 
RUN mkdir /root/.jpf
RUN echo "jpf-core = ${PROJ_DIR}/jpf-core" >> /root/.jpf/site.properties
RUN echo "jpf-jdart = ${PROJ_DIR}/jdart" >> /root/.jpf/site.properties
RUN echo "extensions=\${jpf-core}" >> /root/.jpf/site.properties


#############################################################################
# Getting the project that will be inspected
#############################################################################

RUN cp ${PROJ_DIR}/jpf-core/src/examples/Main.java /mnt
RUN mkdir /mnt/build

ENTRYPOINT ./${PROJ_DIR}/entrypoint.sh

#############################################################################
# My small configs
#############################################################################

#RUN echo "alias c=clear" >> ~/.bash_aliases
#RUN echo "alias q=exit" >> ~/.bash_aliases
