package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

}
