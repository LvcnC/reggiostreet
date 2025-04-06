package com.project.reggioStreet.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Component
@Scope("prototype")
@Entity
@Table(name = "users")
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    
    private String username;
    private String password;
    private String dob;
    private float budget;

    @ManyToMany
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    private Group group;

    // one user has one shoppingCart
    //@OneToOne
    //private ShoppingCart shoppingCart;

    // hibernate needs it!!!!!!!!!!!
    public User(){

    }

    public User(int id, String username, String password, String dob){
        setUserId(id);
        setUsername(username);
        setPassword(password);
        setDob(dob);
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }

    public float getBudget() {
        return budget;
    }
    
    public void setBudget(float budget) {
        this.budget = budget;
    }

    
    
    public String toString(){
        return userId + " - " + username + " - " + password  + " - " + dob;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}
