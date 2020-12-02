#!/bin/bash
cmd=$1
echo "SOURCECODE_HOME=${SOURCECODE_HOME}"
echo "current command=$cmd"


if [ "start" = "$cmd" ]; then
  #启动程序
  echo "Starting the  SOURCECODE at ${SOURCECODE_HOME}"
  cd ${SOURCECODE_HOME}/sourcecode
  exec ./start_cm.sh
elif [ "stop" = "$cmd" ];then
  echo "stop SOURCECODE"
else
  echo "Don't understand [$cmd]"
fi