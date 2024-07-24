package xyz.daffarandika.note_api.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.daffarandika.note_api.note.model.Note;

/**
 * NoteRepository
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> { }
