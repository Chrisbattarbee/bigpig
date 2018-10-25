#! bin/bash

cd /usr/lib/jpf/
javac -d /mnt/build /mnt/*.java 
# ./jpf-core/bin/jpf jpf-core/Std.jpf

#java -XshowSettings:properties 

cd jdart
./../jpf-core/bin/jpf src/examples/features/simple/test_baz.jpf

