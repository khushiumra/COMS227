package lab8;

import java.util.ArrayList;
import java.util.Arrays;

public class removeDup {

	public static void main (String[] args)
	{
		ArrayList<String> List = new ArrayList<>();
		List.add("Hello");
		List.add("Hi");
		List.add("Bye");
		List.add("Hi");
		List.add("Bye");
		removeDuplicates(List);
		System.out.println(List);
	}
	
	public static void removeDuplicates(ArrayList<String> words)
	{
		for (int i = 0; i < words.size(); i ++)
		{
			for (int j = i + 1; j < words.size(); j ++)
			{
				if (words.get(i).equals(words.get(j)))
				{
					words.remove(j);
					j --;
				}
			}
		}
		
	}
}

