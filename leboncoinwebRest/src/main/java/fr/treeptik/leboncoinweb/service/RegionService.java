package fr.treeptik.leboncoinweb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.leboncoinweb.dao.AnnonceDAO;
import fr.treeptik.leboncoinweb.dao.RegionDAO;
import fr.treeptik.leboncoinweb.dao.UserDAO;
import fr.treeptik.leboncoinweb.exception.ServiceException;
import fr.treeptik.leboncoinweb.pojo.Annonce;
import fr.treeptik.leboncoinweb.pojo.Region;
import fr.treeptik.leboncoinweb.pojo.User;
import fr.treeptik.leboncoinweb.utils.JSoupUtils;
@Service
public class RegionService {
	@Autowired
	private RegionDAO dao ;
	@Autowired
	private AnnonceDAO annonceDAO ;
	@Autowired
	private UserDAO userDAO ;
	
	//@Scheduled(fixedDelay=5000)
	public void initData(){
		try {
			this.saveDbFromWebRegion();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<Region> saveDbFromWebRegion() throws ServiceException{
		
		System.out.println("++----- SERVICE ");
		
		List<Region> regions = new ArrayList<Region>();
		try{
			regions = JSoupUtils.getAnnoncesFromWebJ8Region();
			System.out.println("Liste de regions "+regions);
			for (Region region : regions) {
				List<Annonce> annonces = region.getAnnonces();
				System.out.println("Annonces : "+region.getAnnonces());
				for (Annonce annonce : annonces) {
					System.out.println("Annonce : "+annonce);
					annonce = annonceDAO.save(annonce);
				}
				region = dao.save(region);
			}
		}catch(IOException e) {
			throw new ServiceException(e, "Erreur RegionService saveDbFromWebRegion");
		}
		return regions;
	}
	@Transactional
	public void removeAll() throws ServiceException{
		List<Region> regions = dao.findAll();
		for (Region region : regions) {
			dao.delete(region);
		}
		List<User> listUser = userDAO.findAll();
		for (User user : listUser) {
			user.setAnnonces(new ArrayList<Annonce>());
			user = userDAO.save(user);// update
		}
		List<Annonce> list = annonceDAO.findAll();
		for (Annonce annonce : list) {
			annonceDAO.delete(annonce);
		}
	}
	@Transactional
	public List<Region>findAllRegionByPrixMoyenLocDesc() throws ServiceException{
		List<Region> liste = new ArrayList<Region>();
//		try {
////			liste = dao.findAllRegionByPrixMoyenLocDesc();
//		} catch (DAOException e) {
//			throw new ServiceException(e, "Erreur RegionService findAllRegionByPrixMoyenLocDesc");
//		}
		return liste;
	}
	@Transactional
	public Double findAvgFromRegion(Region r) throws ServiceException{
		Double f = null;
//		try {
////			f = dao.findAvgFromRegion(r);
//		} catch (DAOException e) {
//			throw new ServiceException(e, "Erreur RegionService findAvgFromRegion ");
//		}
		return f;
	}
}
