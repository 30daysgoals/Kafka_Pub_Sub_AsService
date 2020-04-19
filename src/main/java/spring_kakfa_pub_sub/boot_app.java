package spring_kakfa_pub_sub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.kafka.clients.producer.internals.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class boot_app {

	private static final Logger logger = LoggerFactory.getLogger(spring_kakfa_pub_sub.Producer.class);
	public static void main(String[] args) {

		 SpringApplication.run(boot_app.class,args);
	}

}
