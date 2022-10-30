package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.absracts.LanguageService;
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
	public List<Language> getAll() {
		
	return	languageRepository.getAll();
	
	}

	@Override
	public Language getById(int id) {
		
		return languageRepository.getById(id);
	}

	@Override
	public void add(Language language) {
		
		if(checkLanguageNameValid(language))
			throw new RuntimeException("Programlama Dili Boş Geçilemez ! ");
		
		if(isLanguageExists(language))
			throw new RuntimeException("Zaten Programlama dili mevcut.");
			
		
		languageRepository.add(language);
		
	}

	@Override
	public void update(Language language, int id) {
		
		if(checkLanguageNameValid(language))
			throw new RuntimeException("Programlama Dili Boş Geçilemez ! ");
		
		if(isLanguageExists(language))
			throw new RuntimeException("Zaten Programlama dili mevcut.");
			
		
		languageRepository.update(language, id);
		
	}

	@Override
	public void delete(int id) {
		
		languageRepository.delete(id);
		
	}
	
	public boolean checkLanguageNameValid(Language language) 
	{
		return language.getName().isEmpty() || language.getName().isBlank();
	}
	
	public boolean isLanguageExists(Language language) 
	{
		return languageRepository.getAll().stream()
				.anyMatch(x -> x.getName().equals(language.getName()));
	}
	
	
	
}
