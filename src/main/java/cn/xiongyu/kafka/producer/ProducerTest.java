package cn.xiongyu.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.log4j.Logger;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * ClassName ProducerTest
 * Description
 * Create by xiongyu
 * Date 2020/4/2 12:26 下午
 */
public class ProducerTest {
    static Logger logger = Logger.getLogger(ProducerTest.class);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties props = new Properties();
//        10.211.55.3:9092,10.211.55.3:9093,10.211.55.3:9094指定一台即可
//        指定多台只是为了故障转移
        props.put("bootstrap.servers", "10.211.55.3:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "1");
        props.put("retries", 3);
//        TopicUtil.creatTopic(props, "test-topic-2", 3, (short) 3);
        Producer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(
                "test-topic-2", "kafka-2", "hello-2");
        producer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (recordMetadata == null) {
                    System.out.println("发送失败");
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("发送成功");
                }
            }
        });
        System.out.println("flag");
        producer.close();
    }
}
