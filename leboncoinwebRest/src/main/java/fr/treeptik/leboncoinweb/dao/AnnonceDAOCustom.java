package fr.treeptik.leboncoinweb.dao;

import java.util.List;

import fr.treeptik.leboncoinweb.exception.DAOException;
import fr.treeptik.leboncoinweb.pojo.Annonce;

public interface AnnonceDAOCustom {

	List<Annonce> findAllOrderByPrice(Boolean asc)throws DAOException;
	List<Annonce> find(String localisation,Float prixMin,Float prixMax,Boolean asc) throws DAOException;
}
