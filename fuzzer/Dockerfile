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
RUN wget https://s3.eu-west-2.amazonaws.com/buildkite-software/fuzzer-bigboi-latest.jar
RUN mv fuzzer-bigboi-latest.jar /usr/lib/

RUN wget https://s3.eu-west-2.amazonaws.com/buildkite-software/fuzzer-agent-latest.jar
RUN mv fuzzer-agent-latest.jar /usr/lib/

RUN wget https://s3.eu-west-2.amazonaws.com/buildkite-software/fuzzer
RUN chmod +x fuzzer
RUN mv fuzzer /usr/bin/

CMD fuzzer