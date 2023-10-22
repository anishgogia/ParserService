package com.pie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pie.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
