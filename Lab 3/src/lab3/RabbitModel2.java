package lab3;
	
	/**
	 * A RabbitModel is used to simulate the growth
	 * of a population of rabbits. 
	 */

	public class RabbitModel2
	{
		private int size;
	 
	  /**
	   * Constructs a new RabbitModel.
	   */
		
	  public RabbitModel2()
	  {
	    size = 0;
	  }  
	 
	  /**
	   * Returns the current number of rabbits.
	   * @return
	   *   current rabbit population
	   */
	  
	  public int getPopulation()
	  {
	  
	    return size % 5;
	  }
	  
	  /**
	   * Updates the population to simulate the
	   * passing of one year.
	   */
	  
	  public void simulateYear()
	  {
	    size+=1;
	  }
	  
	  /**
	   * Sets or resets the state of the model to the 
	   * initial conditions.
	   */
	  
	  public void reset()
	  {
	    size = 0;
	   
	  }
	}

