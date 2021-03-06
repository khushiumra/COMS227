package miniassignment1;

import java.lang.Object;

public class S2020Mini1 {
	

	/** Returns the number of positions in which the input strings differ
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	
	public static int countDifferences(java.lang.String s, java.lang.String t)
	{
		//Find the length of the string with smaller length
		int minLength = Math.min(s.length(), t.length());
		
		//Diff keeps track of number of differences
		int diff = 0;
		
		//Iterate over each character of the smaller string
		for(int i =0; i < minLength; i++)
		{
			//Compare the characters of both strings at index i
			if(s.charAt(i) != t.charAt(i))
			//Increase diff by 1 if the characters do not match
				diff++;
		}
		
		//Increase diff by the difference in length of the strings
		diff += Math.abs(s.length() - t.length());
		
		
		//Return the number of differences, i.e., diff
		return diff;
	}
	
	
	/**Find the smallest occurance of the smallest character in the string
	 * Returns its index
	 * @param s
	 * @return
	 */

	public static int findSmallest(java.lang.String s)
	{
		char temp = s.charAt(0);
		int index;
		
		for(int i =0; i < s.length(); i++)
		{
			if(temp > s.charAt(i))
			{
				temp = s.charAt(i);
			}
			
		}
		
		index = s.indexOf(temp);
		return index;
	}
	
	/**Returns true if seq is a geometric sequence
	 * The values in seq change by a constant multiple
	 * @param seq
	 * @return
	 */
	
	public static boolean isGeometric(java.lang.String seq)
	{
		String[] s = seq.split(",");
		
		for(int i =0; i < s.length -1; i++)
		{
			int a = Integer.parseInt(s[i]);
			int b = Integer.parseInt(s[i+1]);
			
			if(a*2 != b)
				return false;
		}
		
		return true;
	}
	
	/**Returns the index of the start of the next instance of sub
	 * Or after index start, or -1 if substring doesn't occur after the index
	 * @param s
	 * @param sub
	 * @param start
	 * @return
	 */
	
	public static int nextIndexOf(java.lang.String s, java.lang.String sub, int start)
	{
		//Iterate over the indices of string s starting from start+1
		for(int i = start+1; i < s.length(); i++)
		{
			//Check if the substring's length exceeds that of the remaining string in s
			
			if(i+sub.length() > s.length())
			{
				return -1;
			}
			
	//Extract the substring from s starting from index i whose length is equal to that of string sub
		
			String Substr = s.substring(i,i+sub.length());
			
		//Return the index i if the extracted substring matches the string sub
			
			if(Substr.contentEquals(sub))
			{
				return i;
			}
		}
			
			return -1;
		}
	
	/**Returns a new string constructed from the input 
	 * All instances of characters not next to an equivalent character in the input are removed 
	 * @param s
	 * @return
	 */
	
	public static java.lang.String removeSingles(java.lang.String s)
	{
		String answer = "";
		
		int j;  // characters after i
		int i = 0;  // cursor
		
		while(i < s.length() - 1)
		{
			
			for(j = 1; i+j < s.length() && s.charAt(i) == s.charAt(i+j); j++)
			{
				if(j == 1)
				{
					answer += s.charAt(i);
				}
				
				answer += s.charAt(i);
			}
			
			i +=j;
		}
		
		return answer;
	}
	
	/**An instance of Random r, an upper bound, limit, sequence length, length
	 * Returns the number of random numbers generated after reading the first ascending
	 * sequence of numbers of length 'length'
	 * @param r
	 * @param limit
	 * @param length
	 * @return
	 */
	
	public static int sequenceOfLength(java.util.Random r, int limit, int length)
	{
		
		int count_total = 0; //Keeps track of total number of random numbers generated
		
		int count_sequence = 0; //Keeps track of the count of numbers in the current sequence
		
		int prev_rand = r.nextInt(limit); // Helper variable to use in the subsequent while loop
		
		count_total++;
		count_sequence++;
		
		int rand; // Random number generated in the while loop
		
	//Generate numbers until the sequence of required length isn't obtained
		while(count_sequence != length)
		{
			rand = r.nextInt(limit); //Generate the random number
			count_total++;
		
	//Check if the current generated random number is consecutive to the previous one
				
			if(rand - prev_rand == 1)
		
				//Increase count_sequence by 1
					count_sequence++;
				
				else
					
		//Reset the count_sequence otherwise
					count_sequence = 1;
				
		//Set previous rand to current generated random number
				prev_rand = rand;
		}
		
		//return the total number of generated random numbers
		return count_total;
		}
	
	
	/**Calculates the square root of d using newton's method
	 * 
	 * @param d
	 * @return
	 */
	
	public static double squareRoot(double d)
	{
		if(d < 0)
		{
			return Double.NaN;
		}
		
		double epsilon = 1e-15;
		double t = d;
		
		while(Math.abs(t - d/t) > epsilon*t)
		
			t = (d/t + t) / 2.0;
			return t;
		
	}

}
