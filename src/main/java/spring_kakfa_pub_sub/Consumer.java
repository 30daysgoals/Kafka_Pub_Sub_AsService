package spring_kakfa_pub_sub;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.messaging.handler.annotation.Payload;

@Service
public class Consumer {

    private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);
    ArrayList al =new ArrayList();

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void consume(@Payload String message) {
    	this.addtoarray(message);
        LOG.info("Consuming message='{}'", message);
    }
    
    public void addtoarray(String message) {
    	al.add(message);
        LOG.info("Added='{}'", message);
    }
    
    public ArrayList getarray() {
    	return al;
    }

}