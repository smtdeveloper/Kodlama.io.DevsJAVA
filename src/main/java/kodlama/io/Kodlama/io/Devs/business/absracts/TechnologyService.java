package kodlama.io.Kodlama.io.Devs.business.absracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.TechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.TechnologyResponse;

public interface TechnologyService {

	public List<TechnologyResponse> getAll();
	public TechnologyResponse getResponseById(int id);
	public List<TechnologyResponse> getLanguageByIdList(int id);
	
	public void add(TechnologyRequest request);
	public void update(TechnologyRequest request, int id);
	public void delete(int id);
	
}
