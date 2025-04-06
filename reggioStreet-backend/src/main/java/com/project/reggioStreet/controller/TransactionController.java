package com.project.reggioStreet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.reggioStreet.repository.UserRepo;
import com.project.reggioStreet.service.UserService;

@RestController
public class TransactionController{

    @Autowired
    public UserService service;

    @RequestMapping("{userid}/{prodid}/confirm")
    public void confirmProduct(@PathVariable("userid") int userid,
                            @PathVariable("prodid") int prodid)
    {
        service.confirmProduct(userid, prodid);
    }        

}