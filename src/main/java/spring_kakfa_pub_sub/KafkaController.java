package spring_kakfa_pub_sub;

import java.io.IOException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private Producer producer=null;
    private Consumer consumer=null;
    private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);
   
    @Autowired
    KafkaController(Consumer consumer, Producer producer) {
        this.consumer = consumer;   
        this.producer = producer;
    }
    
   /* @GetMapping(value = "/consumer")
    public void getarray() throws IOException {
    	ArrayList a= this.consumer.al;
    	if(a.size()>0) {
    	for(int i=0;i<a.size();i++)
    	{
    		LOG.info("GET call processed");
    		LOG.info((String) a.get(i));
    	}}
    	else
    	{
    		LOG.info("Nothing to return");
    	}
       
    }*/
    
    @GetMapping({"/consumer"})
    public void consume(String message) throws IOException {
      this.consumer.consume(message);
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody String message) {
        this.producer.sendMessage(message);
    }
}
