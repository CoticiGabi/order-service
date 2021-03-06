package com.example.orderservice.repository;

import com.example.orderservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByFirstName(String firstName);
}
