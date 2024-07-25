package xyz.daffarandika.note_api.feature_note.dto;

import lombok.Getter;
import lombok.Setter;
import xyz.daffarandika.note_api.feature_note.model.Category;
import xyz.daffarandika.note_api.feature_note.model.Note;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class GetNotesResponse {
    private Integer id;
    private Integer authorId;
    private String title;
    private String contentPath;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
    private List<String> categories;

    public GetNotesResponse(Note note) {
        this.id = note.getId();
        this.authorId = note.getAuthorId();
        this.title = note.getTitle();
        this.contentPath = note.getContentPath();
        this.createdAt = note.getCreatedAt();
        this.modifiedAt = note.getModifiedAt();
        this.deletedAt = note.getDeletedAt();
        this.categories = note.getCategories().stream().map(Category::getCategory).toList();
    }
}
