
SHELL := /bin/bash

.PHONY: all jpf-core jconstraints jconstraints-z3 jdart submodules

all: submodules jpf-core jconstraints z3 jconstraints-z3 jdart 

submodules:
	git submodule update --recursive

docker:
	docker build -t symbex .

jpf-core:
	cd jpf-core && git checkout JPF-8.0 && ant

jdart:
	cd jdart && git pull && ant

z3: 
	wget https://github.com/Z3Prover/z3/releases/download/z3-4.4.1/z3-4.4.1-x64-ubuntu-14.04.zip
	unzip z3-4.4.1-x64-ubuntu-14.04.zip
	rm -rf z3-4.4.1-x64-ubuntu-14.04.zip
	mv z3-4.4.1-x64-ubuntu-14.04 z3
	cd z3/bin && mvn install:install-file -Dfile=com.microsoft.z3.jar -DgroupId=com.microsoft -DartifactId=z3 -Dversion=4.4.1 -Dpackaging=jar
	export LD_LIBRARY_PATH=`pwd`/z3/bin:LD_LIBRARY_PATH

jconstraints: 
	cd jconstraints && git checkout jconstraints-0.9.1 && mvn install

jconstraints-z3: 
	cd jconstraints-z3 && git checkout jconstraints-z3-0.9.0 && mvn install
