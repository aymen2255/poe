package fr.treeptik.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.treeptik.pojo.Facture;

public interface FactureDAO extends JpaRepository<Facture, Integer> {
	public List<Facture> findByMontantGreaterThanEqual(Double montant);
	@Query ("select f from Facture f where f.id = ?1")
	public Facture test(Integer id);
	
	List<Facture> customMethod();
}
