package lab5;

import balloon.Balloon;

public class BalloonTests {
	public static void main(String[] args)
	  {
	    Balloon b = new Balloon(5);
	    
	    
	    System.out.println(b.isPopped());
	    System.out.println("Expected: false");
	    
	    // A newly constructed basketball should have the diameter it was constructed with
	    System.out.println(b.getRadius());
	    System.out.println("Expected: 5.0");
	    
	    // After inflating, the basketball should be dribbleable
	    b.blow(10);
	    System.out.println(b.isPopped());
	    System.out.println("Expected: true");
	    
	    // After inflating, the basketball should still have the diameter it was constructed with
	    System.out.println(b.getRadius());
	    System.out.println("Expected: 5.0");
	  }
	

}
