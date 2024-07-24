package xyz.daffarandika.note_api.feature_note.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import xyz.daffarandika.note_api.feature_note.dto.CreateNoteRequest;
import xyz.daffarandika.note_api.feature_note.dto.CreateNoteResponse;
import xyz.daffarandika.note_api.feature_note.model.Note;
import xyz.daffarandika.note_api.feature_note.repository.NoteRepository;
import xyz.daffarandika.note_api.core.utils.SecurityContextUtils;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public CreateNoteResponse createNote(CreateNoteRequest request) {
        try {
            noteRepository.save(new Note(request, SecurityContextUtils.getUserId()));
            return new CreateNoteResponse(request.getTitle(), request.getCreatedAt());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }

}
