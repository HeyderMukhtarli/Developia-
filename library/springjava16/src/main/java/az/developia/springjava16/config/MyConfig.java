package az.developia.springjava16.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class MyConfig {

	@Bean
	public ModelMapper mapper() {
		ModelMapper m = new ModelMapper();
		return m;
	}
}
