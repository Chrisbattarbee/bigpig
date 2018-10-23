# Standartising the base distro
FROM amazonlinux

MAINTAINER Ivan Kotegov <ivankotegov2@gmail.com>

#############################################################################
# Bootstrap java
#############################################################################

RUN yum -y update && yum -y install sudo && yum -y install wget
RUN wget --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u191-b12/2787e4a523244c269598db4e85c51e0c/jdk-8u191-linux-x64.rpm 
RUN sudo yum -y install jdk-8u191-linux-x64.rpm && rm -f jdk-8u191-linux-x64.rpm

#############################################################################
# Get the latest version of Symbex
#############################################################################

ENV PROJ_DIR /usr/lib/jpf/
COPY jpf-core/ ${PROJ_DIR}
# COPY jpf-symbc/ /usr/lib/jpf/

#############################################################################
# JPF-Core configs
#############################################################################

# Set up jpf conf 
RUN mkdir /root/.jpf
RUN echo "jpf-core = ${PROJ_DIR}/jpf-core" >> /root/.jpf/site.properties
#RUN echo "jpf-symbc = ${PROJ_DIR}/jpf-symbc" >> /root/.jpf/site.properties
#RUN echo "extensions=\${jpf-core}, \${jpf-symbc}" >> /root/.jpf/site.properties
RUN echo "extensions=\${jpf-core}" >> /root/.jpf/site.properties

#############################################################################
# Getting the project that will be inspected
#############################################################################

RUN cp ${PROJ_DIR}/src/examples/Main.java /mnt
RUN mkdir /mnt/build

ENTRYPOINT javac -d /mnt/build /mnt/*.java && .${PROJ_DIR}bin/jpf ${PROJ_DIR}/Std.jpf

#############################################################################
# My small configs
#############################################################################

#RUN echo "alias c=clear" >> ~/.bash_aliases
#RUN echo "alias q=exit" >> ~/.bash_aliases
