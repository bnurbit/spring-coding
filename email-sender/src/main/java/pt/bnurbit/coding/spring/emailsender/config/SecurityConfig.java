package pt.bnurbit.coding.spring.emailsender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * What URL paths should be secures and which are free to access without login
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll() // any request to the root of the app should be permitted without login in
                .mvcMatchers("/admin").hasRole("ADMIN") // any request to /admin requires user login with admin role
                .anyRequest().authenticated() // all other requests require authentication
                .and()
                .formLogin() // all other requests are behind a login page
                .loginPage("/login").permitAll() // assumes the fields username, password by default; all users can access the login page without logging in
                .and()
                .logout().permitAll(); // all users can access the login page without logging in
    }

    /**
     * Specify the user store
     * Passwords should be always encoded
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {

        UserDetails user = User
                .withUsername("user")
                .password("$2a$10$Q9jI.VWgGWW4ier1BxS/HOdiT9Sn49nxLQtNDSPoU7Xi98oqRVf7G")
                .roles("USER")
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password("$2a$10$mn5wGi8NdhV6H1MNCsR9l.E0VirQOdhwkfP14bDcKWpkAFlLGTGbK")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
