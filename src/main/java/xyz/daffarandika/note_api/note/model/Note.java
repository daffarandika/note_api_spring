package xyz.daffarandika.note_api.note.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import xyz.daffarandika.note_api.category.model.NotesCategory;
import xyz.daffarandika.note_api.note.dto.CreateNoteRequest;

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

	@OneToMany(mappedBy = "note")
	private List<NotesCategory> notesCategories;

	public Note(CreateNoteRequest createNoteRequest, Integer authorId) {
		this.title = createNoteRequest.getTitle();
		this.contentPath = createNoteRequest.getContentPath();
		this.authorId = authorId;
		this.createdAt = new Date();
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
