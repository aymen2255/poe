package fr.treeptik.objet;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class TestObjet {

	public static void main(String[] args) {
		Client client = new Client("client1","client1",new Date());
		Employe employe = new Employe("Employe1","Employe1",new Date());
		List<Personne> personnes = Arrays.asList(client,employe);
		afficherPersonne(personnes);
	}

	
	public static void afficherPersonne(List<Personne> personnes){
		for (Personne p : personnes) {
			System.out.println("Nom:"+ p.getNom());
			System.out.println("prenom:"+ p.getPrenom());
		}
		
	}
}
