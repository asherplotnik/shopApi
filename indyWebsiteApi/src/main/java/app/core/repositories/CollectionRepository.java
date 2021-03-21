package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Collection;

public interface CollectionRepository extends JpaRepository<Collection,Integer>{
	
	

}
