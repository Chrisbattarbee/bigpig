#!/usr/bin/env bash

java -jar co-ordinator/build/libs/grpc_server_bundle.jar > /dev/null &
jpf symbex/jdart/test.jpf > /dev/null &
gradle fuzzer:fatJar
echo "20s" > benchmark_results.txt
java -javaagent:fuzzer-agent-latest.jar -jar fuzzer/build/libs/fuzzer-bigboi.jar 20 >> benchmark_results.txt
pkill java

java -jar co-ordinator/build/libs/grpc_server_bundle.jar > /dev/null &
jpf symbex/jdart/test.jpf > /dev/null &
gradle fuzzer:fatJar
echo "40" >> benchmark_results.txt
java -javaagent:fuzzer-agent-latest.jar -jar fuzzer/build/libs/fuzzer-bigboi.jar 40 >> benchmark_results.txt
echo "" >> benchmark_results.txt
pkill java

java -jar co-ordinator/build/libs/grpc_server_bundle.jar > /dev/null &
jpf symbex/jdart/test.jpf > /dev/null &
gradle fuzzer:fatJar
echo "60" >> benchmark_results.txt
java -javaagent:fuzzer-agent-latest.jar -jar fuzzer/build/libs/fuzzer-bigboi.jar 60 >> benchmark_results.txt
echo "" >> benchmark_results.txt
pkill java

java -jar co-ordinator/build/libs/grpc_server_bundle.jar > /dev/null &
jpf symbex/jdart/test.jpf > /dev/null &
gradle fuzzer:fatJar
echo "120" >> benchmark_results.txt
java -javaagent:fuzzer-agent-latest.jar -jar fuzzer/build/libs/fuzzer-bigboi.jar 120 >> benchmark_results.txt
echo "" >> benchmark_results.txt
pkill java

java -jar co-ordinator/build/libs/grpc_server_bundle.jar > /dev/null &
jpf symbex/jdart/test.jpf > /dev/null &
gradle fuzzer:fatJar
echo "300" >> benchmark_results.txt
java -javaagent:fuzzer-agent-latest.jar -jar fuzzer/build/libs/fuzzer-bigboi.jar 300 >> benchmark_results.txt
echo "" >> benchmark_results.txt
pkill java

java -jar co-ordinator/build/libs/grpc_server_bundle.jar > /dev/null &
jpf symbex/jdart/test.jpf > /dev/null &
gradle fuzzer:fatJar
echo "600" >> benchmark_results.txt
java -javaagent:fuzzer-agent-latest.jar -jar fuzzer/build/libs/fuzzer-bigboi.jar 600 >> benchmark_results.txt
echo "" >> benchmark_results.txt
pkill java

