package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.FactureDAO;
import fr.treeptik.dao.FactureDAOCustom;
import fr.treeptik.pojo.Facture;

@Repository
public class FactureDAOImpl implements FactureDAOCustom{
	@PersistenceContext
	private EntityManager em;

	public List<Facture> customMethod() {
return em.createQuery("from Facture f", Facture.class).getResultList();
	}
}
