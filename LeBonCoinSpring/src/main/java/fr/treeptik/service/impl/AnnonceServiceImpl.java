package fr.treeptik.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.AnnonceDAO;
import fr.treeptik.model.Annonce;
import fr.treeptik.service.AnnonceService;

@Service
public class AnnonceServiceImpl implements AnnonceService {
	@Autowired
	AnnonceDAO annonceDAO;

	public List<Annonce> findAllAnnonces() {
		return annonceDAO.findAll();
	}
	@Transactional
	public void importAndSaveAnnonces() {
		annonceDAO.importAnnonces();
		
	}

}
