package com.project.reggioStreet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.reggioStreet.model.Product;
import com.project.reggioStreet.model.User;
import com.project.reggioStreet.service.GroupService;
import com.project.reggioStreet.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private GroupService serviceGroup;

    // for the authentification, theres a whole chapter about that

    // get this user
    @RequestMapping("/users")
    public List<User> getUser(){
        return service.getUsers();
    }

    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        return service.getUserById(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        service.createUser(user);
    }

    /*
    
     * A product is being saved in the table 'user_products'
     * @param userId - id of the user who saved the product
     * @param prodId - id of the product saved
     
    @PutMapping(value = "/{userid}/products/{prodid}")
    public void saveProduct(@PathVariable("userid") int userId,
                                @PathVariable("prodid") int prodId){

        service.saveProductForUser(userId, prodId);
    }
    // without ("userId") in the @PathVariable, it doesnt work
    */

    // you should be able to leave a group as well
    @RequestMapping("/{userid}/join/{groupid}")
    public void joinGroup(@PathVariable("userid") int userId,
                        @PathVariable("groupid") int groupId){
        serviceGroup.joinGroup(userId,groupId);
    }

    @RequestMapping("/{userid}/leave/{groupid}")
    public void leaveGroup(@PathVariable("userid") int usId,
                            @PathVariable("groupid") int grpId){
        serviceGroup.leaveGroup(usId, grpId);
        // check if this works
    }

}
