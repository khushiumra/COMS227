package lab8;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import plotter.Plotter;
import plotter.Polyline;

public class PolyLineTest {
	
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<String>();
		Plotter plotter = new Plotter();
		File f = new File("hello.txt");
		Scanner sc = null;
		
		try
		{
			sc = new Scanner(f);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		while(sc.hasNextLine())
		{
			list.add(sc.nextLine());
		}
		for(int i = 2; i < list.size(); i++)
		{
			Polyline poly = parseOneLine(list.get(i));
			plotter.plot(poly);
		}
     }
	
	private static Polyline parseOneLine(String Line)
	{
		Polyline poly = new Polyline("blue");
		String[] s = Line.split(" ");
		
		try
		{
			Integer.parseInt(s[0]);
			poly = new Polyline(s[1], Integer.parseInt(s[0]));
			for(int i = 2; i < s.length; i += 2)
			{
				poly.addPoint(new Point(Integer.parseInt(s[i]), Integer.parseInt(s[i+1])));
			}
		}
		catch (NumberFormatException e)
		{
			poly = new Polyline(s[0]);
			for(int i = 1; i < s.length; i += 2)
			{
				poly.addPoint(new Point(Integer.parseInt(s[i]), Integer.parseInt(s[i + 1])));
			}
		}
		
		return poly;
	}
}
