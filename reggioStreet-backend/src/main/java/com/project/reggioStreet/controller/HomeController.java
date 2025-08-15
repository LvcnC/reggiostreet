package com.project.reggioStreet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// REST lets return DATA!! and not just pages ! (like @Controller)
@RestController
//@RequestMapping("auth") 
public class HomeController {

    @RequestMapping("/welcome")
    public String greet(){
        return "Welcome";
    }

}
