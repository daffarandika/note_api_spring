package xyz.daffarandika.note_api.category.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * CategoryKey
 */
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryKey implements Serializable {

    @Column(name = "note_id")
    private Integer noteId;

    @Column(name = "category_id")
    private Integer categoryId;
}
