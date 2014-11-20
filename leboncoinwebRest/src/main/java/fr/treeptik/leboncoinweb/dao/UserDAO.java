package fr.treeptik.leboncoinweb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.treeptik.leboncoinweb.exception.DAOException;
import fr.treeptik.leboncoinweb.pojo.User;

public interface UserDAO extends JpaRepository<User, Integer>,UserDAOCustom{
	
	// TODO : mettre les @Query("select ...")
	@Query("select distinct u from User u left join fetch u.annonces a where u.login=:login")
	List<User> findByLogin(@Param("login")String login)throws DAOException;
//	@Query("select u from User u left join fetch u.annonces a where a.id=:id")
//	List<User> findUserHasAnnonce(@Param("id")Integer a)throws DAOException;
}
