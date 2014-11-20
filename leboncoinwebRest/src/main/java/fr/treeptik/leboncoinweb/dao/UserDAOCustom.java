package fr.treeptik.leboncoinweb.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fr.treeptik.leboncoinweb.exception.DAOException;
import fr.treeptik.leboncoinweb.pojo.User;

public interface UserDAOCustom {
	List<User> findUserHasAnnonce(Integer a)throws DAOException;
	
}
