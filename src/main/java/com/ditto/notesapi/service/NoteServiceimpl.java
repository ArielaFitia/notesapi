package com.ditto.notesapi.service;

import com.ditto.notesapi.model.Note;
import com.ditto.notesapi.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceimpl implements NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceimpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public Note createNote(Note note) {
        note.setTimestamp(LocalDateTime.now());
        return noteRepository.save(note);
    }

    @Override
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Note updateNote(Long id, Note note) {
        Optional<Note> existingNote = noteRepository.findById(id);
        if (existingNote.isPresent()) {
            Note noteToUpdate = existingNote.get();
            noteToUpdate.setTitle(note.getTitle());
            noteToUpdate.setContent(note.getContent());
            return noteRepository.save(noteToUpdate);
        }
        throw new RuntimeException("Note not found");
    }
}
