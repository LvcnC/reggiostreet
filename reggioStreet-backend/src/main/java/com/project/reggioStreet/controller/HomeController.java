package com.project.reggioStreet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// REST lets return DATA!! and not just pages ! (like @Controller)
@RestController
public class HomeController {

    /*
    // mapping -> localhost:8080/
    @RequestMapping("/")
    public String greet(){

        // because servers used to return both the layout(http,css) and data(backend)
        // here Springs (when @Controller is used) would expect a FILE!
        return "Welcome!";
        // but we dont want that,
        // so we can also use @RequestBody
    }
    */

    @RequestMapping("/")
    public String greet(){
        return "Welcome";
    }

}
