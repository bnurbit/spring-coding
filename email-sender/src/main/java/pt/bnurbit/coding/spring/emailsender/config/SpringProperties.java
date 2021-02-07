package pt.bnurbit.coding.spring.emailsender.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("pt.bnurbit.coding.spring")
@Getter
@Setter
public class SpringProperties {

    private String toMail;

}
