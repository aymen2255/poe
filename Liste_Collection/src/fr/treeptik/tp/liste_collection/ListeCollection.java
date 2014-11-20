package fr.treeptik.tp.liste_collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListeCollection {

	public static void main(String[] args) {
		
		ListeCollection test = new ListeCollection();
		//test.getChaine();
		test.tesSet();

	}
public String getChaine(){
	
	List<String> liste = Arrays.asList("a", "b", "c", "d");
	Collections.reverse(liste);
	for (String string : liste) {
		System.out.println(string);
	}
	return null;
}
public String getListeTrieAlphabetique(){
	List<String> liste = Arrays.asList("a", "x", "b", "d");
	Collections.sort(liste);
	for (String string : liste) {
		System.out.println(string);
	}
	return null;
	
}

public String tesSet(){
	
	Set<String> liste = new HashSet<String>();
	liste.add("a");
	liste.add("bb");
	liste.add("ccc");
	liste.add("a");
	for (String string : liste) {
		System.out.println(string);
	}
	return null;
	
}

}
