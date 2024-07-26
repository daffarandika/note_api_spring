package xyz.daffarandika.note_api.feature_note.service;

import org.springframework.core.io.Resource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import xyz.daffarandika.note_api.feature_file.FileStorageService;
import xyz.daffarandika.note_api.feature_note.dto.CreateNoteRequest;
import xyz.daffarandika.note_api.feature_note.dto.CreateNoteResponse;
import xyz.daffarandika.note_api.feature_note.dto.GetNotesResponse;
import xyz.daffarandika.note_api.feature_note.model.Category;
import xyz.daffarandika.note_api.feature_note.model.Note;
import xyz.daffarandika.note_api.feature_note.repository.NoteRepository;
import xyz.daffarandika.note_api.core.utils.SecurityContextUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final FileStorageService fileStorageService;

    public NoteService(NoteRepository noteRepository, FileStorageService fileStorageService) {
        this.noteRepository = noteRepository;
        this.fileStorageService = fileStorageService;
    }

    public List<GetNotesResponse> getAllNotes() {
        return noteRepository.findAll()
                .stream()
                .map(GetNotesResponse::new)
                .collect(Collectors.toList());
    }

    public String getMarkdownFileAsPlainText(String filename) {
        try {
            Resource resource = fileStorageService.load(filename);
            return fileStorageService.loadAsPlainText(resource);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public CreateNoteResponse createNote(CreateNoteRequest request) {
        try {
            List<Category> categories = Arrays.stream(request.getCategories().split(","))
                    .map(String::trim)
                    .map(Category::new)
                    .toList();
            noteRepository.save(new Note(request, SecurityContextUtils.getUserId(), categories));
            MultipartFile file = request.getContent();
            fileStorageService.save(file);
            return new CreateNoteResponse(request.getTitle(), request.getCreatedAt());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }


}
