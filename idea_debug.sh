#!/usr/bin/env bash


PORT=8081

echo "kill old service"
kill -9 $(lsof -n -P -t -i:$PORT)

echo ">>> mvn clean package"
mvn clean package -Dmaven.test.skip=true

echo "cd target"
cd target

echo "java -jar publicwechatdemo-0.0.1-SNAPSHOT.jar"
java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005  publicwechatdemo-0.0.1-SNAPSHOT.jar > app.log &
