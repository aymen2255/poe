package fr.treeptik.tp.perroquet;

import java.util.Scanner;

public class Perroquet {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		boolean verif=sc.hasNext();
		
		while(verif){
			String saisie = sc.next();
			if(saisie.equalsIgnoreCase("quit"))break;
			System.out.println(saisie);
			
			
		}

	}

}
