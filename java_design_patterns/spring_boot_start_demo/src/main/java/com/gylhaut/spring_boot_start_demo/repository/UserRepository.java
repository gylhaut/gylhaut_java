package com.gylhaut.spring_boot_start_demo.repository;

import com.gylhaut.spring_boot_start_demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    public List<User> findAll();
}
