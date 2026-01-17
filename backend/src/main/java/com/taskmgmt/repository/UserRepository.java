package com.taskmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmgmt.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
