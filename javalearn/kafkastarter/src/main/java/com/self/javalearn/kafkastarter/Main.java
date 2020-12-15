package com.self.javalearn.kafkastarter;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @ClassName Main
 * @Author 51205 TRN
 * @Date 2020/12/14 9:34
 * @Version 1.0
 * @Description Class Function Description Here
 */
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        KafkaProducer<String,String> kafkaProducer = null;
        Properties props = new Properties();

        props.put("bootstrap.servers", "10.200.50.132:9092,10.200.50.133:9092");
            props.put("compression.type", "lz4");

        props.put("acks", "1");
        props.put("client.id", "producer-datatransfer".concat(String.valueOf(System.currentTimeMillis())));
        props.put("retries", 5);
        props.put("linger.ms", 5);
        props.put("batch.size", 16384);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        try {
            kafkaProducer = new KafkaProducer<>(props);

        } catch (Exception e) {
            logger.error("消费者创建失败",e);
        }

        try {
            while (true){
                kafkaProducer.send(new ProducerRecord<String, String>("reconnecttest", 0, System.currentTimeMillis() ,"test", "EBUG org.apache.kafka.clients.NetworkClient - Sending metadata request (type=MetadataRequest, topics=reconnecttest) to node 327\n" +
                        "11:00:33.292 [kafka-producer-network-thread | producer-datatransfer1607914670853] DEBUG org.apache.kafka.clients.NetworkClient - Recorded API versions for node 326: (Produce(0): 0 to 6 [usable: 3], Fetch(1): 0 to 8 [usable: 5], Offsets(2): 0 to 3 [usable: 2], Metadata(3): 0 to 6 [usable: 4], LeaderAndIsr(4): 0 to 1 [usable: 0], StopReplica(5): 0 [usable: 0], UpdateMetadata(6): 0 to 4 [usable: 3], ControlledShutdown(7): 0 to 1 [usable: 1], OffsetCommit(8): 0 to 4 [usable: 3], OffsetFetch(9): 0 to 4 [usable: 3], FindCoordinator(10): 0 to 2 [usable: 1], JoinGroup(11): 0 to 3 [usable: 2], Heartbeat(12): 0 to 2 [usable: 1], LeaveGroup(13): 0 to 2 [usable: 1], SyncGroup(14): 0 to 2 [usable: 1], DescribeGroups(15): 0 to 2 [usable: 1], ListGroups(16): 0 to 2 [usable: 1], SaslHandshake(17): 0 to 1 [usable: 0], ApiVersions(18): 0 to 2 [usable: 1], CreateTopics(19): 0 to 3 [usable: 2], DeleteTopics(20): 0 to 2 [usable: 1], DeleteRecords(21): 0 to 1 [usable: 0], InitProducerId(22): 0 to 1 [usable: 0], OffsetForLeaderEpoch(23): 0 to 1 [usable: 0], AddPartitionsToTxn(24): 0 to 1 [usable: 0], AddOffsetsToTxn(25): 0 to 1 [usable: 0], EndTxn(26): 0 to 1 [usable: 0], WriteTxnMarkers(27): 0 [usable: 0], TxnOffsetCommit(28): 0 to 1 [usable: 0], DescribeAcls(29): 0 to 1 [usable: 0], CreateAcls(30): 0 to 1 [usable: 0], DeleteAcls(31): 0 to 1 [usable: 0], DescribeConfigs(32): 0 to 2 [usable: 0], AlterConfigs(33): 0 to 1 [usable: 0], UNKNOWN(34): 0 to 1, UNKNOWN(35): 0 to 1, UNKNOWN(36): 0, UNKNOWN(37): 0 to 1, UNKNOWN(38): 0 to 1, UNKNOWN(39): 0 to 1, UNKNOWN(40): 0 to 1, UNKNOWN(41): 0 to 1, UNKNOWN(42): 0 to 1)\n" +
                        "11:00:33.293 [kafka-producer-network-thread | producer-datatransfer1607914670853] DEBUG org.apache.kafka.clients.Metadata - Updated cluster metadata version 3 to Cluster(id = JK_YusplQla_h0vZkiLSNg, nodes = [10.64.200.196:9092 (id: 327 rack: null), 10.64.200.108:9092 (id: 326 rack: null)], partitions = [Partition(topic = reconnecttest, partition = 0, leader = 327, replicas = [327], isr = [327])])"), new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if (exception != null){
                            System.out.println("消息发送失败"+exception.getMessage());
                        }else {
                            System.out.println("===========消息已发送");
                        }
                    }
                });
            }
        }catch (Exception e){
            logger.error("发送消息失败",e);
        }
    }
}
