package xyz.daffarandika.note_api.note;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * NoteRepository
 */
@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> { }
