package com.dynamicProgramming;

import java.util.*;

class longestCommonSubstring {
	public static void main(String[] args) {

		System.out.println("Enter the two strings : ");
		String a, b;
		Scanner sc = new Scanner(System.in);
		a = sc.nextLine();
		b = sc.nextLine();
		int m = a.length();
		int n = b.length();
		int ar[][] = new int[m + 1][n + 1];
		int i;
		int j;
		for (i = 0; i < m + 1; i++)
			for (j = 0; j < n + 1; j++)
				ar[i][j] = 0;

		int l = 0, x = 0, y = 0;
		for (i = 1; i < m + 1; i++) {
			for (j = 1; j < n + 1; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					ar[i][j] = ar[i - 1][j - 1] + 1;
					if (ar[i][j] >= l) {
						l = ar[i][j]; // l holds value of the largest number
										// in
						// the square which
						x = i; // is also the length of longest substring.x
						// and y store its
						y = j; // co-ordinates.
					}
				}
			}
		}

		for (i = 1; i < m + 1; i++) {
			System.out.println();
			for (j = 1; j < n + 1; j++) {
				System.out.print("\t" + ar[i - 1][j - 1]);

			}
		}

		System.out.println("l:" + l + "x:" + x + "y:" + y);
		String lcs = "";
		int k = 0;
		for (i = l; i >= 1; i--) // Storing the largest common substring
		{
			if (ar[x][y] != 0) {
				lcs = a.charAt(x - 1) + lcs;
				x--;
				y--;
			}
		}
		System.out.println("\nLongest Common Substring is :-");
		System.out.println(lcs); // Printing the largest common substring

	}

}
