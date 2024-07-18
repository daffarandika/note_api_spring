package xyz.daffarandika.note_api.note;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import xyz.daffarandika.note_api.category.Category;

/**
 * Note
 */
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue
    private Long noteId;
    private String title;
    private String content;

    @ManyToMany(
		fetch = FetchType.LAZY, 
		cascade = {CascadeType.PERSIST, CascadeType.MERGE}
	)
    @JoinTable(name = "notes_categories",
               joinColumns = @JoinColumn(name = "note_id"),
               inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    // Getters and setters
}
