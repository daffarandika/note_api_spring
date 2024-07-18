package xyz.daffarandika.note_api.category;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import xyz.daffarandika.note_api.note.Note;

/**
 * Category
 */
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    private Long categoryId;
    private String categoryName;

    // @ManyToMany(mappedBy = "categories")
    // private List<Note> notes;

    // Getters and setters
}
