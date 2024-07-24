package xyz.daffarandika.note_api.note.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class CreateNoteResponse {
    private final String title;
    private final Date createdAt;

    public CreateNoteResponse(String title, Date createdAt) {
        this.title = title;
        this.createdAt = createdAt;
    }
}
