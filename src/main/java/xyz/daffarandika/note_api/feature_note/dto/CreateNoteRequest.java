package xyz.daffarandika.note_api.feature_note.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
public class CreateNoteRequest {

    @Valid

    @NotNull(message = "title cannot be empty")
    @NotBlank(message = "title cannot be empty")
    private final String title;

    private final MultipartFile content;

    @NotBlank(message = "categories cannot be empty")
    private final String categories;

    private final Date createdAt;

    public CreateNoteRequest(String title, MultipartFile content, String categories) {
        this.title = title;
        this.content = content;
        this.categories = categories;
        this.createdAt = new Date();
    }

    @Override
    public String toString() {
        return "CreateNoteRequest{" +
                "title='" + title + '\'' +
                ", content=" + content.getOriginalFilename() +
                ", categories='" + categories + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
