package fr.treeptik.dao;

import fr.treeptik.dao.impl.VoitureJDBCDAO;

public class DAOFactory {

	public static VoitureDAO getVoitureDAO(){
		return new VoitureJDBCDAO();
	}
}
