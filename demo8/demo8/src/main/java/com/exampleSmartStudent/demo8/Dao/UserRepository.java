package com.exampleSmartStudent.demo8.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exampleSmartStudent.demo8.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Query("SELECT u FROM User u WHERE u.email = :email")
    public User findByEmail(@Param("email") String email);

}
