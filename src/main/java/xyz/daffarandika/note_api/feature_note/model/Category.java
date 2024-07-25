package xyz.daffarandika.note_api.feature_note.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Integer id;

    @NonNull
    @Column(unique = true)
    private String category;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    List<Note> notes;
}
