package com.project.reggioStreet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.reggioStreet.model.Group;
import com.project.reggioStreet.model.Product;
import com.project.reggioStreet.model.User;
import com.project.reggioStreet.service.GroupService;
import com.project.reggioStreet.service.UserService;

@RestController
public class GroupController {
    
    @Autowired
    private GroupService serviceGroup;

    @Autowired
    private UserService serviceUser;

    @RequestMapping("/groups/{groupid}")
    public Group getGroup(@PathVariable("groupid") int groupId){
        return serviceGroup.getGroupById(groupId);
    }

    @RequestMapping("/groups")
    public List<Group> getGroups(){
        return serviceGroup.getGroups();
    }

    @PostMapping("/groups")
    public void createGroup(@RequestBody Group group){
        serviceGroup.createGroup(group);
    }

    // get all the users associated with a group
    @RequestMapping("/groups/{groupid}/partecipants")
    public List<User> getPartecipants(@PathVariable("groupid") int groupId){
        return serviceGroup.getPartecipants(groupId);
    }

    @RequestMapping("/groups/{groupid}/partecipant/{userid}")
    public User getPartecipant(@PathVariable("groupid") int groupId,
                                @PathVariable("userId") int userId){
        if(serviceGroup.getGroupById(groupId) != null)
            return serviceUser.getUserById(userId);

        return null;
    }

    @RequestMapping("/group/{groupid}/products")
    public List<Product> getProducts(@PathVariable("groupid") int grpId){
        // if the group exists ofc
        return serviceGroup.getProducts(grpId);
    }

    // return budget of a specific group
    @RequestMapping("/group/{groupid}/budget")
    public float getBudget(@PathVariable("groupid") int grpId){
        return serviceGroup.getGroupById(grpId).getBudget();
    }

    

}
