package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.absracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.conretes.Language;

@Repository 
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languages;
	
	
	
	public InMemoryLanguageRepository() {
		
		languages = new ArrayList<>();
		languages.add(new Language(1 , "C#",true));
		languages.add(new Language(2 , "Java",true));
		languages.add(new Language(3 , "JS",true));
		languages.add(new Language(4 , "PHP",true));
		
	}

	@Override
	public List<Language> getAll() {
		
		return languages;
	}

	@Override
	public Language getById(int id) {
		
		for(Language language : languages) 
		{
			if(language.getId() == id)
				return language;
		}
		
		return null;
	}

	@Override
	public void add(Language language) {
		
		languages.add(language);
		
	}

	@Override
	public void update(Language language, int id) {
		
		Language updateLanguage = getById(id);
		
		updateLanguage.setName(language.getName());
		
		
	}

	@Override
	public void delete(int id) {
		Language language = getById(id);
		languages.remove(language);
		
	}

}
