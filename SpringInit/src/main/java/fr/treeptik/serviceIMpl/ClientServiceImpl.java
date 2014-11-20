package fr.treeptik.serviceIMpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.ClientDAO;
import fr.treeptik.pojo.Client;
import fr.treeptik.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
private ClientDAO clientDAO;
	@Autowired
	private FactueServiceImpl factureService;
	
	@Transactional
	public void save(Client client) {
		clientDAO.save(client);
		//factureService.saveFacture("eeee");
	}


}
