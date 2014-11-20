package fr.treeptik.objet;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CollectionObjet {

	public static void main(String[] args) {

		Personne personne1 = new Personne("Personne1", "personne1", new Date());
		Personne personne2 = new Personne("Personne2", "personne2", new Date());
		Personne personne3 = new Personne("Personne3", "personne3", new Date());
		Personne personne4 = new Personne("Personn4", "personne4", new Date());
		Personne personne3bis = new Personne("Personne3", "personne3", new Date());
		List<Personne> personnes = Arrays.asList(personne1, personne2,
				personne4, personne4);
System.out.println(personne3.equals(personne3bis));
System.out.println(personnes.contains(personne3bis));
Collections.sort(personnes, new PersonneComparator());

for (Personne personne : personnes) {
	System.out.println(personne);
	
	
	
}



	}

}
