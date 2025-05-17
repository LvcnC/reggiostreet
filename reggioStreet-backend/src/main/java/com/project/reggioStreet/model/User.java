package com.project.reggioStreet.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Component
@Scope("prototype")
@Entity
@Table(name = "users")
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Min(value = 1) // here we are using a form of check/validation
    // we are saying, for the field "userId" -> the value MUST NOT be under 1 
    @Column(name = "user_id")
    private int userId;
    
    private String username;
    private String password;
    private String dob;
    private float budget;

    @ManyToMany
    private List<Product> products = new ArrayList<>();

    // one user has multiple groups, and a group has multipe users
    @ManyToMany
    private List<Group> groups = new ArrayList<>();

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

    public void updateBudget(float newBudget){
        this.budget += newBudget;
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

    public List<Group> getGroups() {
        return groups;
    }

    /** adds a new group element to the List of existing groups
     * @param group
     */
    public void addGroup(Group group) {

        try{
            // if the user is not already in the group
            if(!groups.contains(group))
                this.groups.add(group);
                // add it
            else
                System.out.println("The user is already present in this group");
        }catch(Exception err){
            System.out.println("Check if there is any group to loop through");
            err.printStackTrace();
        }

    }

}
