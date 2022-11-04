package kodlama.io.Kodlama.io.Devs.business.absracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.LanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.LanguageResponse;
import kodlama.io.Kodlama.io.Devs.entities.conretes.Language;

public interface LanguageService {

	public List<LanguageResponse> getAll();
	public LanguageResponse getResponseById(int id);
	public Language getById(int id);
	
	public void add(LanguageRequest languageRequest) throws Exception;
	public void update(LanguageRequest languageRequest, int id) throws Exception;
	public void delete(int id);
	
}
