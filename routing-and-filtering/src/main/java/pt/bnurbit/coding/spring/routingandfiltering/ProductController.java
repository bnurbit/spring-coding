package pt.bnurbit.coding.spring.routingandfiltering;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @RequestMapping(value = "/search")
    public String welcome(){
        return "<h3>Searching for a product...</h3>";
    }

    @RequestMapping(value = "/order")
    public String order(){
        return "<h3>Placing a product order...</h3>";
    }
}
