package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.absracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.LanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.LanguageResponse;
import kodlama.io.Kodlama.io.Devs.entities.conretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

	private final LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {

		this.languageService = languageService;
	}

	@GetMapping("/getall")
	public List<LanguageResponse> getAll() {
		return languageService.getAll();
	}

	@GetMapping("/{id}")
	public LanguageResponse getById(@PathVariable int id) {
		return languageService.getResponseById(id);
	}

	@PostMapping("/add")
	public void add(@RequestBody LanguageRequest language) throws Exception {
		languageService.add(language);
	}

	@PutMapping("/{id}")
	public void update(@RequestBody LanguageRequest language, @PathVariable int id) throws Exception {
		languageService.update(language, id);

	}

	@DeleteMapping("/{id}")
	public void delele(@PathVariable int id) {
		languageService.delete(id);

	}

}
