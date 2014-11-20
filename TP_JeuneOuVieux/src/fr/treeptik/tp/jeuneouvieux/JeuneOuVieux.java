package fr.treeptik.tp.jeuneouvieux;

import java.util.Scanner;
import java.math.*;

public class JeuneOuVieux {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int age;
		System.out.println("entrer votre age");
		age = scanner.nextInt();
		
		//test inferieur à 20
		if(age<20) System.out.println("vous etes jeune");
		else if (age>60) System.out.println("vous etes vieux");
		else if (20 <= age && age <=30) {
			System.out.println("vous n'êtes plus tout jeune et pas complètement vieux");
		}

	}

}
