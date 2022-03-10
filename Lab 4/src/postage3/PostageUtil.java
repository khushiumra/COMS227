package postage3;

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
			  Cost = 0.47;
			  
		    if (weight > 1)
		    {
		      Cost = Cost + Math.ceil(weight - 1) * 0.21;
		    }
		    
		    	if(weight > 3.5)
		    	{
		    		Cost = Cost + 0.47; 
		    	}
		    	else 
		              { return Cost; }
		    
		    return Cost;
		  }

	}
