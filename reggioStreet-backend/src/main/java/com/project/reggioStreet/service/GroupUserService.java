package com.project.reggioStreet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.reggioStreet.model.Group;
import com.project.reggioStreet.model.User;
import com.project.reggioStreet.repository.GroupRepo;
import com.project.reggioStreet.repository.UserRepo;

@Service
public class GroupUserService {
    // idk if this is good practice
    // there's a fundamental problem with this idea
    // we must aknowlodge whether you have one budget per user, or a user chooses multiple for each group
    
    @Autowired
    public UserService userService;

    @Autowired
    public GroupService groupService;

    @Autowired
    public User user;

    @Autowired
    public Group group;

    @Autowired
    public UserRepo userRepo;

    @Autowired
    public GroupRepo groupRepo;

    public void updateUserBudget(int userId, float newBudget){
        // 1. RETRIEVE user from the db
        user = userRepo.findById(userId).orElse(null);
        // 2. SET the new BUDGET (given by user)
        user.updateBudget(newBudget);
        // 3. SAVE the updates to the db
        userRepo.save(user);

        // 4. update the group budget as consequence
        groupService.updateGroupBudget(userId, );
    }

}
