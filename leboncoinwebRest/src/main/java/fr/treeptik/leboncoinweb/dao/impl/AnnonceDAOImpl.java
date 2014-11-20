package fr.treeptik.leboncoinweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.treeptik.leboncoinweb.dao.AnnonceDAOCustom;
import fr.treeptik.leboncoinweb.exception.DAOException;
import fr.treeptik.leboncoinweb.pojo.Annonce;

public class AnnonceDAOImpl implements AnnonceDAOCustom{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Annonce> findAllOrderByPrice(Boolean asc) throws DAOException {
			List<Annonce> liste = new ArrayList<Annonce>();
			String orderBy = "DESC";
			if (asc) {
				orderBy = "ASC";
			}
			try {
				TypedQuery<Annonce> query = entityManager.createQuery(
						"select a from Annonce a order by a.price " + orderBy,
						Annonce.class);
				liste = query.getResultList();
			} catch (PersistenceException e) {
				throw new DAOException(e, "Erreur findAllOrderByPrice");
			}
			return liste;
	}

	@Override
	public List<Annonce> find(String localisation, Float prixMin,
			Float prixMax, Boolean asc) throws DAOException {
		String requete = "Select a from Annonce a ";
		if (localisation != null) {
			requete += "where a.localisation like '%" + localisation + "%' ";
			if (prixMin != null && prixMax != null) {
				 requete += "and a.price between "+prixMin+" and "+prixMax+" ";
			}
		} else {
			if (prixMin != null && prixMax != null) {
				 requete += "where a.price between "+prixMin+" and "+prixMax+" ";
			}
		}
		if(asc!=null){
			if(asc){
				requete +="order by a.price ASC ";
			}else{
				requete +="order by a.price DESC ";
			}
		}
		
		List<Annonce> liste = new ArrayList<Annonce>();
		try {
			TypedQuery<Annonce> query = entityManager.createQuery(
					requete,
					Annonce.class);
			liste = query.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException(e, "Erreur find");
		}
		return liste;
	}
}
