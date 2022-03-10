package lab3;

import java.util.Random;

/**
	 * A RabbitModel is used to simulate the growth
	 * of a population of rabbits. 
	 */

	public class RabbitModel4
	
	{
		Random rand = new Random(10);
		
		private int size;
		
	 
	  /**
	   * Constructs a new RabbitModel.
	   */
		
	  public RabbitModel4()
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
	  
	    return size;
	  
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

