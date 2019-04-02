
import CoreProject.JsonLoader;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.LinkedHashMap;
import java.util.Properties;

/***
 * the producer class
 */
public class Producer {

    public static void main(String[] args){
        //call the properties configuration
        PropConfig propConfig = new PropConfig();
        //the jsonLoader object , responsible for loading json files and converting them to hash maps
        //property file
        Properties props = new Properties();
        propConfig.setProperties(props);
        //the message id (key)
        Integer id = 0;
        //read the topic from the console
        if (args.length < 1) {
            System.err.println("Please specify at least 1 parameters ");
            System.exit(-1);
        }
        String[] topicName = args;
        //the user map
        LinkedHashMap<String,Integer> users =  JsonLoader.LoadJson("C:\\Users\\ghailenes\\Desktop\\exercice\\liste_noms_age.json");
        //the kafka producer , responsible of producing messages
        KafkaProducer<String,String> producer = new KafkaProducer<String,String>(props);
        //sending to many topics the same record(we can send multiple records to multiple topics too)
        for(int i=0;i<topicName.length;i++) {
            //looping the map and sending data
            for (String key : users.keySet()) {
                ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName[i], id.toString(), key + " : " + users.get(key).toString());
                //async send
                producer.send(rec);
                id++;
            }
        }



        //close the channel of producer
        producer.close();
    }
}
