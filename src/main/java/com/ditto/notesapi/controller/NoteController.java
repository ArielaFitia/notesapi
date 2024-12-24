package com.ditto.notesapi.controller;

import com.ditto.notesapi.model.Note;
import com.ditto.notesapi.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing notes.
 */
@RestController
@RequestMapping("api/v1/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    /**
     * GET /notes - Retrieve all notes.
     * @return List of all notes.
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> note = noteService.getAllNotes();
        return ResponseEntity.ok(note);
    }

    /**
     * GET /notes/{id} - Retrieve note by ID.
     * @param id ID of the note to retrieve.
     * @return The requested note, or 404 Not Found if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /notes - Create a new note.
     * @param note The note to create.
     * @return The created note.
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@Valid @RequestBody Note note) {
        Note createdNote = noteService.createNote(note);
        return ResponseEntity.ok(createdNote);
    }

    /**
     * DELETE /notes/{id} - Delete a note by ID.
     * @param id ID of the note to delete.
     * @return 204 No Content if successful, or 404 Not Found id the note doesn't exist.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
        if(noteService.getNoteById(id).isPresent()) {
            noteService.deleteNoteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
