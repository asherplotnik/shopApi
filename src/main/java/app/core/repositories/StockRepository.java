package app.core.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {
	
	List<Stock> findByItemId(int itemId);
	
	Optional<Stock> findByItemCodeAndVariation(String code, String variation);

}
