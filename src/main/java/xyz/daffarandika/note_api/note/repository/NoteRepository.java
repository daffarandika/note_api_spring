package xyz.daffarandika.note_api.note.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.daffarandika.note_api.note.model.Note;

/**
 * NoteRepository
 */
@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> { }
