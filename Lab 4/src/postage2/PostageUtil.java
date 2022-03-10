package postage2;

public class PostageUtil {
		
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
		    	if(weight > 1)
		    	{
		    		Cost = 0.47 + Math.ceil(weight - 1) * 0.21;
		    	}
		    	else
		    		if(weight > 3.5)
		    		{
		    		Cost = 0.94 + Math.ceil(weight - 1) * 0.21;
		    		}
		    		else
		    			Cost = 0.47 + Math.ceil(weight -1) * 0.21;
		    return Cost;
		  }

}
