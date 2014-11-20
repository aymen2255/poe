package fr.treeptik.leboncoinweb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.leboncoinweb.dao.AnnonceDAO;
import fr.treeptik.leboncoinweb.dao.RegionDAO;
import fr.treeptik.leboncoinweb.dao.UserDAO;
import fr.treeptik.leboncoinweb.exception.DAOException;
import fr.treeptik.leboncoinweb.exception.ServiceException;
import fr.treeptik.leboncoinweb.pojo.Annonce;
import fr.treeptik.leboncoinweb.pojo.Region;
import fr.treeptik.leboncoinweb.pojo.SearchRequest;
import fr.treeptik.leboncoinweb.pojo.User;
import fr.treeptik.leboncoinweb.utils.JSoupUtils;
@Service
public class AnnonceService {

	@Autowired
	private AnnonceDAO dao ;
	@Autowired
	private UserDAO userDao;
	@Autowired
	private RegionDAO regionDao ;
	public Annonce save(Annonce a) throws ServiceException{
		a = dao.save(a);
		return a;
		
	}
	@Transactional
	public Annonce update(Annonce a) throws ServiceException{
		a = dao.save(a);
		return a;
	}
	@Transactional
	public List<Annonce> findAll() throws ServiceException{
		List<Annonce> annonces = new ArrayList<Annonce>();
		annonces =  dao.findAll();
		return annonces;
	}
	@Transactional
	public List<Annonce> findAllOrderByPrice(Boolean asc) throws ServiceException{
		List<Annonce> annonces = new ArrayList<Annonce>();
		try{
			annonces = dao.findAllOrderByPrice(asc);
		}catch(DAOException e){
			throw new ServiceException(e, "Erreur AnnonceService findAllOrderByPrice ");
		}
		return annonces;
	}
	@Transactional
	public List<Annonce> findOrderByCount() throws ServiceException{
		List<Annonce> annonces = new ArrayList<Annonce>();
		try{
			annonces = dao.findOrderByCount();
		}catch(DAOException e){
			throw new ServiceException(e, "Erreur AnnonceService findAllOrderByCount");
		}
		return annonces;
	}
	@Transactional
	public List<Annonce> findByLocalisation(String localisation) throws ServiceException{
		List<Annonce> annonces = new ArrayList<Annonce>();
		try{
			annonces = dao.findByLocalisation(localisation);
		}catch(DAOException e){
			throw new ServiceException(e, "Erreur AnnonceService findByLocalisation");
		}
		return annonces;
	}
	@Transactional
	public List<Annonce> findByPriceBetween(Float min, Float max) throws ServiceException{
		List<Annonce> annonces = new ArrayList<Annonce>();
		try{
			annonces = dao.findByPriceBetween(min, max);
		}catch(DAOException e){
			throw new ServiceException(e, "Erreur AnnonceService findByPriceBetween");
		}
		return annonces;
	}
	@Transactional
	public List<Annonce> saveDbFromWeb(Integer nbResultats) throws ServiceException{
		List<Annonce> liste = new ArrayList<Annonce>();
		try {
			liste = JSoupUtils.getAnnoncesFromWebJ8(nbResultats);
			for (Annonce annonce : liste) {
				annonce = dao.save(annonce);
			}
		} catch (IOException e) {
			throw new ServiceException(e, "Erreur AnnonceService saveDbFromWeb");
		}
		return liste;
	}
	@Transactional
	public Annonce getAnnonceById(Integer id) throws ServiceException{
		Annonce a = dao.findOne(id);
		return a;
	}
	@Transactional
	public void removeAll() throws ServiceException{
		List<User> listUser = userDao.findAll();
		List<Region> regions = regionDao.findAll();
		for (Region region : regions) {
			regionDao.delete(region);
		}
		for (User user : listUser) {
			user.setAnnonces(new ArrayList<Annonce>());
			user = userDao.save(user);
		}
		List<Annonce> list = dao.findAll();
		for (Annonce annonce : list) {
			dao.delete(annonce);
		}
	}
	@Transactional
	public List<Annonce> findByUser(User u) throws ServiceException{
		List<Annonce> annonces = new ArrayList<Annonce>();
		try{
			annonces = dao.findByUser(u.getId());
		}catch(DAOException e){
			throw new ServiceException(e, "Erreur AnnonceService findByUser");
		}
		return annonces;
	}
	@Transactional
	public List<Annonce> find(String localisation,Float prixMin,Float prixMax,Boolean asc) throws ServiceException{
		List<Annonce> annonces = new ArrayList<Annonce>();
		try{
			annonces = dao.find(localisation, prixMin, prixMax, asc);
		}catch(DAOException e){
			throw new ServiceException(e, "Erreur AnnonceService find");
		}
		return annonces;
	}
	
	

	public List<Annonce> search(SearchRequest request) {
		return dao.findBySearchRequest(request.getDescription(), request.getLocalisation(), 
				request.getPrixMin(), request.getPrixMax());
	}
}







