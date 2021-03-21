package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{

	List<Item> findByCollectionName(String collection);
	
	Item getByCode(String code);
}
