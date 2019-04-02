# KafkaProducer
A kafka Project , it reads a Json file and send it to a kafka Consumer
# Steps to deploy a kafka and zookeeper in docker
1- docker run -d -p 2181:2181 --name zookeeper jplock/zookeeper
2- docker run -d --name kafka --link zookeeper:zookeeper -p 9092:9092 ches/kafka 
# Steps to run the project
1- mvn clean install
2- mvn exec:java -Dexec.mainClass="Producer" -Dexec.args="topic"
