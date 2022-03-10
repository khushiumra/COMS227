package library;

import java.util.Date;

public abstract class CommonAbstract implements Item 
{

	private String title;
	private Date dueDate;
	private Patron checkedOutTo;
	private double replacementCost;
	private int duration;
	
	public boolean isCheckedOut()
	{
		return dueDate != null;
	}
	
	public void checkIn()
	{
		if(isCheckedOut())
		{
			checkedOutTo = null;
			dueDate = null;
		}
	}
	
	public boolean isOverdue(Date now)
	{
		if(!isCheckedOut())
			return false;
		
		return now.after(dueDate);
	}
	
	public int compareTo(Item other)
	{
		return title.compareTo(other.getTitle());
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public Date getDueDate()
	{
		return dueDate;
	}
	
	public Patron getPatron()
	{
		return checkedOutTo;
	}
	
	public double getFine(Date now)
	{
		if(isCheckedOut() && isOverdue(now))
		{
			double elapsed = now.getTime() - dueDate.getTime();

            int millisPerDay = 24 * 60 * 60 * 1000;
            int daysLate = (int) Math.ceil(elapsed / millisPerDay);

            double fine;
            if (daysLate <= 5)
            {
                fine = daysLate;
            }
            else
            {
                fine = 5 + (daysLate - 5) * .50;
            }
            return Math.min(fine, replacementCost);    
            }
        else
        {
            return 0;
        }
		
	}
	
	  public void renew(Date now)
	  {
		  
	  }
	}

