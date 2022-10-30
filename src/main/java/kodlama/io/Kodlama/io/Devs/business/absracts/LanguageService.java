package kodlama.io.Kodlama.io.Devs.business.absracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.conretes.Language;

public interface LanguageService {

	public List<Language> getAll();
	public Language getById(int id);
	public void add(Language language);
	public void update(Language language, int id);
	public void delete(int id);
	
}
