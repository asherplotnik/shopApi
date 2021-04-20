package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.PurchaseEntry;

public interface PurchaseEntryRepository extends JpaRepository<PurchaseEntry, Integer>{
	
	List<PurchaseEntry>findByPurchaseId(int id);

}
