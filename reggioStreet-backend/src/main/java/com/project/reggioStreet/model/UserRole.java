package com.project.reggioStreet.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // tells the IOC machine it has to take care of this object
@Scope("prototype") // specifies to the IOC machine that it has to create more of these, not just one
public enum UserRole {

    // enums are data structure which acts like mostly like variables and 
    // definies very specific values
    // -> EX. Seasons can only be: Summer, Fall, Winte, Spring 
    // you could use a String, but then you have less control on what seasons can be!

    // types of enum you can be
    ADMIN,
    USER;

    // they can have constructors
    private UserRole(){

    }
    // only private constructors are allowed

    
}
