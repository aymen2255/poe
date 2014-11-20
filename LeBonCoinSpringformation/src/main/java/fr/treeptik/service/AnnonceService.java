package fr.treeptik.service;

import java.util.List;

import fr.treeptik.dao.DAOFactory;
import fr.treeptik.model.Annonce;

public class AnnonceService {
	public Annonce getAnnonceById(Integer id) {
		Annonce annonce = DAOFactory.getAnnonceDAO().findAnnonceById(id);
		return annonce;

	}
	public List<Annonce> getAllAnnonce(){
		return DAOFactory.getAnnonceDAO().getAllAnnonce();
	}
	public List<Annonce> findByTitle(String title){
		return DAOFactory.getAnnonceDAO().findByTitle(title);
	}
	public List<Annonce> findByPrix(Integer min, Integer max){
		return DAOFactory.getAnnonceDAO().findByPrix(min, max);
		
	}
}
