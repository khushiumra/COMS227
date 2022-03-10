package lab9;

import java.util.Scanner;

public class Pattern {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the size of walkway : ");
		
		int number = sc.nextInt();
		
		int NumPattern = countPatterns(number);
		
		System.out.println("Total way of arranging tiles are : " +NumPattern);
		
		sc.close();
	}
	
	public static int countPatterns(int n)
	{
		
			if(n == 1 || n == 2)
			{
				return 1;
			}
		
		else
		
			if(n==3)
			{
				return 2;
			}
		
		return countPatterns(n-1) + countPatterns(n-3);
	}
}
