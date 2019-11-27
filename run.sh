#!/usr/bin/env bash

echo ">>> git pull"
git pull origin master

echo ">>> mvn clean package"
mvn clean package -Dmaven.test.skip=true

echo "cd target"
cd target

echo "java -jar publicwechatdemo-0.0.1-SNAPSHOT.jar"
java -jar publicwechatdemo-0.0.1-SNAPSHOT.jar



