
# apache-kakfa-producer-consumer-using-mvn

Simple Maven Project for Messaging using Apache Kafka


## Documentation

[Apache Kafka](https://kafka.apache.org/quickstart)


## Below are the steps to start the Apache Kafka

Once downloaded and extracted Apache Kafka

    - Go the kafka-home folder
    - 1. Start Zookeeper
        > .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties  (for windows) (don't use windows if you are using some other os)
      2. Start Kafka Server
        > .\bin\windows\kafka-server-start.bat .\config\server.properties     


## Below are the steps to use this project

Clone the project

```bash
  git clone https://github.com/sandeepkokane/apache-kakfa-producer-consumer-using-mvn
```

Open the project as maven project (Either in Intellij or Eclipse)

```bash
  import project as maven project
```

Install dependencies

```bash
  mvn install
```

> To use project as Message Produer
- Run KafkaMessageProducer.java

> To use project as Message consumer
- Run KafkaMessageConsumer.java