package fr.treeptik.service;

import fr.treeptik.model.User;

public interface UserService {

	public User create(User user);
	public User findById(Integer id);
}
