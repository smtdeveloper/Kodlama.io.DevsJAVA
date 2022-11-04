package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.absracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.TechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.LanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.TechnologyResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

	private TechnologyService technologyService;

	public TechnologiesController(TechnologyService technologyService) {

		this.technologyService = technologyService;
	}

	@GetMapping("/getall")
	public List<TechnologyResponse> getAll() {
		return technologyService.getAll();
	}
	
	@GetMapping("/{id}")
	public TechnologyResponse getById(@PathVariable int id) {
		return technologyService.getResponseById(id);
	}
	
	@GetMapping("/{id}")
	public List<TechnologyResponse> getLanguageByIdList(@PathVariable int id) {
		return technologyService.getLanguageByIdList(id);
	}
	
	@PostMapping("/add")
    public void add(@RequestBody TechnologyRequest technologyRequest){
        technologyService.add(technologyRequest);
    }
	
	
    @PutMapping("/update/{id}")
    public void update(@RequestBody TechnologyRequest technologyRequest,@PathVariable int id){
        technologyService.update(technologyRequest,id);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        technologyService.delete(id);
    }
	

}
