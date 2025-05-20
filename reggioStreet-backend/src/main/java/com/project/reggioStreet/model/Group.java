package com.project.reggioStreet.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "usersgroup")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private int groupId;
    
    private String name;
    private float budget;
    private String description;
    private int numPartecipants;

    @JsonIgnore // it goes in overflow otherwise
    @ManyToMany(mappedBy = "groups")
    private List<User> users = new ArrayList<>();

    // each groups has n products
    @JsonIgnore
    @ManyToMany(mappedBy = "groups")
    private List<Product> products = new ArrayList<>();
    //this might cause problems

    public Group(){

    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public void updateBudget(float budget) {
        this.budget += budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumPartecipants() {
        return numPartecipants;
    }

    public void setNumPartecipants(int numPartecipants) {
        this.numPartecipants = numPartecipants;
    }

    public String toString(){
        return groupId  + " - " + name + " - " 
                        + budget + " - " + description + " - " + numPartecipants; 
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Product> getProducts(){
        return products;
    }

    public void addUser(User us){

        try{
            if(!users.contains(us)){
                users.add(us);
            }else
                System.err.println("The user is already present in this group");

        }catch(Exception err){
            System.out.println("Check if there is any user to loop through");
            err.printStackTrace();
        }

    }


    public void addProduct(Product prd){

        try{
            products.add(prd);

        }catch(Exception err){
            System.out.println("Check if there is any user to loop through");
            err.printStackTrace();
        }

    }

}
