package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;

import fr.treeptik.dao.DAOFactory;
import fr.treeptik.jpaUtil.JPAUtil;
import fr.treeptik.model.Annonce;

public class AnnonceDAOImpl extends GenericDaoImpl<Annonce, Integer> {
	public List<Annonce> getAllAnnonce() {
		List<Annonce> annonces = DAOFactory.getAnnonceDAO().findAll(
				Annonce.class);
		return annonces;
	}

	public Annonce findAnnonceById(Integer id) {

		Annonce annonce = JPAUtil.getEntityManager().find(Annonce.class, id);
		// Annonce annonce=DAOFactory.getAnnonceDAO().findById(id);

		return annonce;
	}

	public List<Annonce> findByTitle(String title) {
		TypedQuery<Annonce> query = JPAUtil
				.getEntityManager()
				.createQuery("select a from Annonce a where a.titre =:titre",
						Annonce.class).setParameter("titre", title);
		List<Annonce> list = query.getResultList();
		return list;

	}
	public List<Annonce> findByPrix(Integer min, Integer max){
		return JPAUtil
				.getEntityManager().createQuery("select a from Annonce a where a.prix BETWEEN :min AND :max" ,Annonce.class ).setParameter("min", min).setParameter("max", max).getResultList();
		
	}
}
