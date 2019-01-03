#!/usr/bin/env bash

# Build everything
./gradlew co-ordinator:fatJar > /dev/null
./gradlew fuzzer:fatJar > /dev/null
ant -buildfile symbex/jdart/build.xml > /dev/null

# Run everything
java -jar co-ordinator/build/libs/grpc_server_bundle.jar > /dev/null &
sleep 2 # Wait for the server to boot up properly
jpf stub.jpf /dev/null &
./fuzzer/bp-fuzz project.jar config.json > /dev/null &
