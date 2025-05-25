package com.project.reggioStreet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.reggioStreet.model.Group;
import com.project.reggioStreet.model.Product;
import com.project.reggioStreet.model.User;
import com.project.reggioStreet.repository.GroupRepo;
import com.project.reggioStreet.repository.ProductRepo;
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
    public ProductService productService;

    @Autowired
    public User user;

    @Autowired
    public Group group;

    @Autowired
    public Product product;

    @Autowired
    public UserRepo userRepo;

    @Autowired
    public GroupRepo groupRepo;

    @Autowired
    public ProductRepo productRepo;

    /*
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
    */

    public void addProductToGroup(int usId, int grpId, int prdId){
        user = userRepo.findById(usId).get();
        group = groupRepo.findById(grpId).get();
        product = productRepo.findById(prdId).get();

        if(group.getUsers().contains(user)){
            group.addProduct(product);
            groupRepo.save(group);
            // save the user
        }        

    }
}
