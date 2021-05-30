package com.finovate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.finovate.model.User;

import java.util.Optional;

//Interface extending the Jpa repository to access database values.
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmailId(String email);
}
