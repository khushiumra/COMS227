package hw3;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;

public class Life {

private int[] birthRule;
private int[] survive;
private Cell Cell;
private ArrayList<Cell> ArrayCell;
private ArrayList<Cell> Temp;
private int Columns1;
private int Rows1;
private String[] Map;
private String Display;
	
	/**
	 * Constructs Conways Game of Life give a starting grid (a "seed"), the born rules and the survive rules.  The grid is given as an array of strings as in the following example.
	 * 
	 * 0 0 0 0 0
	 * 0 0 1 0 0
	 * 0 0 1 0 0
	 * 0 0 1 0 0
	 * 0 0 0 0 0
	 * 
	 * @param initConfig an array of Strings encoding the starting grid
	 * @param born an array of integers encoding the rules for a cell being born. 
	 * @param survive an array of integers encoding the rules for a cell surviving. 
	 */
	public Life(String[] initConfig, int[] born, int[] survive) 
	{
		Columns1 = 0;
		this.survive = new int[survive.length];
		birthRule = new int[born.length];
		
		Map = new String[initConfig.length];
		Rows1 = initConfig.length;
		
		ArrayCell = new ArrayList<>();
		Temp = new ArrayList<>();
		
		for(int i = 0; i < initConfig.length; i++)
		{
			Map[i] = initConfig[i];
		}
		
		for(int i = 0; i < survive.length; i++)
		{
			this.survive[i] = survive[i];
		}
		
		for(int i = 0; i < born.length; i++)
		{
			birthRule[i] = born[i];
		}
		
		for(int i = 0; i < Map.length; i++)
		{
			for(int j = 0; j < Map[i].length(); j++)
			{
				if(Map[i].charAt(j) == '1')
				{
					Cell = new Cell(true, birthRule, this.survive);
					ArrayCell.add(Cell);
				}
				
				if(Map[i].charAt(j) == '0')
				{
					Cell = new Cell(false, birthRule, this.survive);
					ArrayCell.add(Cell);
				}
			}
		}
		
		for(int i = 0; i < Map[0].length(); i++)
		{
			if(Map[0].charAt(i) == '1' || Map[0].charAt(i)== '0')
			{
				Columns1 += 1;
			}
		}
		
		for(int i = 0; i < getRows(); i++)
		{
			int Up, Down, Left, Right;
			
			Up = i - 1;
			Down = i + 1;
			
			for(int j = 0; j < getColumns(); j++)
			{
				Left = j - 1;
				Right = j + 1;
				
				if(i > 0 && j > 0)
				{
					Temp.add(ArrayCell.get(Left + Up*getColumns()));
				}
				
				if(i > 0)
				{
					Temp.add(ArrayCell.get(j + Up*getColumns()));
				}
				
				if(i > 0 && j < getColumns() - 1)
				{
					Temp.add(ArrayCell.get(Right + Up*getColumns()));
				}
				
				if(j > 0)
				{
					Temp.add(ArrayCell.get(Left + i*getColumns()));
				}
				
				if(j < getColumns() - 1)
				{
					Temp.add(ArrayCell.get(Right + i*getColumns()));
				}
				
				if(i < getRows() - 1 && j > 0)
				{
					Temp.add(ArrayCell.get(Left + Down*getColumns()));
				}
				
				if(i < getRows() - 1)
				{
					Temp.add(ArrayCell.get(j + Down*getColumns()));
				}
				
				if(i < getRows() - 1 && j < getColumns() - 1)
				{
					Temp.add(ArrayCell.get(Right + Down*getColumns()));
				}
				
				
				
				(ArrayCell.get(j + i*getColumns())).setNeighbors(Temp);
				Temp.clear();
			}
		}
		
	}
	
