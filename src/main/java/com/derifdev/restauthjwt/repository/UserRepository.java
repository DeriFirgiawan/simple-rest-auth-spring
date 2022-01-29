package com.derifdev.restauthjwt.repository;

import com.derifdev.restauthjwt.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByEmail(String email);
}
