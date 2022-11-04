package kodlama.io.Kodlama.io.Devs.dataAccess.absracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Kodlama.io.Devs.entities.conretes.Technology;

public interface TechnologyRepository  extends JpaRepository<Technology,Integer> {
	
	Technology findById(int id);
	
}
