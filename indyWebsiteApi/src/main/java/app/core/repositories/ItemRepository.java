package app.core.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{

	List<Item> findByCollectionName(String collection);
	
	Optional<Item> getByCode(String code);
}
