package xyz.daffarandika.note_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import xyz.daffarandika.note_api.config.RsaKeyProperty;

@EnableConfigurationProperties(RsaKeyProperty.class)
@SpringBootApplication
public class NoteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteApiApplication.class, args);
	}

}
