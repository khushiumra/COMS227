package lab5;

public class Basketball {
	
	private boolean isInflated;  /* Inflation status of this Basketball.*/
	  
	  private double diameter;   /*Diameter of this Basketball.*/
	
	public Basketball(double givenDiameter)
	  {
		isInflated = false;
	    diameter = givenDiameter;
	  }

	  public boolean isDribbleable()
	  {
	    return isInflated;
	  }

	  public double getDiameter()
	  {
	    return diameter;
	  }

	  public double getCircumference()
	  {
	    double result = Math.PI * diameter;   // PI times the diameter
	    return result;
	  }

	  public void inflate()
	  {
		  isInflated = true;
	  }
	
}
