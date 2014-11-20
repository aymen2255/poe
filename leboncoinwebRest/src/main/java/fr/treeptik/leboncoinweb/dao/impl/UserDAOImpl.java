package fr.treeptik.leboncoinweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.treeptik.leboncoinweb.dao.UserDAOCustom;
import fr.treeptik.leboncoinweb.exception.DAOException;
import fr.treeptik.leboncoinweb.pojo.User;

public class UserDAOImpl implements UserDAOCustom{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<User> findUserHasAnnonce(Integer a) throws DAOException {
		
		List<User> liste = new ArrayList<User>();
		
		try {
			TypedQuery<User> query = entityManager.createQuery(
					"select u from User u join fetch u.annonces a where a.id=:id",
					User.class).setParameter("id", a);
			liste = query.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException(e, "Erreur findUserHasAnnonce");
		}
		return liste;
	}

}
