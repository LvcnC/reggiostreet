package com.project.reggioStreet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.reggioStreet.model.Group;

@Repository
public interface GroupRepo extends JpaRepository<Group,Integer>{

}
