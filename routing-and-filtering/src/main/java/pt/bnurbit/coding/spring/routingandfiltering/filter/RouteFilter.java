package pt.bnurbit.coding.spring.routingandfiltering.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Runs before the request is routed to the API service
 * Can be used for monetization: track the number of requests made by a certain client
 */
@Slf4j
@Component
public class RouteFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        log.info("PreFilter: {} request to {}",request.getMethod(), request.getRequestURL().toString());
        return null;
    }
}
