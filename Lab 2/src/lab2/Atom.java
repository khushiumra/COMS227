package lab2;

public class Atom {
	
	private int Protons;
	   private int Neutrons;
	   private int Electrons;

	public Atom(int givenProtons, int givenNeutrons, int givenElectrons) 
		{
			   
			 Protons = givenProtons;
			Neutrons = givenNeutrons;
			Electrons = givenElectrons ;
			// insert code to assign given values to instance variables 
		}
	
public int getAtomicMass()
{
	return Protons + Neutrons;
}

public int getAtomicCharge()
{
	return Protons - Electrons;
}

public void decay()
{
	Protons = Protons - 2;
	Neutrons = Neutrons - 2;
}
}
