package fr.treeptik.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import fr.treeptik.dao.UserDAO;
import fr.treeptik.model.User;
@Stateless
public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO{
    @PersistenceContext(unitName = "KitchensinkQuickstartDS", type = PersistenceContextType.EXTENDED)
    private EntityManager em;
	public void create(User user) {
		em.persist(user);
	}

	public User update(User user) {
		em.merge(user);
		return user;
	}

	public void delete(User user) {
		em.remove(user);
		
	}

	public User find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> list() {
	
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u",User.class);
		List<User>users= query.getResultList();
		return users;
	}



}
