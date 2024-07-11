package az.developia.springjava16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Springjava16Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springjava16Application.class, args);
		 Student s=context.getBean(Student.class);
		 System.out.println(s.getName());
		System.out.println(s.getComputer().getBrand());

		String[] beans=context.getBeanDefinitionNames();
		for (String bean:beans
			 ) {
			System.out.println(bean);

		}
	}

}
