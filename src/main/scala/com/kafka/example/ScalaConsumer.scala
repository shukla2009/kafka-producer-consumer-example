package com.kafka.example

import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord, ConsumerRecords, KafkaConsumer}

import scala.collection.JavaConverters._

/**
  * Created by Rahul Shukla <rahul.shukla@synerzip.com> on 5/7/16.
  */
object ScalaConsumer extends App {
  private val config: Map[String, Object] = Map[String, Object](
    ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> "localhost:9092",
    ConsumerConfig.GROUP_ID_CONFIG -> "kafka",
    ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> classOf[org.apache.kafka.common.serialization.StringDeserializer].getName,
    ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> classOf[org.apache.kafka.common.serialization.StringDeserializer].getName)


  private val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](config.asJava)
  consumer.subscribe(Set("kafka").asJava)

  while (true) {
    val records: ConsumerRecords[String, String] = consumer.poll(200)

    if (!records.isEmpty) {
      records.asScala.foreach(println)
    }
  }

}
