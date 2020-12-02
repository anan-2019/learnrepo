#!/bin/sh

basepath=$(cd `dirname $0`; pwd)
#cd $basepath

PWD=`pwd`

target=`ls rpc-sourcecode*.jar`

exec java  -jar ${target}    -Dfile.encoding=UTF-8   -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=heapdump
