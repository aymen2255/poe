package fr.treeptik.objet;

import java.util.Comparator;

public class PersonneComparator implements Comparator<Personne>{

	@Override
	public int compare(Personne o1, Personne o2) {
		
		return o1.getNom().compareToIgnoreCase(o2.getNom());
	}

	
}
