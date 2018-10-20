# Dockerfile

FROM amazonlinux

MAINTAINER Chris Battarbee <chrisbattarbee3@gmail.com>

# Run bootstrap script
RUN yum -y update && yum -y install sudo && yum -y install wget
RUN wget https://s3.eu-west-2.amazonaws.com/buildkite-software/java-bootstrap.sh
RUN chmod +x java-bootstrap.sh
RUN ./java-bootstrap.sh
RUN rm java-bootstrap.sh

# Install Fuzzer bundle
COPY build/libs/fuzzer-bigboi.jar /usr/lib/fuzzer-bigboi-latest.jar

ADD https://jitpack.io/com/github/ggavriil/javan-warty-pig/agent/master-SNAPSHOT/agent-master-SNAPSHOT.jar /usr/lib/fuzzer-agent-latest.jar

COPY fuzzer fuzzer
RUN chmod +x fuzzer

ENTRYPOINT ./fuzzer