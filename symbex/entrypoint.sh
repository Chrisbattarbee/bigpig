#! bin/bash

cd /usr/lib/jpf/
javac -d /mnt/build /mnt/*.java 
./jpf-core/bin/jpf Std.jpf

./jpf-core/bin/jpf jdart/src/examples/features/simple/test_baz.jpf

