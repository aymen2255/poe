package fr.treeptik.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.treeptik.model.User;

public interface UserService{
	void create(User user);
	List<User> getAllUsers();
	void delete(User user);
	void update (User user);
	void sendMail(HttpServletRequest req, HttpServletResponse res, User user);
}
