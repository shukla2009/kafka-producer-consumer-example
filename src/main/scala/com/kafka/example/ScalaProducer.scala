package com.kafka.example

/**
  * Created by Rahul Shukla <rahul.shukla@synerzip.com> on 5/7/16.
  */


import java.time.{LocalDateTime, ZoneOffset, ZonedDateTime}
import java.util.Date

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

import scala.collection.JavaConverters._
import scala.util.Random

object ScalaProducer extends App {
  val topic = "kafka"
  val brokers = "localhost:9092"

  private val config: Map[String, Object] = Map[String, Object](
    ProducerConfig.BOOTSTRAP_SERVERS_CONFIG -> brokers,
    ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG -> classOf[org.apache.kafka.common.serialization.StringSerializer].getName,
    ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG -> classOf[org.apache.kafka.common.serialization.StringSerializer].getName)

  val producer = new KafkaProducer[String, String](config.asJava)

  val rnd = new Random()
  val t = System.currentTimeMillis()
  while (true) {
    val runtime = LocalDateTime.now()
    val ip = s"192.168.2.${rnd.nextInt(255)}"
    val msg = s"$runtime www.example.com $ip"
    println(msg)
    val record = new ProducerRecord[String, String](topic, ip, msg)
    producer.send(record)
    Thread.sleep(100)

  }
}
