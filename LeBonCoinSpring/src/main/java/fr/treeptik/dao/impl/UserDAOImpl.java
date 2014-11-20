package fr.treeptik.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.UserDAO;
import fr.treeptik.model.User;

@Repository
public class UserDAOImpl extends GenericDaoImpl<User, Integer> implements
		UserDAO {

	public UserDAOImpl() {
		super(User.class);
	}

}
