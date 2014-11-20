package fr.treeptik.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.ClientDAO;
import fr.treeptik.pojo.Client;

@Repository
public class ClientDAOImpl implements ClientDAO{
@PersistenceContext
private EntityManager em;
	public void save(Client client) {
		System.out.println("save DAO "+ client.getNom()+ " "+ client.getPrenom());
		em.persist(client);
		
		
	}

	public void remove(Client client) {
		System.out.println("remove DAO "+ client.getId());
		
	}

}
