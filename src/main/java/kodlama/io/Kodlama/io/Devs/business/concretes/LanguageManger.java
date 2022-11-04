package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.absracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.LanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.LanguageResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.absracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.conretes.Language;

@Service
public class LanguageManger implements LanguageService {

	LanguageRepository  languageRepository;
	
	
	@Autowired
	public LanguageManger(LanguageRepository languageRepository) {
		
		this.languageRepository = languageRepository;
	}
	
	
	@Override
	public List<LanguageResponse> getAll() {
		
		List<Language> languages = languageRepository.findAll();
		List<LanguageResponse> languageResponses = new  ArrayList<>();
		
		for(Language language : languages)
		{
			LanguageResponse responseItem = new LanguageResponse();
			
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			
			languageResponses.add(responseItem);
		}
		
		return languageResponses;	
	
	}



	@Override
	public void add(LanguageRequest languageRequest) throws Exception {
		
		checkNameValid(languageRequest.getName());
		
        Language language = new Language();
        language.setName(languageRequest.getName());
        
        languageRepository.save(language);
		
	}

	@Override
	public void update(LanguageRequest languageRequest, int id) throws Exception {
		
		checkNameValid(languageRequest.getName());
		
		Language language = languageRepository.findById(id);
		language.setName(languageRequest.getName());
		
		
		languageRepository.save(language);
		
	}

	@Override
	public void delete(int id) {
		
		languageRepository.deleteById(id);
		
		}
	
	private void checkNameValid(String name) throws Exception {
       Language isExist = languageRepository.findByName(name);
        if (isExist != null){
            throw new Exception("Bu isim zaten var ! ");
        }
        if (name.isBlank()){
            throw new Exception("isim boş gecilemez.");
        }
    }


	@Override
	public LanguageResponse getResponseById(int id) {
		
		Language language = languageRepository.findById(id);
		LanguageResponse languageResponse = new LanguageResponse();
		
		languageResponse.setName(language.getName());
		languageResponse.setId(language.getId());
		
		return languageResponse;
		
	}


	@Override
	public Language getById(int id) {
		
		return languageRepository.findById(id);
	}
	
	
	
}
