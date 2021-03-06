package avro.properties;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerAndConsumerProperties {

  // PRODUCER
  public static Properties getProducerProperties() {
    // INITIALIZE PROPERTIES VARIABLE
    Properties properties = new Properties();
    // CONFIGURE PRODUCER PROPERTIES
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
    properties.setProperty("schema.registry.url", "http://127.0.0.1:8081");
    properties.setProperty(ProducerConfig.ACKS_CONFIG, "all");
    // RETURN PROPERTIES
    return properties;
  }

  // CONSUMER
  public static Properties getConsumerProperties(String consumerGroup) {
    // INITIALIZE PROPERTIES VARIABLE
    Properties properties = new Properties();
    // CONFIGURE CONSUMER PROPERTIES
    properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, consumerGroup);
    properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
    properties.setProperty(ConsumerConfig.METADATA_MAX_AGE_CONFIG, "5000");
    properties.setProperty("schema.registry.url", "http://127.0.0.1:8081");
    // RETURN PROPERTIES
    return properties;
  }

}
