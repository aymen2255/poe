package fr.treeptik.dao;

import fr.treeptik.pojo.Client;

public interface ClientDAO {
	void save (Client client);
	void remove(Client client);
	
	
}
