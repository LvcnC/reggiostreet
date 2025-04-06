package com.project.reggioStreet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.reggioStreet.model.Group;
import com.project.reggioStreet.model.User;
import com.project.reggioStreet.repository.GroupRepo;
import com.project.reggioStreet.repository.UserRepo;

@Service
public class GroupService{
    
    @Autowired
    private GroupRepo repo;

    @Autowired
    private UserRepo repoUser;

    @Autowired
    private User us;

    @Autowired
    private Group group;

    public List<Group> getGroups(){
        return repo.findAll();
    }

    public void createGroup(Group group) {
        repo.save(group);
    }

    public List<User> getPartecipants(int groupId) {
        Group group = repo.findById(groupId).get();

        return group.getUsers();
    }

    public void joinGroup(int userId, int groupId) {
        // I dont like it, modify it one day

        // 1. take them both from the db
        us = repoUser.findById(userId).get();
        Group group = repo.findById(groupId).get();

        // 2. now add the GROUP as a property to the USER 
        // since it's one to many, only the many (users) hold the foreign key
        us.setGroup(group);
        // give the user object its group property

        // 3. Update the GROUP budget now that it own USER
        // method that adds the user's money to the group
        updateGroupBudget(us);

        // 4. Save User
        repoUser.save(us);
    }
    
    
    public void updateGroupBudget(User user){
        // 1. RETRIEVE group from the db
        int groupId = user.getGroup().getGroupId();
        group = repo.findById(groupId).get();
        // 2. SET the new BUDGET (given by user)
        group.setBudget(user.getBudget());
        // 3. SAVE the updates to the db
        repo.save(group);
    }

    public void leaveGroup(int userId) {
        us = repoUser.findById(userId).get();

        int groupId = us.getGroup().getGroupId();

        group = repo.findById(groupId).get();

        // take away the group
        us.setGroup(null);

        repoUser.save(us);
    }


}
