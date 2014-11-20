package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.AnnonceDAO;
import fr.treeptik.jsoup.JSOUPUtil;
import fr.treeptik.model.Annonce;
@Repository
public class AnnonceDAOImpl extends GenericDaoImpl<Annonce, Integer> implements AnnonceDAO{

	@PersistenceContext
	protected EntityManager em;
	public AnnonceDAOImpl() {
		super(Annonce.class);
		
	}
	public void importAnnonces() {
		List<Annonce> annonces = JSOUPUtil.getJsoup();
		for (Annonce annonce : annonces) {
			em.persist(annonce);
		}
		
	}
	
}
