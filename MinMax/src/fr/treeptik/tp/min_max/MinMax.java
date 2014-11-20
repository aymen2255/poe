package fr.treeptik.tp.min_max;

import java.util.Scanner;

public class MinMax {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Max : 1");
		System.out.println("Min : 2");
		
		if (sc.nextInt() == 1) {
			System.out.println("entier un 1er entier");
			int x = sc.nextInt();
			System.out.println("entier un 1er entier");
			int y = sc.nextInt();
			MinMax test = new MinMax();
			System.out.println("le max est: " + test.getMax(x, y));
		} else {
			System.out.println("entier un 1er entier");
			int x = sc.nextInt();
			System.out.println("entier un 1er entier");
			int y = sc.nextInt();
			MinMax test = new MinMax();
			System.out.println("le min est: " + test.getMin(x, y));
		}



	}

	public Integer getMax(int x, int y) {
		int max = 0;
		if (x > y)
			max = x;
		else
			max = y;
		return max;

	}

	public Integer getMin(int x, int y) {
		int min = 0;
		if (x < y)
			min = x;
		else
			min = y;
		return min;

	}
}
