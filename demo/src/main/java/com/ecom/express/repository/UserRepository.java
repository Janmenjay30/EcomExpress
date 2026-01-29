package com.ecom.express.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<com.ecom.express.entity.User, Long> {
    // Additional query methods can be defined here if needed
    
}
