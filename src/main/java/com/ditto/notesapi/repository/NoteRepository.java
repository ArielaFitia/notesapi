package com.ditto.notesapi.repository;

import com.ditto.notesapi.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
