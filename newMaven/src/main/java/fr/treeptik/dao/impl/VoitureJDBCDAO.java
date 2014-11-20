package fr.treeptik.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.treeptik.dao.VoitureDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.pojo.Voiture;
import fr.treeptik.utils.ConnectionUtils;

public class VoitureJDBCDAO implements VoitureDAO {

	@Override
	public Voiture save(Voiture v) throws DAOException{

		
		try {
			Connection connection = ConnectionUtils.getConnection();
			String sql="insert into voiture (marque,modele ) values(?,?)";
			PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, v.getMarque());
			statement.setString(2, v.getModel());
			statement.executeUpdate();
			ResultSet keys = statement.getGeneratedKeys();
			keys.next();
			v.setNoimmatriculation(keys.getInt(1));
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException(e, "VoitureJDBCDAO erreur save"+v);
		}
		return null;
	}

	@Override
	public List<Voiture> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Voiture entite) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer count() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Voiture findByPk(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