	/**
	 * Constructs Conways Game of Life give a starting grid (a "seed"), the born rules and the survive rules.  The grid is given in a file containing a list of strings as in the following example.
	 * 
	 * 0 0 0 0 0
	 * 0 0 1 0 0
	 * 0 0 1 0 0
	 * 0 0 1 0 0
	 * 0 0 0 0 0
	 * 
	 * @param f the File encoding the starting grid
	 * @param born an array of integers encoding the rules for a cell being born. 
	 * @param survive an array of integers encoding the rules for a cell surviving. 
	 * @throws FileNotFoundException
	 */
	public Life(File f, int[] born, int[] survive) throws FileNotFoundException
	{
		this.survive = new int[survive.length];
		birthRule = new int[born.length];
		ArrayCell = new ArrayList<>();
		Temp = new ArrayList<>();
		Columns1 = 0;
		
		ArrayList<String> Content = new ArrayList<String>();
		Scanner File = new Scanner(f);
		
		while(File.hasNextLine())
		{
			String Temp = File.nextLine();
			Content.add(Temp);
		}
		
		Map = new String[Content.size()];
		
		for(int i = 0; i < Map.length; i++)
		{
			Map[i] = Content.get(i);
		}
		
		for(int i = 0; i < survive.length; i++)
		{
			this.survive[i] = survive[i];
		}
		
		for(int i = 0 ; i < born.length; i++)
		{
			birthRule[i] = born[i];
		}
		
		for(int i = 0; i < Map.length; i++)
		{
			for(int j = 0; j < Map[i].length(); j++)
			{
				if(Map[i].charAt(j) == '1')
				{
					Cell = new Cell(true, birthRule, this.survive);
					ArrayCell.add(Cell);
				}
				
				if(Map[i].charAt(j) == '0')
				{
					Cell = new Cell(false, birthRule, this.survive);
					ArrayCell.add(Cell);
				}
			}
		}
		
		for(int i = 0; i < Map[0].length(); i++)
		{
			if(Map[0].charAt(i) == '1' || Map[0].charAt(i)== '0')
			{
				Columns1 += 1;
			}
		}
		
		for(int i = 0; i < getRows(); i++)
		{
			int Up, Down, Left, Right;
			
			Up = i - 1;
			Down = i + 1;
			
			for(int j = 0; j < getColumns(); j++)
			{
				Left = j - 1;
				Right = j + 1;
				
				if(i > 0 && j > 0)
				{
					Temp.add(ArrayCell.get(Left + Up*getColumns()));
				}
				
				if(i > 0 && j < getColumns() - 1)
				{
					Temp.add(ArrayCell.get(Right + Up*getColumns()));
				}
				
				if(j > 0)
				{
					Temp.add(ArrayCell.get(Left + i*getColumns()));
				}
				
				if(i < getRows() - 1 && j > 0)
				{
					Temp.add(ArrayCell.get(Left + Down*getColumns()));
				}
				
				if(i < getRows() - 1)
				{
					Temp.add(ArrayCell.get(j + Down*getColumns()));
				}
				
				
				if(j < getColumns() - 1)
				{
					Temp.add(ArrayCell.get(Right + i*getColumns()));
				}
				
				if(i > 0)
				{
					Temp.add(ArrayCell.get(j + Up*getColumns()));
				}

				if(i < getRows() - 1 && j < getColumns() - 1)
				{
					Temp.add(ArrayCell.get(Right + Down*getColumns()));
				}
				
				(ArrayCell.get(j + i*getColumns())).setNeighbors(Temp);
				Temp.clear();
			}
		}
		
	}
			
	/**
	 * Returns cell at specified position
	 * @param row index of the row 
	 * @param col index of the column
	 * @return Cell at position (row, col)
	 */
	public Cell getCell(int row, int col) 
	{
		return ArrayCell.get(col + row*getColumns());
	}
	
	/**
	 * Returns the number of rows in the Game of Life
	 * @return number of rows in grid
	 */
	public int getRows() 
	{
		return Rows1;
	}
	
	
	/**
	 * Returns the number of columns in the Game of Life
	 * @return number of columns in grid
	 */
	public int getColumns() 
	{
		return Columns1;
	}
	
	/**
	 * Performs one generation of the game
	 * 
	 */
	public void nextGeneration() 
	{
	
		for(int i = 0; i < ArrayCell.size(); i++)
		{
			ArrayCell.get(i).nextGeneration();
		}
		
	}
	
	/**
	 * Returns a String representation of the game. Returns the String representation of each element of the game in a grid.
	 * 
	 * @return a string representing the current state of the game.
	 */
	public String toString() 
	{
		Display = " ";
		
		for(int i = 0; i < ArrayCell.size(); i++)
		{
			Display += ArrayCell.get(i).toString();
		}
		
		return Display;
		
	}
	
	

	
}
