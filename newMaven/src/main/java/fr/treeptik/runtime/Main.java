package fr.treeptik.runtime;

import fr.treeptik.dao.DAOFactory;
import fr.treeptik.dao.VoitureDAO;
import fr.treeptik.pojo.Voiture;
import fr.treeptik.utils.ConnectionUtils;

public class Main {

	public static void main(String[] args) {
		Voiture v = new Voiture("marque8888","model17777");
		VoitureDAO voitureDAo= DAOFactory.getVoitureDAO();
		try {
			voitureDAo.save(v);
			ConnectionUtils.commitTX();
			//System.out.println(v);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
