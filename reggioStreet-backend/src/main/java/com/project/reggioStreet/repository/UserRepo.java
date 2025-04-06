package com.project.reggioStreet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.reggioStreet.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
    // inherit the query methods from Jpa 
}
