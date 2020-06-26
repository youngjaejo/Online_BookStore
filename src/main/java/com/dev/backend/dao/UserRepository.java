package com.dev.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.dev.backend.model.*;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Query(value="select c from User c where c.email like %:keyword%")
    public User findByEmail(@Param("keyword") String keyword);
    @Query(value="select c from User c where c.email like %:keyword%")
    public List<User> findByEmails(@Param("keyword") String keyword);
    @Query(value="select c from User c where c.firstName like %:keyword%")
    public List<User> findByFName(@Param("keyword") String keyword);
    @Query(value="select c from User c where c.lastName like %:keyword%")
    public List<User> findByLName(@Param("keyword") String keyword);
    @Query(value="select c from User c inner join c.roles r on r.role like %:keyword%")
    public List<User> findByRoles(@Param("keyword") String keyword);

    }
