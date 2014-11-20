package fr.treeptik.tp1;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculette {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int value;
		int somme=0;
		String saisie = "";
		while (!saisie.equalsIgnoreCase("q"))
			scanner.nextInt();
		System.out.println("combien de nbr voulez vous entrer");
		int nbr=scanner.nextInt();
		ArrayList<Integer> listenbr = new ArrayList<Integer>();
		for (int i = 0; i < nbr; i++) {
			System.out.println("entrer un nombre");
			value = scanner.nextInt();
		listenbr.add(value);
		}
		//affichage de la liste
		for (Integer integer : listenbr) {
			System.out.println(integer);
			somme += integer;
		}
		System.out.println(somme);
		

	}

}
