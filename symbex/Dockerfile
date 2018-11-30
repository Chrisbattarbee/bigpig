# Standartising the base distro
FROM fedora

MAINTAINER Ivan Kotegov <ivankotegov2@gmail.com>

#############################################################################
# Bootstrap base image
#############################################################################

RUN yum -y update && yum -y install sudo wget gcc ant git which unzip docker
#RUN wget https://s3.eu-west-2.amazonaws.com/buildkite-software/java-bootstrap.sh
#RUN chmod +x java-bootstrap.sh
#RUN ./java-bootstrap.sh
#RUN rm java-bootstrap.sh

# Install mvn
RUN wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
RUN sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
RUN yum -y install apache-maven

#############################################################################
# Get the latest version of Symbex
#############################################################################

ENV PROJ_DIR /root/jpf
# Install jpf-core
WORKDIR ${PROJ_DIR}
RUN git clone https://github.com/javapathfinder/jpf-core.git
RUN cd jpf-core && git checkout JPF-8.0 && ant

# Install jConstraints
WORKDIR ${PROJ_DIR}
RUN git clone https://github.com/psycopaths/jconstraints.git
RUN cd jconstraints && git checkout jconstraints-0.9.1 && mvn install

# Install Z3
WORKDIR ${PROJ_DIR}
# Note that we specify a specific *release* of Z3
RUN wget https://github.com/Z3Prover/z3/releases/download/z3-4.4.1/z3-4.4.1-x64-ubuntu-14.04.zip 
RUN unzip z3-4.4.1-x64-ubuntu-14.04.zip && rm z3-4.4.1-x64-ubuntu-14.04.zip
RUN ln -s z3-4.4.1-x64-ubuntu-14.04 z3
WORKDIR ${PROJ_DIR}/z3/bin
RUN mvn install:install-file -Dfile=com.microsoft.z3.jar -DgroupId=com.microsoft -DartifactId=z3 -Dversion=4.4.1 -Dpackaging=jar
ENV LD_LIBRARY_PATH ${PROJ_DIR}/z3/bin

# install jconstraints-z3
WORKDIR ${PROJ_DIR}
RUN git clone https://github.com/psycopaths/jconstraints-z3.git 
WORKDIR ${PROJ_DIR}/jconstraints-z3
RUN git checkout jconstraints-z3-0.9.0
RUN mvn install

RUN mkdir -p /root/.jconstraints/extensions
RUN cp ${PROJ_DIR}/jconstraints-z3/target/jconstraints-z3-0.9.0.jar /root/.jconstraints/extensions
RUN cp ${PROJ_DIR}/z3/bin/com.microsoft.z3.jar /root/.jconstraints/extensions

WORKDIR ${PROJ_DIR}
COPY entrypoint.sh    ${PROJ_DIR}
COPY Std.jpf          ${PROJ_DIR}
COPY Main.java        ${PROJ_DIR}
COPY site.props       ${PROJ_DIR}

#############################################################################
# Install Jdart
#############################################################################
COPY jdart/           ${PROJ_DIR}/jdart
RUN cd jdart && ant

COPY DockerfileInner ${PROJ_DIR}/Dockerfile
RUN systemctl start docker.service
RUN docker build -t softengbigpig/symbex:latest .
