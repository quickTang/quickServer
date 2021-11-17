#!/bin/bash
mvn -Dmaven.test.skip=true clean -e package
mv target/quickServer-make-assembly.tar.gz    ./quickServer.tar.gz

echo '=======================backup============================'
#sudo mv  /root/server/quickServer/    /root/server/quickServer_`date  +%y%m%d%H%M`/

if [ ! -d "/root/server/quickServer/" ];then
        sudo mkdir /root/server/quickServer 
fi;

echo '==================move============'
mv ./quickServer.tar.gz /root/server/quickServer/
cd /root/server/quickServer/
echo '=============tar xvf==================='
tar -zxvf quickServer.tar.gz
echo '=============chmod x============================='
chmod 755 start.sh
./start.sh