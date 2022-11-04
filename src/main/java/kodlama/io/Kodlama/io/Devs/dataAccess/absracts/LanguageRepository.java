package kodlama.io.Kodlama.io.Devs.dataAccess.absracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Kodlama.io.Devs.entities.conretes.Language;

public interface LanguageRepository extends JpaRepository<Language , Integer> {
	
	Language findById(int id);
	Language findByName(String name);
	
}
