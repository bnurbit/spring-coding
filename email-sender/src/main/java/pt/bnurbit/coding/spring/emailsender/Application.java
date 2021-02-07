package pt.bnurbit.coding.spring.emailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pt.bnurbit.coding.spring.config.SpringProperties;

@SpringBootApplication
@EnableConfigurationProperties(SpringProperties.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

