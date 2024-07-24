package xyz.daffarandika.note_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import xyz.daffarandika.note_api.auth.model.User;
import xyz.daffarandika.note_api.auth.repository.UserRepository;
import xyz.daffarandika.note_api.auth.service.AuthService;
import xyz.daffarandika.note_api.auth.service.JpaUserDetailsService;
import xyz.daffarandika.note_api.note.model.Note;
import xyz.daffarandika.note_api.security.RsaKeyProperty;
import xyz.daffarandika.note_api.note.repository.NoteRepository;

import java.util.Date;
import java.util.Optional;

@EnableConfigurationProperties(RsaKeyProperty.class)
@SpringBootApplication
public class NoteApiApplication {

	public NoteApiApplication() {}

	public static void main(String[] args) {
		SpringApplication.run(NoteApiApplication.class, args);
	}

}
