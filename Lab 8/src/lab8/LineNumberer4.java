package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineNumberer4 {

	public static void main(String[] args) throws FileNotFoundException
	  {
	    File file = new File("story.txt");
	    Scanner scanner = new Scanner(file);
	    int lineCount = 1;
	    

	    while (scanner.hasNextLine())
	    {
	      String line = scanner.nextLine();
	      int wordCount = 0;
	      Scanner s = new Scanner(line);
	      while (s.hasNext()){
	    	  wordCount ++;
	    	  s.next();
	      }
	      
	      System.out.print("Line = " + lineCount + " Word Count = ");
	      System.out.println(wordCount);
	      lineCount += 1;
	    }
	    scanner.close();
	   
	  }
}
