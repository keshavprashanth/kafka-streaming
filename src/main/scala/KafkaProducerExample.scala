import java.util.Properties

import com.typesafe.config.ConfigFactory
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

object KafkaProducerExample {
  def main(args: Array[String]): Unit = {

    val conf = ConfigFactory.load()   // loads properties from application.properties of resources
    val envConfig = conf.getConfig(args(0))  // gets dev/prod properties based on arguments


    val props = new Properties()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, envConfig.getString("bootstrap.server"))
    props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaProducerExample")

    // Serialize the key and values. Converts string into byte array before storing in kafka partitions.
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")

    val kafkaProducer = new KafkaProducer[String, String](props)
    val record = new ProducerRecord[String, String](envConfig.getString("topic"), "test_key", "Hello World!!")

    kafkaProducer.send(record)
    kafkaProducer.close()

  }

}
