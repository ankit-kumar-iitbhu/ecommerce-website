package com.ecommerce_website.shop_api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping(value="/sayHello")
    public String sayHello(){
        return "Hello Sir/Madam, have a nice day";
    }
}
