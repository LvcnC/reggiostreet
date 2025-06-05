package com.project.reggioStreet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.reggioStreet.model.Group;
import com.project.reggioStreet.model.Product;
import com.project.reggioStreet.model.User;
import com.project.reggioStreet.service.GroupService;
import com.project.reggioStreet.service.GroupUserService;
import com.project.reggioStreet.service.ProductService;
import com.project.reggioStreet.service.UserService;

@RestController
public class GroupUserController {
    
    @Autowired
    private User user;

    @Autowired
    private Group group;

    @Autowired
    private Product product;

    @Autowired
    private UserService serviceUser;

    @Autowired
    private GroupService serviceGroup;

    @Autowired
    private ProductService serviceProduct;

    @Autowired
    private GroupUserService serviceGroupUser;

    // it's a get request??
    @RequestMapping("/user/{userid}/group/{groupid}/add/{productid}")
    public void addProductToGroup(@PathVariable("userid") int usId,
                            @PathVariable("groupid") int grpId,
                            @PathVariable("productid") int prdId){
        serviceGroupUser.addProductToGroup(usId, grpId, prdId);
    }

    @PutMapping("/user/{userid}/group/{groupid}/edit")
    public void editProduct(@PathVariable("userid") int usId,
                            @PathVariable("groupid") int grpId,
                            @RequestBody Product prd){
        user = serviceUser.getUserById(usId);
        group = serviceGroup.getGroupById(grpId);

        // if the product is found in the db!!!
        if(serviceProduct.getProductById(prd.getProdId()) != null){
            // then let's overwrite / edit it
            serviceProduct.saveProduct(prd);
        }else{
            System.out.println("the product doesnt exists");
            // maybe we should ask if they want to add it if it does not already exists
        }
    }

    

}
