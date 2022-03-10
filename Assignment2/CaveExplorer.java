package hw2;

import static hw2.Direction.*;
import static hw2.Status.*;

public class CaveExplorer {
	
	public static final int MAX_ENERGY = 100;
	
	private Location location;
	private Map map;
	private int foodItems;
	private int energy;
    private int matches;
    private int clock;
    private boolean findJacket = false;
    private boolean findKey = false;
    private int won;
    private Map area;
    private Location pointer;
    private Status update;
    
    /**
     * Constructor to set all the variables given below by the user
     * @param map - map
     * @param clock - time clock
     * @param energy - initial energy level
     * @param foodItems - number of food items
     * @param matches - number of matches
     * @param initial - initial location
     */
	
	public CaveExplorer(Map map, int clock, int energy, int foodItems, int matches, Location initial)
	{
		this.map = map;
		this.clock = clock;
		this.energy = energy;
		this.foodItems = foodItems;
		this.matches = matches;
		location = initial;
		map.mark(initial, Status.PlAYER);
	}
	
	/**
	 * Constructor to give values to the variables at the given initial location
	 * @param map - a given map
	 * @param initial - initial location of player
	 */
	public CaveExplorer(Map map, Location initial)
	{
		this.map = map;
		clock = 100;
		energy = MAX_ENERGY;
		foodItems = 1;
		matches = 10;
		location = initial;
		map.mark(initial, Status.PlAYER);
	}
	
	/**
	 * Constructor to give values to the variables using the given random generator
	 * @param map - a given map
	 * @param generator - a given Random generator
	 */
	
	public CaveExplorer(Map map, java.util.Random generator)
	{
		this.map = map;
		clock = 100;
		energy = MAX_ENERGY;
		foodItems = 1;
		matches = 10;
		location = new Location(map.getRandomOpenLocation(generator));
		map.mark(location, Status.PlAYER);
	}
	
	/**
	 * Function to jump in the given direction
	 * @param d - direction to jump
	 * @return 
	 * returns true if the jump is successful, or false otherwise
	 */
	
	public boolean jump(Direction d)
	{
		area = map;
		
		int max = 3;
		
		if(energy < 75)
		{
			max  = 2;
		}
		
		if(energy < 50)
		{
			max = 1;
		}
		
		if(energy < 25)
		{
			energy = 0;
			return false;
		}
		
		energy -= 25;
		
		pointer = new Location(location);
		
		for(int i=1; i <= max; i++)
		{
			switch(d)
			{
			case EAST:
				pointer.translate(0, 1);
				break;
			case WEST:
				pointer.translate(0, -1);
				break;
			case NORTH:
				pointer.translate(-1, 0);
				break;
			case SOUTH:
				pointer.translate(1, 0);
				break;
			case DOWN:
				break;
		}
			
			if(i == max)
			{
				if(area.getCellStatus(pointer) == WALL)
				{
					return false;
				}
				
				if(area.getCellStatus(pointer) == PIT || area.getCellStatus(pointer) == WATER)
				{
					if(hasJacket() == false || area.getCellStatus(pointer) == PIT)
					{
						energy = 0;
					}
					
					foodItems /= 2;
					matches /=2;
				}
				
				if(area.getCellStatus(pointer) == DOOR)
				{
					if(hasKey() == false)
					{
						return false;
					}
				}
			}
			else
				if(area.getCellStatus(pointer) == WALL || area.getCellStatus(pointer) == DOOR)
				{
					return false;
				}
		}
		if(area.getCellStatus(location) == PlAYER)
		{
			area.mark(location, MARK);
		}
		
		if(area.getCellStatus(pointer) == MARK || area.getCellStatus(pointer) == OPEN)
			{
			area.mark(pointer,  PlAYER);
			}
		
		location = pointer;
		
		return true;
	}
	
	/**
	 * Fuction to move one step towards the given direction
	 * @param d - direction
	 * @return
	 * true if the player can make the move, false otherwise
	 */
		
	public boolean move(Direction d)
	{
		pointer = new Location(location);
		
		switch(d)
		{
		
		case EAST:
			pointer.translate(0, 1);
			break;
		case WEST:
			pointer.translate(0, -1);
			break;
		case NORTH:
			pointer.translate(-1, 0);
			break;
		case SOUTH:
			pointer.translate(1, 0);
			break;
		
		}
		
		update = map.getCellStatus(pointer);
		
		if((clock > 0 && energy > 0) && !(update == WALL))
		{
			area = map;
			
			if(area.getCellStatus(pointer) == PIT || area.getCellStatus(pointer) == WATER)
			{
				if(hasJacket() == false || area.getCellStatus(pointer) == PIT)
				{
					energy = 0;
				}
				
				foodItems /= 2;
				matches /= 2;
			}
			
			if(area.getCellStatus(location) == PlAYER)
			{
				area.mark(location, MARK);
			}
			
			if(area.getCellStatus(pointer) == MARK || area.getCellStatus(pointer) == OPEN)
			{
				area.mark(pointer,  PlAYER);
			}
			
			clock -=1;
			energy -=1;
		    location = pointer;
		    return true;
		}
		
		else
		{
			clock -=1;
			energy -=1;
			return false;
		}
	}
	
