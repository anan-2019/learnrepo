
import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.api.java.tuple.Tuple
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.api.windowing.windows.TimeWindow
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010

import java.util.Properties

/**
 * @ClassName Main
 * @Author 51205
 * @Date 2020/7/7 17:01
 * @Version 1.0
 * @Description Class Function Description Here
 */
object Main {
    def main(args: Array[String]): Unit = {
        val environment: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
        // 设置读取的kafka参数
        val properties = new Properties()
        properties.setProperty("bootstrap.servers", "kafka02:9092,kafka01:9092")
        properties.setProperty("group.id", "flink_group1")
        properties.setProperty("zookeeper.connect", "datanode01:2181,datanode02:2181,datanode03:2181")
        properties.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer") // key的反序列化
        properties.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer") // value的反序列化
        properties.setProperty("auto.offset.reset", "latest") // 偏移量

        val kafkaStream:DataStream[String] = environment.addSource(new FlinkKafkaConsumer010[String]("realdata", new SimpleStringSchema(), properties))
        val maped: DataStream[SensorReading] = kafkaStream.map(line =>{
            val firstString = line.split("\\|")(0)
            val fileds:Array[String] = firstString.split(",")
            SensorReading(fileds(1).trim.toLong, fileds(0).trim)
        })

        val value:DataStream[(Long,String)] = maped.map(data => {
            (data.id, data.timestamo)
        })

        // 开窗操作需要在KeyBy之后能用
        val keyByed: KeyedStream[(Long,String), Tuple] = value.keyBy(0)

        // 创建滚动时间窗口
        val window: WindowedStream[(Long,String), Tuple, TimeWindow] = keyByed.timeWindow(Time.seconds(5)) // 开窗时间
        val windowReduced: DataStream[(Long,String)] = window.reduce((data1, data2) => {
            (data1._1.min(data2._1), data1._2) // 对每个窗口内的数据进行聚合，求最小温度
        })
        windowReduced.print().setParallelism(1)

        environment.execute()
    }
}


// 样例类，传感器ID，时间戳，温度 （后面都使用这个样例类作为数据的类型）
case class SensorReading(id: Long, timestamo: String){
    override def toString: String = {
        id+":"+ timestamo
    }
}

