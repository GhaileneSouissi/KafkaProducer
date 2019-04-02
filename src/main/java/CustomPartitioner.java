import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.record.InvalidRecordException;
import org.apache.kafka.common.utils.Utils;

import java.util.List;
import java.util.Map;

/***
 * A cusomized Partitioner
 */
public class CustomPartitioner implements Partitioner {
    /***
     * this function returns the partition each key should be sent to
     * @param topic
     * @param key
     * @param keyBytes
     * @param value
     * @param valuebytes
     * @param cluster
     * @return
     */
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valuebytes,Cluster cluster) {
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int numPartitions = partitions.size();

        if((keyBytes == null) || (!(key instanceof  String))) throw new InvalidRecordException("Record invalid");
        //if (((String) key).equals("9")) return 0;
        //return (Math.abs(Utils.murmur2(keyBytes)) % (numPartitions - 1)) + 1;
        return 0;
    }

    public void close() {

    }

    public void configure(Map<String, ?> map) {

    }
}
