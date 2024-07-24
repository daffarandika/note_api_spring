package xyz.daffarandika.note_api.feature_category.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Category
 */
@Entity
@Table(name = "category")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "category")
    List<NotesCategory> notesCategories;

    // @ManyToMany(mappedBy = "categories")
    // private List<Note> notes;

    // Getters and setters
}
