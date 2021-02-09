package pt.bnurbit.coding.spring.emailsender.generator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
public class PasswordGenerator {

    public static void main(String[] args){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String userPwd = "userpwd";
        String adminPwd = "adminpwd";

        String encodedUserPwd = encoder.encode(userPwd);
        String encodedAdminPwd = encoder.encode(adminPwd);

        log.info("User Password: {}", encodedUserPwd);
        log.info("Admin Password: {}", encodedAdminPwd);
    }
}
