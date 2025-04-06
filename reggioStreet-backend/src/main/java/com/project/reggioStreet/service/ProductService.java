package com.project.reggioStreet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.reggioStreet.model.Product;
import com.project.reggioStreet.model.Status;
import com.project.reggioStreet.model.User;
import com.project.reggioStreet.repository.ProductRepo;
import com.project.reggioStreet.repository.UserRepo;

// HERE, we'll do the business logic of the products
@Service
public class ProductService {

    // we are telling Spring to create an object out of this
    // BUT this is an INTERFACE!
    @Autowired
    private ProductRepo repo;
    // Dont worry, Spring IOC will create a CLASS and then an object out of this

    @Autowired
    private UserRepo userRepo;
    
    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProductById(int id){
        // here we use STREAM API, which lets us filter COLLECTIONS in an easy way!
        
        /*return  products.stream()
                        .filter(p -> p.getId() == id)
                        .findFirst().orElse(new Product(-1,"no item",0f,"no item",0));
        */
        // if the id is NOT found -> create a dummy item to show that
        // so the "noSuchElement" exception does not occur

        // both works!
        // return dp.searchForId(id);
        return repo.findById(id).orElse(new Product());
    }

    // insert a name -> get products with this name
    public List<Product> getProductsByName(String name){
        return repo.findByProductsName(name);
    }

    public void addProduct(Product product){
        // repo.add() access a METHOD of JPAREPOSITORY  
        // which lanches a QUERY to SAVE your object into the DATABASE
        System.out.println("Created? " + repo.save(product));;
    }

    public void updateProduct(Product product){
        // we use SAVE to UPDATE as well
        // if checks if the product already exists
        // and OVERWRITES it if it does
        // if it does NOT, it will create the object
        System.out.println("Updated? " + repo.save(product));
    }

    public void deleteProduct(int id){
        // deletes based on the ID
        repo.deleteById(id);
    }

    public List<Product> findProductQuantity(int wantedQt){
        return repo.findProductQuantity(wantedQt);
    }

    public List<Product> availableProducts(String status){
        return repo.availableProducts(status);
    }

}
