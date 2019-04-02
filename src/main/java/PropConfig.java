import java.util.Properties;

/***
 * Properties configuration class
 */
public class PropConfig {
    /***
     * setting properties for consumer
     * @param props
     */
    public void setProperties(Properties props){
        // Set the brokers (bootstrap servers)
        props.setProperty("bootstrap.servers", "10.75.17.84:9092");
        // Set how to serialize key/value pairs
        props.setProperty("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty("partitioner.class","CustomPartitioner");
    }
}
