package fr.treeptik.dao;

import fr.treeptik.model.Annonce;

public interface AnnonceDAO extends Genericdao<Annonce, Integer> {
	public void importAnnonces();
}
