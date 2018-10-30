#! /bin/bash

cd /root/jpf/jdart
javac -d /mnt/build /mnt/*.java 
# ./jpf-core/bin/jpf jpf-core/Std.jpf

./../jpf-core/bin/jpf src/examples/features/simple/test_baz.jpf
./../jpf-core/bin/jpf ../Std.jpf

