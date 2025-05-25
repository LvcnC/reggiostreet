package com.project.reggioStreet.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

// SCOPE PROTOTYPE -> Spring needs to understand that it has to create MULTIPLE objects for this class
// otherwise it keeps overwriting the same object(singleton)
// ENTITY -> lets the JPA know it can CREATE an OBJECT out the mapped sql
@Component
@Scope("prototype")
@Entity
@Table(name = "products")
public class Product{

    // @Id lets JPA know that it's the primary key of the record
    // FUN FACT: it translates the property's name into snake_case
    // prodId (JAVA) -> prod_id (SQL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private int prodId;

    // hibernate MAPS these properties into sql columns
    private String name;
    private float price;
    private String category;
    private int qt;
    private String description;
    
    // to tell hibernate its dealing with an enum which contains
    @Column(columnDefinition = "enum('AVAILABLE','FINISHING','FINISHED')")
    @Enumerated(EnumType.STRING) 
    private Status status;

    // each product belongs to n groups
    @JsonIgnore // -> without this, it goes in Stack Overflow
    @ManyToMany
    private List<Group> groups = new ArrayList<>();


    // if you DONT specify it, product will also create the bridge table
    // and you have:
    // shoppingcart_product mapped by ShoppingCart
    // product_shoppingcart mapped by Product
    
    public Product(int id, String name, float price, String category, int qt, Status status){
        setProdId(id);
        setName(name);
        setPrice(price);
        setCategory(category);
        setQt(qt);
    }
    
    // serve costruttore vuoto!!!
    public Product(){
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getQt() {
        return qt;
    }
    public void setQt(int qt) {
        this.qt = qt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public String toString(){
        return prodId + " - " + name  + " - "     + price 
                                + " euro - "    + category  + " - " + qt;
    }

}
