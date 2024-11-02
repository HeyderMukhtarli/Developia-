package az.developia.springjava16;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Springjava16Application {
	private static final Logger logger = LoggerFactory.getLogger(Springjava16Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Springjava16Application.class, args);

	}

}
