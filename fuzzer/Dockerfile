# Dockerfile

FROM amazonlinux

MAINTAINER Chris Battarbee <chrisbattarbee3@gmail.com>

RUN yum -y update && yum -y install sudo && yum -y install wget

# Run bootstrap script
RUN wget https://s3.eu-west-2.amazonaws.com/buildkite-software/java-bootstrap.sh
RUN chmod +x java-bootstrap.sh
RUN ./java-bootstrap.sh
RUN rm -f java-bootstrap.sh

# Install Fuzzer bundle
COPY fuzzer/build/libs/fuzzer-bigboi.jar /usr/lib/fuzzer-bigboi.jar

ADD https://jitpack.io/com/github/ggavriil/javan-warty-pig/agent/master-SNAPSHOT/agent-master-SNAPSHOT.jar /usr/lib/fuzzer-agent-latest.jar

COPY fuzzer/fuzzer fuzzer
RUN chmod +x fuzzer

ENTRYPOINT ./fuzzer /mnt/target.java
