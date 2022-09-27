package com.example.bigbowlxp.repository;

import com.example.bigbowlxp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
