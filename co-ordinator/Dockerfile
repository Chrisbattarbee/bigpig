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
COPY build/libs/grpc_server_bundle.jar ./grpc_server_bundle.jar

ENTRYPOINT java -jar grpc_server_bundle.jar