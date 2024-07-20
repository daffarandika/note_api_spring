package xyz.daffarandika.note_api.note.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * NoteController
 */
@RestController
public class NoteController {

	@GetMapping("/")
	public String home(Principal principal) {
		return "welcome home, " + principal.getName();
	}

}
