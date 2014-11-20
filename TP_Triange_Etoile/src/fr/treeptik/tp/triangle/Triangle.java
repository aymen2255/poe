package fr.treeptik.tp.triangle;

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int taille=0;
		
		System.out.println("entrer la taille");
		taille = scanner.nextInt();
		
		String tab[] = new String[taille];
		tab[0]="*";System.out.println(tab[0]);
		for (int i = 1; i < taille; i++) {
			tab[i] = tab[i-1]+"*";
			
			System.out.println(tab[i]);
		}
	}

}
