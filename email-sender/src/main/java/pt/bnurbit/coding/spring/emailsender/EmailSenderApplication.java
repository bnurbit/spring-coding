package pt.bnurbit.coding.spring.emailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pt.bnurbit.coding.spring.emailsender.config.SpringProperties;

@SpringBootApplication
@EnableConfigurationProperties(SpringProperties.class)
public class EmailSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailSenderApplication.class, args);
	}

}

