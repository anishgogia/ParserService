package com.pie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pie.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
