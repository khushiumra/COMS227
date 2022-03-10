package lab3;
	
	/**
	 * A RabbitModel is used to simulate the growth
	 * of a population of rabbits. 
	 */

	public class RabbitModel3
	{
		private double size;
	 
	  /**
	   * Constructs a new RabbitModel.
	   */
		
	  public RabbitModel3()
	  {
	    size = 500;
	  }  
	 
	  /**
	   * Returns the current number of rabbits.
	   * @return
	   *   current rabbit population
	   */
	  
	  public double getPopulation()
	  {
	  
	    return size;
	  }
	  
	  /**
	   * Updates the population to simulate the
	   * passing of one year.
	   */
	  
	  public void simulateYear()
	  {
	    size/=2;
	  }
	  
	  /**
	   * Sets or resets the state of the model to the 
	   * initial conditions.
	   */
	  
	  public void reset()
	  {
	    size = 500 ;
	   
	  }
	}

