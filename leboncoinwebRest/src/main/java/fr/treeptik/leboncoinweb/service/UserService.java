package fr.treeptik.leboncoinweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.leboncoinweb.dao.UserDAO;
import fr.treeptik.leboncoinweb.exception.DAOException;
import fr.treeptik.leboncoinweb.exception.ServiceException;
import fr.treeptik.leboncoinweb.pojo.Annonce;
import fr.treeptik.leboncoinweb.pojo.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao ;
	
	@Transactional
	public User save(User u) throws ServiceException{
		u = dao.save(u);
		return u;
	}
	@Transactional
	public User update(User u) throws ServiceException{
		
		u = dao.save(u);// update
		return u;
		
	}
	@Transactional
	public User getUserByLogin(String login) throws ServiceException{
		User u = new User();
		try {
			u = dao.findByLogin(login).get(0);
		} catch (DAOException e) {
			throw new ServiceException(e, "Erreur getUserByLogin");
		}
		return u;
	}

	public List<User> findUserHasAnnonce(Annonce a) throws ServiceException{
		List<User> users = new ArrayList<User>();
		try{
			users = dao.findUserHasAnnonce(a.getId());
		}catch(DAOException e){
			throw new ServiceException(e, "Erreur UserService findUserHasAnnonce");
		}
		return users;
	}

}
