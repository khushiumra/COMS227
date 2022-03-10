package lab5;

import java.lang.Object;

public class Balloon {
	
	public static int radius;
	public static boolean pop;
	
	public Balloon(int max)
	{
		Balloon b = new Balloon(5);
		radius = 0;
		
	}
	
	public void blow(int amount)
	{
		radius +=amount;
		
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public boolean isPopped()
	{
		if(pop == true)
		{
			return true;
		}
		else
			return false;
	}
	
	public void deflate()
	{
		radius = 0;
	}
	
	public void pop()
	{
		pop = true;
	}

}
