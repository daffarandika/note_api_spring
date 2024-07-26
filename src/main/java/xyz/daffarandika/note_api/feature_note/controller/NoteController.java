package xyz.daffarandika.note_api.feature_note.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.daffarandika.note_api.feature_note.dto.CreateNoteRequest;
import xyz.daffarandika.note_api.feature_note.dto.CreateNoteResponse;
import xyz.daffarandika.note_api.feature_note.dto.GetNotesResponse;
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

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> createNote(@Valid @ModelAttribute CreateNoteRequest createNoteRequest) {
		try {
			CreateNoteResponse response = noteService.createNote(createNoteRequest);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}

	@GetMapping("/test")
	public ResponseEntity<?> getNoteContent() {
		try {
			String con = noteService.getMarkdownFileAsPlainText("strat.py");
			return ResponseEntity.ok(con);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping
	public List<GetNotesResponse> getAllNotes() {
		return noteService.getAllNotes();
	}

	@PostMapping(path = "/file",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadNote(@ModelAttribute @Valid CreateNoteRequest request) {
		System.out.println("<=> file" + request);
		return ResponseEntity.ok(request.toString());
	}

}