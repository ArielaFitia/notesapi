package com.ditto.notesapi.service;

import com.ditto.notesapi.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<Note> getAllNotes();
    Optional<Note>getNoteById(Long id);
    Note createNote(Note note);
    void deleteNoteById(Long id);
}
