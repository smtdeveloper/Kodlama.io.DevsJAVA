package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.absracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.absracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.TechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.TechnologyResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.absracts.TechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.conretes.Language;
import kodlama.io.Kodlama.io.Devs.entities.conretes.Technology;

public class TechnologyManager implements TechnologyService {

	private TechnologyRepository technologyRepository;
	private LanguageService languageService;

	public TechnologyManager(TechnologyRepository technologyRepository, LanguageService languageService) {
		this.technologyRepository = technologyRepository;
		this.languageService = languageService;
	}

	@Override
	public List<TechnologyResponse> getAll() {

		List<Technology> technologies = technologyRepository.findAll();
		List<TechnologyResponse> responses = new ArrayList<>();

		for (Technology technology : technologies) {
			TechnologyResponse technologyResponse = new TechnologyResponse();

			technologyResponse.setName(technology.getName());
			technologyResponse.setLanguageId(technology.getLanguage().getId());
			technologyResponse.setId(technology.getId());
			technologyResponse.setLanguageName(technology.getLanguage().getName());

			responses.add(technologyResponse);
		}

		return responses;
	}

	@Override
	public TechnologyResponse getResponseById(int id) {

		Technology technology = technologyRepository.findById(id);
		TechnologyResponse technologyResponse = new TechnologyResponse();

		technologyResponse.setId(technology.getId());
		technologyResponse.setName(technology.getName());
		technologyResponse.setLanguageName(technology.getLanguage().getName());

		return technologyResponse;

	}

	@Override
	public void add(TechnologyRequest request) {

		Technology technology = new Technology();
		Language language = languageService.getById(request.getLanguageId());

		technology.setName(request.getName());
		technology.setLanguage(language);

		technologyRepository.save(technology);

	}

	@Override
	public void update(TechnologyRequest request, int id) {

		Technology updateTechnology = technologyRepository.findById(id);
		Language updateLanguageId = languageService.getById(request.getLanguageId());

		updateTechnology.setName(request.getName());
		updateTechnology.setLanguage(updateLanguageId);

		technologyRepository.save(updateTechnology);

	}

	@Override
	public void delete(int id) {

		technologyRepository.deleteById(id);

	}

	@Override
	public List<TechnologyResponse> getLanguageByIdList(int id) {

		List<Technology> technologies = technologyRepository.findAll();
		List<TechnologyResponse> responses = new ArrayList<>();

		for (Technology technology : technologies) {

			if (technology.getLanguage().getId() == id) {
				TechnologyResponse technologyResponse = new TechnologyResponse();

				technologyResponse.setName(technology.getName());
				technologyResponse.setLanguageId(technology.getLanguage().getId());
				technologyResponse.setId(technology.getId());
				technologyResponse.setLanguageName(technology.getLanguage().getName());

				responses.add(technologyResponse);
			}

		}

		return responses;

	}

}
