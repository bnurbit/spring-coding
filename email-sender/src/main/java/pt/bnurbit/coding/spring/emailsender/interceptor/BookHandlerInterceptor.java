package pt.bnurbit.coding.spring.emailsender.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pt.bnurbit.coding.spring.emailsender.config.SpringProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class BookHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SpringProperties properties;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    /**
     * Invoked before the actual handler in the controller is executed and the view for the response is not generated yet
     * Inject information from other components that the handler might need
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getParameter("bookId") != null){
            log.info("preHandle() sending book access mail...");

            sendEmail(request.getParameter("bookId"), "Book accessed");

            log.info("preHandle() Done");
        }

        return true;
    }

    /**
     * After the handler code has been executed but before the view is rendered to the user
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        if(request.getParameter("bookId") != null){
            log.info("postHandle() sending book access mail...");

            sendEmail(request.getParameter("bookId"), "Book access complete");

            log.info("postHandle() Done");
        }
    }

    /**
     * After the handle is executed, request is complete and view is rendered
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        if(request.getParameter("bookId") != null){
            log.info("afterCompletion() sending book request and response completion mail...");

            sendEmail(request.getParameter("bookId"), "Request and response complete");

            log.info("afterCompletion() Done");
        }
    }

    private void sendEmail(String bookId, String messageText){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(properties.getToMail());
        simpleMailMessage.setSubject("Book related activity for book: " + bookId);
        simpleMailMessage.setText(messageText + ": " + dateFormat.format(new Date()));

        javaMailSender.send(simpleMailMessage);
    }

}
