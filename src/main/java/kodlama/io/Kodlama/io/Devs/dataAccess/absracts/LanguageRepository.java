package kodlama.io.Kodlama.io.Devs.dataAccess.absracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.conretes.Language;

public interface LanguageRepository {

	public List<Language> getAll();
	public Language getById(int id);
	public void add(Language language);
	public void update(Language language, int id);
	public void delete(int id);
	
}
