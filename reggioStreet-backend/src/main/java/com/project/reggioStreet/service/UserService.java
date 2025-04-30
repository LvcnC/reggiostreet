package com.project.reggioStreet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.reggioStreet.model.Group;
import com.project.reggioStreet.model.Product;
import com.project.reggioStreet.model.User;
import com.project.reggioStreet.repository.GroupRepo;
import com.project.reggioStreet.repository.ProductRepo;
import com.project.reggioStreet.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private ProductRepo repoProducts;

    @Autowired
    private GroupRepo repoGroups;

    @Autowired
    private User user;

    public List<User> getUsers(){
        return repo.findAll();
    }

    public User getUserById(int id){
        return repo.findById(id).get();
    }

    public void createUser(User user){
        repo.save(user);
    }

    public void updateUser(User user){
        repo.save(user);

        // if the user has an actual group he belongs to
        if(user.getGroup() != null)
            updateBudgetToGroup(user.getGroup().getGroupId());
    }


    /** saves and ties a product to the user
     * 
     * @param userId
     * @param prodId
     */
    public void saveProductForUser(int userId, int prodId) {
        User user = null;
        Product prod = null;
        
        try{
            // 1. Find the USER, Find the PRODUCT from the database
        // find the user throught its id
        user = repo.findById(userId).get();
        // find the product throught its id
        prod = repoProducts.findById(prodId).get();
        }catch(NullPointerException ex){
            System.out.println("User or Product not found");
            ex.printStackTrace();
        }
        // 2. ADD the Product INTO the list of USERS
        // ADD the wanted product into the List of products OWNED by the User
        user.getProducts().add(prod);

        // here we have all the products saved of the user
        // we load the past ones from the db
        // so we need to add the new one here, so the db can FETCH IT

        // 3. LOAD the UPDATE into the DATABASE
        repo.save(user);
        // NOW SAVE the UPDATED user, who now has also the NEW PRODUCT
        // this actually happens throught a junction table,
        // The table User is responsible of creating and updating the junction 'user_producy'
        // so we need to ask her to also update the junction with a new record
    }

    public void updateBudgetToGroup(int groupId){
        // now we get the group the user belongs to
        Group group = repoGroups.findById(groupId).orElse(null);

        group.updateBudget(user.getBudget());
    }

    public List<Product> showProductsOf(int userId){
        User user = repo.findById(userId).get();
        
        return user.getProducts();
    }

    public void removeProductForUser(int userId, int prodId){
        // 1. find if USER and PRODUCT are in the database
        user = repo.findById(userId).get();
        Product prod = repoProducts.findById(prodId).get();

        // 2. From the lists of PRODUCT of USERS, delete that PRODUCT
        user.getProducts().remove(prod);

        // 3. SAVE the CHANGES, so load them into the database
        repo.save(user);

    }

    public void confirmProduct(int userid, int prodid) {
        
        

    }

}
