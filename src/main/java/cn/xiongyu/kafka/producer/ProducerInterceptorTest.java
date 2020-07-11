package cn.xiongyu.kafka.producer;

import org.apache.kafka.clients.producer.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * ClassName ProducerInterceptorTest
 * Description
 * Create by xiongyu
 * Date 2020/4/2 5:24 下午
 */
public class ProducerInterceptorTest {
    public static void main(String[] args) {
        Properties props = new Properties();
//        10.211.55.3:9092,10.211.55.3:9093,10.211.55.3:9094指定一台即可
//        指定多台只是为了故障转移
        props.put("bootstrap.servers", "10.211.55.3:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        List<String> interceptors = new ArrayList<>();
        interceptors.add("cn.xiongyu.kafka.producer.CountInterceptor");
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptors);
        props.put("acks", "1");
        props.put("retries", 3);
        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 10; i++) {
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>("test-topic", "kafka", "hello");
            producer.send(producerRecord);
        }
        System.out.println("flag");
        producer.close();
    }
}
