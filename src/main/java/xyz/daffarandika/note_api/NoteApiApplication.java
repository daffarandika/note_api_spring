package xyz.daffarandika.note_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import xyz.daffarandika.note_api.core.security.RsaKeyProperty;
import xyz.daffarandika.note_api.feature_file.FileStorageService;

@EnableConfigurationProperties(RsaKeyProperty.class)
@SpringBootApplication
public class NoteApiApplication implements CommandLineRunner {

	private final FileStorageService fileStorageService;

	public NoteApiApplication(FileStorageService fileStorageService) {
		this.fileStorageService = fileStorageService;
	}

	public static void main(String[] args) {
		SpringApplication.run(NoteApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileStorageService.init();
	}
}
