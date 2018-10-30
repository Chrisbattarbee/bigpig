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

# Needed for dynamic linking of java so libraries for z3 and jconst-z3
RUN yum -y install gcc ant

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

ENV LD_LIBRARY_PATH ${PROJ_DIR}/z3/bin

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
