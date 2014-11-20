package fr.treeptik.runtime;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.treeptik.pojo.Client;
import fr.treeptik.pojo.Facture;
import fr.treeptik.service.ClientService;
import fr.treeptik.service.FactureService;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		ClientService service = context.getBean(ClientService.class);
		Client client= new Client(null, "toto", "toto");
		service.save(client);
		
		Facture facture = new Facture(null, client, 17.56);
		FactureService factureService = context.getBean(FactureService.class);
		factureService.saveFacture(facture);
		
		
		List<Facture> list = factureService.findByMontantGreaterThanEqual(100.00);
		System.out.println(list.size());
		System.out.println(factureService.find(1).getClient().getNom());
		List<Facture> factures = factureService.findAllCustom();
		for (Facture facture2 : factures) {
			System.out.println("***************++++++"+facture2.getId());
		}

	}

}
