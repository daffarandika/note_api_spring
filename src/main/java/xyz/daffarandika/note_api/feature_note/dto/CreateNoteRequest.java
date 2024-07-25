package xyz.daffarandika.note_api.feature_note.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;

@Getter
public class CreateNoteRequest {

    @Valid

    @NotNull(message = "title cannot be empty")
    @NotBlank(message = "title cannot be empty")
    private final String title;

    @NotNull(message = "contentPath cannot be empty")
    @NotBlank(message = "contentPath cannot be empty")
    private final String contentPath;

    @NotNull(message = "categories cannot be empty")
    @NotBlank(message = "categories cannot be empty")
    private final String categories;

    private final Date createdAt;

    public CreateNoteRequest(String title, String contentPath, String categories) {
        this.title = title;
        this.contentPath = contentPath;
        this.categories = categories;
        this.createdAt = new Date();
    }

}
