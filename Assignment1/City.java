package hw1;

public class City {

	//Postcard cost %
			public static final double POSTCARD_COST = 0.5;
			
			private int PCCost; // Cost of the postcard
			private String CName; // Name of the city
			private int HCost; // Cost for living in the hostel
			
			/** Constructs a new city and the lodging cost per night.
			 * Calculates the cost of the postcard 
			 */
			
			public City( String givenCityName, int givenHostelCost)
			{
				PCCost = (int) Math.round(givenHostelCost * POSTCARD_COST);
				CName = givenCityName;
				HCost = givenHostelCost;
			
			}
			
			/** Returns the cost of living in a hostel
			 * @return - The cost
			 */
			
			public int hostelCost()
			{
				return HCost;
			}
			
			/** Returns the name of the city
			 * @return - City Name
			 */
			
			public String getCityName()
			{
				return CName;
			}
			
			/** Returns the cost of sending a postcard
			 * @return - Cost of postcard
			 */
			
			public int postcardCost()
			{
				return PCCost;
			}

			/** Returns the amount of days in a specific city
			 * @return - Number of days
			 * @param moneyAvailable
			 * Money available divided by the cost of the hostel
			 */
			
			public int nightsStay(int moneyAvailable)
			{
				return moneyAvailable / HCost;
			}
			
			/** Returns the number of postcards that can be sent with the 
			 * amount of money available
			 * @param moneyAvailable
			 * @return - Number of post cards
			 * Money available divided by the cost of per post card
			 */
			public int numPostcards(int moneyAvailable)
			{
				return moneyAvailable / PCCost;
			}
}
