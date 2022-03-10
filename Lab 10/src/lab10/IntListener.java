package lab10;

public class IntListener {
	
	public static void main(String[] args)
	{
		
		IntList list = new IntList();
		
		list.add(5);
		list.add(4);
		list.add(3);
		
		System.out.println(list);
		System.out.println("Size: " + list.size());
		System.out.println("Min: " + list.getMinimum());
		System.out.println("Max: " + list.getMaximum());
		
		 System.out.println("\n Sorted IntList Functionality..");
		 
	       IntListSorted sortedList = new IntListSorted();

	       sortedList.add(5);
	       sortedList.add(4);
	       sortedList.add(3);
	       sortedList.add(15);
	       sortedList.add(52);
	       sortedList.add(4);
	       sortedList.add(32);
	       sortedList.add(3);
	       sortedList.add(16);
	       sortedList.add(55);
	       sortedList.add(45);
	       sortedList.add(322);
	       sortedList.add(31);
	       sortedList.add(1);
	       sortedList.add(52);
	       sortedList.add(43);
	       sortedList.add(312);
	       sortedList.add(39);
	       
	       
	       System.out.println(sortedList);
	       System.out.println("Size: " + sortedList.size());
	       System.out.println("Min: " + sortedList.getMinimum());
	       System.out.println("Max: " + sortedList.getMaximum());
	       
	    // at this point of time, list contains even number of elements..
	       System.out.println("Median: " + sortedList.getMedian()); 
	      
	    // at this point of time, list contains odd number of elements
	       sortedList.add(98);
	       System.out.println("Median: " + sortedList.getMedian()); 
	   }
		
	}
