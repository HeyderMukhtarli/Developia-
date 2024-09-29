package az.developia.springjava16;

import az.developia.springjava16.service.TwilioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Springjava16Application {
	private static final Logger logger = LoggerFactory.getLogger(Springjava16Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Springjava16Application.class, args);

	}

}
