package fr.treeptik.serviceIMpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.FactureDAO;
import fr.treeptik.pojo.Facture;
import fr.treeptik.service.FactureService;
@Service
public class FactueServiceImpl implements FactureService{
@Autowired
private FactureDAO factureDAO;


	public void saveFacture(Facture f) {
		factureDAO.save(f);
	}
public List<Facture> findByMontantGreaterThanEqual(Double montant){
	List<Facture> list = factureDAO.findByMontantGreaterThanEqual(montant);
	return list;
}
public Facture find(Integer id) {
	return factureDAO.test(id);
	
}
public List<Facture> findAllCustom(){
	return factureDAO.customMethod();
}
}
