package xyz.daffarandika.note_api.feature_note.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import xyz.daffarandika.note_api.feature_note.dto.CreateNoteRequest;

/**
 * Note
 */
@Entity
@Table(name = "note")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "note_gen")
	@SequenceGenerator(name = "note_gen", sequenceName = "note_id_seq", allocationSize = 1)
    private Integer id;

	@NonNull
	@Column(name = "author_id")
	private Integer authorId;

	@NonNull
	@Column
    private String title;

	@NonNull
	@Column(name = "content_path")
    private String contentPath;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "modified_at")
	private Date modifiedAt;

	@Column(name = "deleted_at")
	private Date deletedAt;

	@ManyToMany(
		cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
		}
	)
	@Fetch(FetchMode.JOIN)
	@JoinTable(
			name = "note_category",
			joinColumns = @JoinColumn(name = "note_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id")
	)
	private List<Category> categories;

	public Note(CreateNoteRequest createNoteRequest, Integer authorId, List<Category> categories) {
		this.title = createNoteRequest.getTitle();
		this.contentPath = Objects.requireNonNull(createNoteRequest.getContent().getOriginalFilename());
		this.authorId = authorId;
		this.createdAt = new Date();
		this.categories  = categories;
	}

	@Override
	public String toString() {
		return "Note{" +
				"id=" + id +
				", title='" + title + '\'' +
				", contentPath='" + contentPath + '\'' +
				", createdAt=" + createdAt +
				", modifiedAt=" + modifiedAt +
				", deletedAt=" + deletedAt +
				'}';
	}
}
