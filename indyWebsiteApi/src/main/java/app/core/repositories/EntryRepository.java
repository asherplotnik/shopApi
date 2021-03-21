package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Entry;

public interface EntryRepository extends JpaRepository<Entry, Integer>{

	List<Entry> findByItemCode(String code);

}
