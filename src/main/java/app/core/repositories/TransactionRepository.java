package app.core.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import app.core.entities.Trans;

public interface TransactionRepository extends JpaRepository<Trans,Integer>{
	
	List<Trans> findByStockItemCode(String code);
}
