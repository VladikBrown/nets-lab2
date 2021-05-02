#!/bin/sh
#run this script to rebuild project and update jar file for docker-compose
(cd deployment/postgresql && docker-compose up -d) &&
mvn clean package &&
(cd deployment/postgresql && docker-compose down) &&
rm src/main/docker/lab2-0.0.1-SNAPSHOT.jar
cp target/lab2-0.0.1-SNAPSHOT.jar src/main/docker/lab2-0.0.1-SNAPSHOT.jar