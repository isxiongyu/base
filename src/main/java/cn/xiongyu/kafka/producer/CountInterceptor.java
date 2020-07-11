package cn.xiongyu.kafka.producer;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * ClassName CountInterceptor
 * Description
 * Create by xiongyu
 * Date 2020/4/2 5:20 下午
 */
public class CountInterceptor implements ProducerInterceptor<String, String> {
    int successCount = 0;
    int failCount = 0;
    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if (recordMetadata == null) {
            failCount++;
        } else {
            successCount++;
        }
    }

    @Override
    public void close() {
        System.out.println("成功数: " + successCount);
        System.out.println("失败数: " + failCount);
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
