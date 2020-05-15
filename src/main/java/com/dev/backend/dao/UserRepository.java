package com.dev.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.dev.backend.model.*;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Query(value="select c.email from User c where c.email like %:keyword%")
    public String findByEmail(@Param("keyword") String keyword);
  
    }
