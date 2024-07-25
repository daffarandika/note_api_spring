package xyz.daffarandika.note_api.feature_note.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import xyz.daffarandika.note_api.feature_note.dto.CreateNoteRequest;
import xyz.daffarandika.note_api.feature_note.dto.CreateNoteResponse;
import xyz.daffarandika.note_api.feature_note.dto.GetNotesResponse;
import xyz.daffarandika.note_api.feature_note.model.Category;
import xyz.daffarandika.note_api.feature_note.model.Note;
import xyz.daffarandika.note_api.feature_note.repository.NoteRepository;
import xyz.daffarandika.note_api.core.utils.SecurityContextUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<GetNotesResponse> getAllNotes() {
        return noteRepository.findAll()
                .stream()
                .map(GetNotesResponse::new)
                .collect(Collectors.toList());
    }

    public CreateNoteResponse createNote(CreateNoteRequest request) {
        try {
            List<Category> categories = Arrays.stream(request.getCategories().split(","))
                    .map(String::trim)
                    .map(Category::new)
                    .toList();
            noteRepository.save(new Note(request, SecurityContextUtils.getUserId(), categories));
            return new CreateNoteResponse(request.getTitle(), request.getCreatedAt());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }


}
