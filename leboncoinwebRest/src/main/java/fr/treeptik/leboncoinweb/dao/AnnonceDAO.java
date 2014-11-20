package fr.treeptik.leboncoinweb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.treeptik.leboncoinweb.exception.DAOException;
import fr.treeptik.leboncoinweb.pojo.Annonce;

public interface AnnonceDAO extends JpaRepository<Annonce, Integer>,AnnonceDAOCustom{
	
	// TODO : mettre les @Query("select ...")
	@Query("select a from Annonce a where a.localisation like :localisation ")
	List<Annonce> findByLocalisation(@Param("localisation")String localisation) throws DAOException;
	@Query("select a from Annonce a where a.price between :min and :max ")
	List<Annonce> findByPriceBetween(@Param("min")Float min,@Param("max")Float max) throws DAOException;
	@Query("select a from Annonce a order by a.count Desc")
	List<Annonce> findOrderByCount()throws DAOException;
	@Query("select a from User u left join u.annonces a where u.id=:id ")
	List<Annonce> findByUser(@Param("id")Integer u) throws DAOException;
	
	
	@Query("Select a From Annonce a Where (?1 is null or ?1='' or "
			+ "LOWER(a.description) LIKE concat('%',?1,'%')) AND "
			+ "(?2 is null or ?2='' or LOWER(a.localisation) LIKE concat('%',?2,'%'))  AND "
			+ "(?3 is null or a.price >?3) AND "
			+ "(?4 is null or a.price < ?4) ")
	
	List<Annonce> findBySearchRequest(String desc, String loc, Float min, Float max);
	
}
