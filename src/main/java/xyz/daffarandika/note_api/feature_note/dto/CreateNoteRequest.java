package xyz.daffarandika.note_api.feature_note.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;

@Getter
public class CreateNoteRequest {

    @Valid

    @NotNull(message = "title cannot be null")
    @NotBlank(message = "title cannot be null")
    private final String title;

    @NotNull(message = "contentPath cannot be null")
    @NotBlank(message = "contentPath cannot be null")
    private final String contentPath;

    private final Date createdAt;

    public CreateNoteRequest(String title, String contentPath) {
        this.title = title;
        this.contentPath = contentPath;
        this.createdAt = new Date();
    }

}