	/**
	 * Function to look towards the given direction
	 * @param d - direction
	 * @return
	 * Returns what is visible in the given direction
	 */
		
	public java.lang.String look(Direction d)
	{
		area = map;
		
		pointer = new Location(location);
		
		switch(d)
		
		{
		case EAST:
			pointer.translate(0, 1);
			break;
		case WEST:
			pointer.translate(0, -1);
			break;
		case NORTH:
			pointer.translate(-1, 0);
			break;
		case SOUTH:
			pointer.translate(1, 0);
			break;
		}
		
		clock -=1;
		energy -=1;
		
		if((clock > 0 && energy > 0) && (matches > 0))
		{
			area.mark(location,  Status.MARK);
			matches --;
		}
		
		else
		{
			return "DARKNESS";
		}
		
		return area.getCellStatus(pointer).toString();
		
	}
	
	/**
	 * Eat consumes one food item. Increases the energy by 10.
	 * clock goes down by 1, even when there is no food.
	 * Happens everytime the method is called
	 */
	
	public void eat()
	{
		clock -=1;
		foodItems -= Math.min(1, foodItems);
		energy += 10;
		energy = Math.min(energy,  MAX_ENERGY);
	}
	
	/**
	 * Returns the clock time left
	 * @return
	 * Time left
	 */
	public int getClock()
	{
		return clock;
	}
	
	/**
	 * Returns the current energy level of the player
	 * @return
	 * The energy
	 */
	
	public int getEnergy()
	{
		return energy;
		}
	
	/**
	 * Returns the number of food items left
	 * @return
	 * The number of food items left
	 */
	
	public int getFoodItems()
	{
		return foodItems;
	}
	
	/**
	 * Returns the current location of the player
	 * @return
	 * The location
	 */
	
	public Location getLocation()
	{
		return location;
	}
	
	/**
	 * Return the map
	 * @return
	 * The map
	 */
	public Map getMap()
	{
		return map;
	}
	
	/**
	 * Returns the number of matches left
	 * @return
	 * The number of matches left
	 */
	public int getMatches()
	{
		return matches;
	}
	
	/**
	 * Returns true if the player has the life jacket
	 * @return
	 * True if he has the jacket, false otherwise
	 */

	public boolean hasJacket()
	{
		return findJacket;
	}
	
	/**
	 * Returns true if the player has the key, 
	 * which is needed to open the door
	 * @return
	 * true if he has the key, false otherwise
	 */
	
	public boolean hasKey()
	{
		return findKey;
	}
	
	/**
	 * Picks up the item if there is a key, jacket, food or match in current location
	 * In case of matches, picks up only 20
	 * Status is changed to PLAYER, or nothing
	 * Clock and energy are not affected
	 */
	public void pickUp()
	{
		pointer = new Location(location);
		
		if(area.getCellStatus(pointer) == MATCH)
		{
			matches += 20;
		}
		
		if(area.getCellStatus(pointer) == FOOD)
		{
			foodItems += 1;
		}
		
		if(area.getCellStatus(pointer) == JACKET)
		{
			findJacket = true;
		}
		
		if(area.getCellStatus(pointer) == KEY)
		{
			findKey = true;
		}
	}
	
	/**
	 * Increases the energy by 10 while resting
	 * Clock goes down by 10 each time.
	 */
	
	public void rest()
	{
		energy += 10;
		energy = Math.min(energy,  MAX_ENERGY);
		
		if((clock - 10) >= 0)
		{
			clock -= 10;
		}
		
		else {
			clock -= clock;
		}
	}
	
	/**
	 * Returns a list of resources that the player currently has.
	 * Consume one unit of energy and the clock goes down by 1
	 * @return - a string representation of resource available
	 */
	
	public java.lang.String checkResource()
	{
		energy = Math.max(energy - 1, 0);
		clock = Math.max(clock - 1, 0);
		
		String resources = "";
		resources += clock + "The Time \n";
		if(findKey) resources += "One Key \n";
		if(findJacket) resources += "One Jacket \n";
		resources += matches + "Matches \n";
		resources += foodItems + "Food \n";
		resources += energy + "Energy \n";
		resources += "The Key is" + map.distance2key(location) + "away \n";
		resources += "The Door is" + map.distance2key(location) + "away \n";
		
		return resources;
	}   
	
	/**
	 * Returns true if the player reaches the cave exit
	 * @return
	 * true if the player reaches the exit, false otherwise
	 */
	public boolean hasWon()
	{
		if(won == 1 && isAlive() == true)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	/**
	 * The player is still in the game
	 * If clock has not run out
	 * And he still has energy
	 * @return
	 */
	
	public boolean isAlive()
	{
		if((clock > 0) && (energy > 0))
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
}
