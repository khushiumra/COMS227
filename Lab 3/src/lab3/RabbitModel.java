package lab3;


/**
	 * A RabbitModel is used to simulate the growth
	 * of a population of rabbits. 
	 */

	public class RabbitModel
	
	{
		private int size;
		private int lastyear;
		private int yearbefore;
		
	 
	  /**
	   * Constructs a new RabbitModel.
	   */
		
	  public RabbitModel()
	  {
	    size = 0;
	    lastyear = 1;
	    yearbefore = 0;
	  }  
	 
	  /**
	   * Returns the current number of rabbits.
	   * @return
	   *   current rabbit population
	   */
	  
	  public int getPopulation()
	  {
	  
	    return size;
	  
	  }
	  
	  /**
	   * Updates the population to simulate the
	   * passing of one year.
	   */
	  
	  public void simulateYear()
	  {
	    size=lastyear+yearbefore;
	   
	  }
	  
	  /**
	   * Sets or resets the state of the model to the 
	   * initial conditions.
	   */
	  
	  public void reset()
	  {
	    size = 0;
	    lastyear = 1;
	    yearbefore = 0;
	   
	  }
	}

