package lab6;

import java.util.Scanner;

public class StringUtil {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the full name:");
		String name = sc.nextLine();
		
		String initial = initials_Finding(name);
		
		System.out.println("Initials: " + initial);
		
		System.out.println("Enter String to find first vowel index in it: ");
		
		String str = sc.nextLine();
		
		int index = index_Vowel(str);
		System.out.println("Index of first vowel in " + str + "is: " + index);
	}
	
	public static String initials_Finding(String name)
	{
		String initial = "";
	    String a[] = name.split(" ");
	    
	    for(int i =0; i<a.length; i++)
	    
	    	initial = initial.concat(Character.toString(a[i].charAt(0)));
	    	
	    	return initial;
	}
	
	public static int index_Vowel(String str)
	{
		int index;
		
		for(int i =0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			
			if("aeiouAEIOU".indexOf(ch) >= 0)
			{
				index = i;
				return index;
			}
		}
		
		return -1;
	}
		
	}
