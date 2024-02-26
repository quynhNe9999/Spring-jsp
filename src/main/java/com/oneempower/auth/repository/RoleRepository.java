package com.oneempower.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneempower.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
   // Role findByUsername(String name);

}
