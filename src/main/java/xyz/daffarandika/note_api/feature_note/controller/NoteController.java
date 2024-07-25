package xyz.daffarandika.note_api.feature_note.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.daffarandika.note_api.feature_note.dto.CreateNoteRequest;
import xyz.daffarandika.note_api.feature_note.dto.CreateNoteResponse;
import xyz.daffarandika.note_api.feature_note.dto.GetNotesResponse;
import xyz.daffarandika.note_api.feature_note.model.Note;
import xyz.daffarandika.note_api.feature_note.repository.NoteRepository;
import xyz.daffarandika.note_api.feature_note.service.NoteService;

/**
 * NoteController
 */
@RestController
@RequestMapping("/api/note")
public class NoteController {

	private final NoteService noteService;

	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}

	@PostMapping
	public ResponseEntity<?> createNote(@Valid @RequestBody CreateNoteRequest createNoteRequest) {
		try {
			CreateNoteResponse response = noteService.createNote(createNoteRequest);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping
	public List<GetNotesResponse> getAllNotes() {
		return noteService.getAllNotes();
	}

}