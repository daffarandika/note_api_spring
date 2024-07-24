package xyz.daffarandika.note_api.feature_category.model;

import jakarta.persistence.*;
import xyz.daffarandika.note_api.feature_note.model.Note;

/**
 * CategoryKey
 */
@Entity
public class NotesCategory {

    @EmbeddedId
    private CategoryKey id;

    @ManyToOne
    @MapsId("noteId")
    @JoinColumn(name = "note_id")
    private Note note;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private Category category;

}
