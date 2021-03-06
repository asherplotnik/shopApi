package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Stock;

public interface EntryRepository extends JpaRepository<Stock, Integer>{

	List<Stock> findByItemCode(String code);
	
	Stock findByItemCodeAndVariation(String code, String variation);
	
	List<Stock> findByItemId(int id);

}
