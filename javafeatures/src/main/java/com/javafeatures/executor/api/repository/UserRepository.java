package com.javafeatures.executor.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javafeatures.executor.api.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
