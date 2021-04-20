package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{
	
	List<Purchase> findByUserId(int id);
	
}
