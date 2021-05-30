package com.finovate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finovate.model.Note;
import com.finovate.model.User;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    Optional<Note> findByIdAndUser(int id, User user);
    List<Note> findAllByUser(User user);
}
