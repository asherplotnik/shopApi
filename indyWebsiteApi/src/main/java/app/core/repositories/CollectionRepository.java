package app.core.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Collection;

public interface CollectionRepository extends JpaRepository<Collection,Integer>{
	
	Optional<Collection> findByName(String name);

}
