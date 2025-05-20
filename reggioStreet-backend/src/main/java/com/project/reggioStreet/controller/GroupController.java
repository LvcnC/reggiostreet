package com.project.reggioStreet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.reggioStreet.model.Group;
import com.project.reggioStreet.model.User;
import com.project.reggioStreet.service.GroupService;

@RestController
public class GroupController {
    
    @Autowired
    private GroupService serviceGroup;


    @RequestMapping("/groups")
    public List<Group> getGroups(){
        return service.getGroups();
    }

    @PostMapping("/groups")
    public void createGroup(@RequestBody Group group){
        service.createGroup(group);
    }

    // get all the users associated with a group
    @RequestMapping("/groups/{groupid}/partecipants")
    public List<User> getPartecipants(@PathVariable("groupid") int groupId){
        return service.getPartecipants(groupId);
    }

}
