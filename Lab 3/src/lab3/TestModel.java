package lab3;

public class TestModel {
	
	public static void main(String[] args)
	  {
	    RabbitModel model = new RabbitModel();
	    

	    System.out.println(model.getPopulation());
	   

	    model.simulateYear();
	    
	    System.out.println(model.getPopulation());
	    
 model.simulateYear();
	    
	    System.out.println(model.getPopulation());
	    
 model.simulateYear();
	    
	    System.out.println(model.getPopulation());
	    

	    model.reset();
	    
	    System.out.println(model.getPopulation());
	  }

}
