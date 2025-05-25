package com.project.reggioStreet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.reggioStreet.model.Group;
import com.project.reggioStreet.model.Product;
import com.project.reggioStreet.model.User;
import com.project.reggioStreet.repository.GroupRepo;
import com.project.reggioStreet.repository.ProductRepo;
import com.project.reggioStreet.repository.UserRepo;

@Service
public class GroupService{
    
    @Autowired
    private GroupRepo repoGroup;

    @Autowired
    private UserRepo repoUser;

    @Autowired
    private ProductRepo repoProduct;

    @Autowired
    private User user;

    @Autowired
    private Group group;

    @Autowired
    private Product product;

    public Group getGroup(int groupdId){
        return repoGroup.findById(groupdId).get();
    }

    public List<Group> getGroups(){
        return repoGroup.findAll();
    }

    public void createGroup(Group group) {
        repoGroup.save(group);
    }

    public List<User> getPartecipants(int groupId) {
        group = repoGroup.findById(groupId).get();

        return group.getUsers();
    }
    
    // this should be the main component
    // the user actively chooses how much money to give to each group
    public void updateBudgetToGroup(User us, Group grp, float share){
        // now we get the group the user belongs to
        try{
            // if the user is in that group
            if(grp.getUsers().contains(us)){

                // if the user can actually give this money to the group
                if(us.getBudget() >= share){
                    grp.updateBudget(share);
                    // we need to check if this also works if the input number is negative(i think so)
                    us.updateBudget(-share);;
                }
                // save the changes
                repoGroup.save(grp);
                repoUser.save(us);

            }else{
                System.out.println("The user is not in the group");
            }

        }catch(Exception err){
            err.printStackTrace();
        }
    }

    public void addProductToGroup(int usId, int grpId, int prdId){
        product = repoProduct.findById(prdId).get();
        user = repoUser.findById(usId).get();
        group = repoGroup.findById(grpId).get();

        if(group.getUsers().contains(user)){
            // maybe this function should be here instead
            if(!group.getProducts().contains(product))
                group.getProducts().add(product);
        }
        // or you could do
        // group.addProduct(product);

        // perfom math to subtract the price

        repoGroup.save(group);

    }

    public void joinGroup(int usId, int grpId) {
        // 1. find the user and the group from the DB
        group = repoGroup.findById(grpId).get();
        user = repoUser.findById(usId).get();
        // 2. let's check if the user is not already in the group
        if(!user.getGroups().contains(group))
        // 3. now add the GROUP as a property to the USER 
            user.addGroup(group);
        else
            System.out.println("The user is already in the group");

        // 4. Save User and the changes
        repoUser.save(user);
        repoGroup.save(group);
    }

    public void leaveGroup(int usId, int grpId){
        user = repoUser.findById(usId).get();
        group = repoGroup.findById(grpId).get();

        if(user.getGroups().contains(group))
            user.getGroups().remove(group);
        else
            System.out.println("The user is not in the group");
    }

}
