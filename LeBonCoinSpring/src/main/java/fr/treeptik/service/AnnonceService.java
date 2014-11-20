package fr.treeptik.service;

import java.util.List;

import fr.treeptik.model.Annonce;


public interface AnnonceService {
	public List<Annonce> findAllAnnonces();
	public void importAndSaveAnnonces();
}
