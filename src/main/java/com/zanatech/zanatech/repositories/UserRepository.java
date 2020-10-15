package com.zanatech.zanatech.repositories;

import com.zanatech.zanatech.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String userName);
}
