package fr.treeptik.runtime;

import java.sql.SQLException;

import fr.treeptik.exception.DAOException;
import fr.treeptik.pojo.Personne;
import fr.treeptik.simpleorm.orm.Criteria;

public class Main {

	public static void main(String[] args) throws DAOException, ClassNotFoundException, SQLException {
		Criteria<Personne> criteria = new Criteria<Personne>();
		String personne = "personne";
		criteria.list("personne");
	}

}
