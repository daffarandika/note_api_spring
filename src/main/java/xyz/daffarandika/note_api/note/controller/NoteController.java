package xyz.daffarandika.note_api.note.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import xyz.daffarandika.note_api.note.dto.CreateNoteRequest;
import xyz.daffarandika.note_api.note.dto.CreateNoteResponse;
import xyz.daffarandika.note_api.note.model.Note;
import xyz.daffarandika.note_api.note.repository.NoteRepository;
import xyz.daffarandika.note_api.note.service.NoteService;

/**
 * NoteController
 */
@RestController
@RequestMapping("/api/note")
public class NoteController {

	private final NoteService noteService;

	public NoteController(NoteService noteService, NoteRepository noteRepository) {
		this.noteService = noteService;
	}

	@PostMapping
	public ResponseEntity<?> createNote(@Valid @RequestBody CreateNoteRequest createNoteRequest) {
		try {
			CreateNoteResponse response = noteService.createNote(createNoteRequest);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping("/")
	public List<Note> getAllNotes() {
		return noteService.getAllNotes();
	}

}