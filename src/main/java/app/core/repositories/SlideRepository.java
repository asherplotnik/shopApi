package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import app.core.entities.Slide;

public interface SlideRepository extends JpaRepository<Slide,Integer>{
	
	Slide getByOriginal(String original);

}
