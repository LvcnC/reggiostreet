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
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private ProductRepo repoProducts;

    @Autowired
    private GroupRepo repoGroups;

    @Autowired
    private User user;

    @Autowired
    private Product product;

    @Autowired
    private Group group;

    public List<User> getUsers(){
        return repo.findAll();
    }

    public User getUserById(int id){
        return repo.findById(id).orElse(null);
    }

    public void createUser(User user){
        repo.save(user);
    }

    
    public void updateUser(User user){
        repo.save(user);
    }
    

    /*
    public void saveProductForUser(User us, Product prod) {
        
        // let's hope they are not null
        try{
            // 1. Find the USER, Find the PRODUCT from the database
            // find the user throught its id
            


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
    */

    /*
    public List<Product> showProductsOf(int usId){
        user = repo.findById(usId).get();
        return user.getProducts();
    }
    */

}
