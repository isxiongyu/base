package cn.xiongyu.kafka.topic;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * ClassName TopicUtil
 * Description
 * Create by xiongyu
 * Date 2020/4/4 12:46 上午
 */
public class TopicUtil {
    public static void creatTopic(Properties props, String topicName, int numPartitions, short replicationFactor) {
        AdminClient client = KafkaAdminClient.create(props);
        client.createTopics(Collections.singletonList(new NewTopic(topicName, numPartitions, replicationFactor)));
        client.close();
        System.out.println("创建topic");
    }
}
