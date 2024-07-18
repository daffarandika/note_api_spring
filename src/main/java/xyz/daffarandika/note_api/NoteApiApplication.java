package xyz.daffarandika.note_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import xyz.daffarandika.note_api.config.RsaKeyProperty;
import xyz.daffarandika.note_api.note.NoteRepository;

@EnableConfigurationProperties(RsaKeyProperty.class)
@SpringBootApplication
public class NoteApiApplication implements CommandLineRunner {

	private final NoteRepository noteRepository;

	public NoteApiApplication(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(NoteApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
	}

}
