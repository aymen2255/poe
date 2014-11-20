package fr.treeptik.serviceImpl;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.treeptik.dao.UserDAO;
import fr.treeptik.model.User;
import fr.treeptik.service.UserService;

@Stateless
public class UserServiceImpl implements UserService {
	@EJB
	UserDAO userDao;
	@EJB
	MailTest mail;
	@Override
	public void create(User user) {
		if (user!=null)
		userDao.create(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.list();
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	public void sendMail(HttpServletRequest req, HttpServletResponse res,User user) {
		try {
			mail.service(req, res,user);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
