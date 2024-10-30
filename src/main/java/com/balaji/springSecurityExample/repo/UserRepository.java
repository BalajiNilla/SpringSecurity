package com.balaji.springSecurityExample.repo;

import com.balaji.springSecurityExample.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
