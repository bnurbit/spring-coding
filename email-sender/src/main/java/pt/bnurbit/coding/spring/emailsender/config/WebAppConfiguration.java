package pt.bnurbit.coding.spring.emailsender.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pt.bnurbit.coding.spring.emailsender.interceptor.BookHandlerInterceptor;

@Component
public class WebAppConfiguration implements WebMvcConfigurer {

    @Autowired
    private BookHandlerInterceptor bookHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(bookHandlerInterceptor);
    }
}
