package lab2;

public class Basketball {
	
	/* Model of a basketball for use in quality control simulations */
	
	  private boolean isInflated;  /* Inflation status of this Basketball.*/
	  
	  private double diameter;   /*Diameter of this Basketball.*/
	  
	  /*Constructs an uninflated Basketball with the given diameter. @param givenDiameter , the diameter for this Basketball */
	  
	  public Basketball(double givenDiameter)
	  {
	    isInflated = false;
	    diameter = givenDiameter;
	  }
	  
	  /* Returns the diameter of this Basketball. @return, diameter of this Basketball*/
	  
	  public double getDiameter()
	  {
	    return diameter;
	  }
	  
	  /* Determines whether this Basketball can be dribbled. @return , true if the basketball is inflated, false otherwise */
	  
	  public boolean isDribbleable()
	  {
		  return isInflated;   // can be dribbled only if it is inflated
	    
	  }
	  
	  /* Returns the circumference of this Basketball. @return, circumference of this Basketball */
	  
	  public double getCircumference() /*Inflates this Basketball. */
	  {
	
	    double result = Math.PI * diameter;   // PI times the diameter
	    return result;
	  }
	  
	  
	  public void inflate()
	  {
	    isInflated = true;
	  }
	  

	}

