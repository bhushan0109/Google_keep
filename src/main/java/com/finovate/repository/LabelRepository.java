package com.finovate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finovate.model.Label;
import com.finovate.model.User;

import java.util.Optional;
import java.util.Set;

public interface LabelRepository extends JpaRepository<Label, Integer> {
        Optional<Label> findByNameAndUser(String name, User user);
        Optional<Label> findByIdAndUser(int id, User user);
        Set<Label> findAllByUser(User user);
}
