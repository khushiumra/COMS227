package postage1;

import java.util.Scanner;

public class PostageUtil {
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Weight: ");
		double weight = sc.nextDouble();
		System.out.println("Cost: "+computePostage(weight));
	}
	
	public static double Cost;
	
	/**
	   * Returns the cost of postage for a letter of the given weight.
	   * @param weight
	   *   given weight in ounces
	   * @return
	   *   cost of postage for the weight
	   */
	  public static double computePostage(double weight)
	  {
	    if (weight <= 1)
	    {
	      Cost = 0.47;
	    }
	    else
	    	if(weight <= 3.5)
	    	{
	    		Cost = 0.47 + Math.ceil(weight - 1) * 0.21;
	    	}
	    	else
	    		Cost = 0.94 + Math.ceil(weight - 1) * 0.21;
	    
	    return Cost;
	  }

}
