package hw1;

public class Backpacker {
public static final int SYMPATHY_FACTOR = 30;
	
	private City CCity; // Name of current city
	private String SCity; // The first city
	private int numNights; // Number of nights in the city
	private String Journal; // Keeps track of all the cities
	private int InFunds; // Intial funds
	private int CMoney; // Current Money 
	private int CPCard2; // Number of postcards that can be sent with available money
	private int Station; // Number of nights spent at the station
	private int UsedMoney; // Money spent during the city
	private int HPCard; // Money spent to send postcards home
	private int CPCard; // Number of postcards initialized in sendPostCardsHome
	private int AvailNights; // Number of nights you can stay with the current money you have
	private int Nights2; // Initializes nights given
	private int UpdatePC; // Updates the number of postcards sent
	
	/** Constructs a backpacker with given amount of money and a given city.
	 * @param initialFunds
	 * @param initialCity
	 * 'Journal' is a string consisting of city names
	 */
	
	public Backpacker (int initialFunds, City intialCity)
	{
		InFunds = initialFunds;
		CMoney = InFunds;
		CCity = intialCity;
		SCity = intialCity.getCityName();
		Journal = SCity + "("+ "start" +")";

	}
	
	/** Returns the current amount of money
	 * @return - Current money
	 */
	
	public int getCurrentMoney()
	{
		return CMoney;
	}
	
	/** Returns the name of the current city
	 * @return - Current City
	 */
	
	public String getCurrentCity()
	{
		return CCity.getCityName();
	}
	
	/** Returns the number of nights spent at the train stations
	 * @return
	 */
	
	public int getNightsInStation()
	{
		return Station;
	} 
	
	/** Returns the journal. Names of the cities are separated by commas along with the number of nights spent there
	 * @return Journal
	 */
	
	public String getJournal()
	{
		return Journal;
	}
	
	/** Money required to send postcards for current city
	 * @return
	 * Returns true if you enough money to send, returns false if you dont have enough money
	 */

	public boolean isSol()
	{
		if(CMoney < CCity.postcardCost())
		{
			return true;
		}

			return false;
	}
	
	/** Stimulates a visit for a given city and given number of nights
	 * Money is decreased according to the number of nights booked to live in a hostel
	 * If the money available is not sufficient to spend a night at the hostel, 
	 * the number of nights spent at the station are upgraded.
	 * @param c
	 * @param numNights
	 */
	
	public void visit(City c, int numNights)
	{
		CCity = c;
		Journal += "," + CCity.getCityName() + "(" + numNights +")";
		Nights2 = numNights;
	    AvailNights = CMoney / c.hostelCost();
	    this.numNights = Math.min(numNights, AvailNights);
	    UsedMoney = this.numNights * c.hostelCost();
	    CMoney = CMoney - UsedMoney;
	    Station += Nights2 - this.numNights;
	}
	
	
	/** Increases the funds.
	 * SYMPATHY_FACTOR times the amount of postcards sent since the last time this method was called
	 * resets the number of postcards sent to zero
	 */
	
	public void callHomeForMoney()
	{
		CMoney = CMoney + (SYMPATHY_FACTOR * UpdatePC);
		UpdatePC = 0;
	}

	/** Sends the number of postcards while reducing the current money 
	 * and increasing the count of postcards sent.
	 * Does not allow the funds to go below zero.
	 * @param howMany
	 */
	
	public void sendPostcardsHome(int howMany)
	{
		CPCard = howMany;
		CPCard2 = CMoney / (CCity.postcardCost());
		CPCard = Math.min(howMany, CPCard2);
		UpdatePC += CPCard;
		HPCard = CPCard * (CCity.postcardCost());
		CMoney = (CMoney - HPCard);	
	}
	

}
