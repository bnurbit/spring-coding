package pt.bnurbit.coding.spring.emailsender.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import pt.bnurbit.coding.spring.config.SpringProperties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Configuration
@Slf4j
public class MailController  { // implements CommandLineRunner

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SpringProperties properties;

    //@Override
    public void run(String... args) throws MessagingException {

        log.info("Sending email");

        this.sendEmailWithAttachments();

        log.info("Done sending email");
    }

    /**
     * Simple Mail Message - no attachments
     */
    private void sendEmail(){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(properties.getToMail());
        simpleMailMessage.setSubject("Email sent using SpringBoot");
        simpleMailMessage.setText("Hello! \n\n Welcome to String Boot!");

        javaMailSender.send(simpleMailMessage);
    }

    /**
     *
     */
    private void sendEmailWithAttachments() throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setTo(properties.getToMail());
        mimeMessageHelper.setSubject("Here is a photo of the GOAT");
        mimeMessageHelper.setText("<h3> Hello! \n\n Take a look at the GOAT! :-) </h3>", true); // interpret as html
        mimeMessageHelper.addAttachment("siiiiiii.jpg", new ClassPathResource("image.jpg"));

        javaMailSender.send(mimeMessage);
    }
}
