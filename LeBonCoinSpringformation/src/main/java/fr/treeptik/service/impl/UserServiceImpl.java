package fr.treeptik.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.UserDAO;
import fr.treeptik.model.User;
import fr.treeptik.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Transactional
	public User create(User user) {
		return userDAO.create(user);

	}

}
