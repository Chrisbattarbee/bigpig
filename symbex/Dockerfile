# Standartising the base distro
FROM amazonlinux

MAINTAINER Ivan Kotegov <ivankotegov2@gmail.com>

#############################################################################
# Bootstrap java
#############################################################################

RUN yum -y update && yum -y install sudo && yum -y install wget
RUN wget https://s3.eu-west-2.amazonaws.com/buildkite-software/java-bootstrap.sh
RUN chmod +x java-bootstrap.sh
RUN ./java-bootstrap.sh
RUN rm java-bootstrap.sh

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
RUN javac -d /mnt/build /mnt/Main.java

## TESTING THE IMAGE

RUN ls /mnt
RUN ls /mnt/build

RUN echo ${PROJ_DIR}
RUN ls ${PROJ_DIR}

ENTRYPOINT .${PROJ_DIR}bin/jpf PROJ_DIR/Std.jpf

#############################################################################
# My small configs
#############################################################################

#RUN echo "alias c=clear" >> ~/.bash_aliases
#RUN echo "alias q=exit" >> ~/.bash_aliases
