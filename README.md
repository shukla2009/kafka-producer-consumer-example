# kafka-producer-consumer-example
Kafka consumer producer example in Scala and Java


#Getting Started

Download Kafka from https://www.apache.org/dyn/closer.cgi?path=/kafka/0.10.0.0/kafka_2.11-0.10.0.0.tgz

run the command:
``` sh
> tar -xvzf <Download Folder>kafka_2.11-0.10.0.0.tgz
> cd kafka_2.11-0.10.0.0.tgz
```


### start zookeeper
if you have installed zookeeper, start it, or
run the command:
``` sh
> bin/zookeeper-server-start.sh config/zookeeper.properties
```

### start kafka with default configuration
``` sh
> bin/kafka-server-start.sh config/server.properties
```

### create a topic
``` sh
> bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 10 --topic kafka
```
