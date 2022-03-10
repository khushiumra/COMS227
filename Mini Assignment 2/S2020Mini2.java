package miniassignment2;

import java.lang.Object;

public class S2020Mini2 {
	
	private S2020Mini2()
	{
		
	}
	
	/**
	   * Names for each of the four cardinal directions on a plane.  Used in
	   * <em>langtonsAnt</em>.
	   */
	  public enum Direction {
	    UP,
	    LEFT,
	    DOWN,
	    RIGHT
	  }

	  /**
	   * Calculates the coefficients of the expansion of the binomial expression (x + y)<sup>n</sup>.  Coefficients are calculated by expanding Pascal's Triangle (see <a href="https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif">this animated gif</a> from Wikipedia).
	   *
	   * <p><b>Coeffients must be calculated by expanding Pascal's Triangle!  No other methods of calculating binomial coefficients will be accepted!</b>
	   *
	   * <p>For instance, <em>binomialCoefficients(7)</em> returns [1, 7, 21, 35,
	   * 35, 21, 7, 1]
	   *
	   * @param n The degree of the polynomial
	   * @return An array of <em>n</em> + 1 terms containing the <em>n</em><sup>th</sup> degree binomial coefficients.
	   */
	  public static int [] binomialCoefficients(int n)
	  {
		  int []A = new int[n+1];
		  int [][]C = new int[n+1][n+1];
		  
		  C[0][0] = 1;
		  
		  for(int i =1; i <= n; ++i)
		  {
			  C[i][0] = C[i][i] = 1;
			  
			  for(int k = 1; k < i; ++k)
			  {
				  C[i][k] = C[i-1][k-1] + C[i-1][k];
			  }
		  }
		  
		  for(int i = n; i == n; i++)
		  {
			  for(int j = 0; j <= n; j++)
			  {
				  A[j] = C[i][j];
			  }
		  }
		  
		  return A;
 	  }

	  /**
	   * Factors <em>n</em> and return the factors in an array.  All factors are
	   * arranged in non-descending order in the returned array.  Note that a
	   * prime number is its own factor; this is true of composite numbers, as
	   * well, but not apropos here.
	   *
	   * <p> For instance, <em>factor(413423478)</em> returns [2, 3, 3, 13, 29,
	   * 60923]
	   *
	   * @param n The number to be factored
	   * @return An array of length <em>number of prime factors of n</em>
	   * containing each of the factors in non-decreasing order.
	   */
	  public static int [] factorization(int n)
	  {
		  
		  int count = 0;
		  int num = n;
		  
		  for(int i = 2; i <= n; i++)
		  {
			  while (n % i == 0)
			  {
				  ++count;
				  n /= i;
			  }
		  }
		  
		  n = num;
		  
		  int[] list = new int[count];
		  int index = 0;
		  
		  for(int i =2; i <= n; i++)
		  {
			  while (n % i == 0)
			  {
				  list[index++] = i;
				  n /= i;
			  }
		  }
		  
		  return list;
	  }

	  /**
	   * Reorders <em>a</em> such that all odd values appear before any even
	   * values.  The relative orders of the odd numbers to the rest of the odds
	   * and of the even numbers to the rest of the evens does not change.
	   *
	   * <p>For instance, given <em>a</em> = [ 1, 2, 3, 4, 5, 6, 7 ], return [1,
	   * 3, 5, 7, 2, 4, 6 ].
	   *
	   * @param a An array of integers
	   */
	  public static void oddsToFront(int [] a)
	  {
		  
		  int[] copy = new int[a.length];
		  
		  for(int i =0; i <a.length; i++)
		  {
			  copy[i] = a[i];
		  }
		  
		  int lIndex = 0, rIndex = a.length - 1;
		  
		  for(int i =0; i < copy.length; i++)
		  {
			  if(copy[i] % 2 == 1)
			  {
				  a[lIndex++] = copy[i];
			  }
		  }
		  
		  for(int i = copy.length - 1; i >= 0; i--)
		  {
			  if(copy[i] % 2 == 0)
			  {
				  a[rIndex--] = copy[i];
			  }
		  }
	  }

	  /**
	   * Returns a new array containing all of the values from <em>a</em> and
	   * <em>b</em> interleaved (i.e., <em>a[0], b[0], a[1], b[2], ..., a[n - 1],
	   * b[n - 1]</em> where <em>n</em> is the length of the shortest of the two
	   * input arrays) followed by the remaining, non-interleaved values from the
	   * longer (if either) input array.
	   *
	   * <p>For instance, given <em>a</em> = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] and
	   * <em>b</em> = [20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 21, 22, 23],
	   * <em>interleave(a, b)</em> returns [1, 20, 2, 19, 3, 18, 4, 17, 5, 16, 6,
	   * 15, 7, 14, 8, 13, 9, 12, 10, 11, 21, 22, 23].
	   *
	   * @return The interleaved output
	   * @param a An array of integers
	   * @param b An array of integers
	   */
	  public static int [] interleave(int [] a, int [] b)
	  {
		  int[] result = new int [a.length + b.length];
		  
		  int index = 0;
		  
		  for(int i = 0; i < a.length || i < b.length; i++)
		  {
			  if(i < a.length)
			  {
				  result[index++] = a[i];
			  }
			  
			  if(i < b.length)
			  {
				  result[index++] = b[i];
			  }
		  }
		  
		  return result;
	  }

	  /**
	   * Shuffles the contents of <em>a</em> like, e.g., a deck of cards.
	   * Shuffling is achieved by the following method: Iterating from index 0
	   * through index <em>length - 1</em> over the input array, swap the value
	   * in that index with the value at the index given by the next random
	   * integer modulo <em>a.length</em>.
	   *
	   * <p>For instance, with <em>a</em> = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
	   * <em>shuffle(new Random(1995), a)</em> changes <em>a</em> to [3, 6, 1,
	   * 10, 5, 9, 2, 4, 7, 8].
	   *
	   * @param r An instance of <em>Random</em>
	   * @param a An array of integers
	   */
	  public static void shuffle(java.util.Random r, int [] a)
	  {
		  int i;
		  int array_length = a.length;
		  int rand_int;
		  int temp;
		  
		  for(i = 0; i < array_length; i++)
		  {
			  rand_int = r.nextInt(array_length) % array_length;
			  
			  temp = a[i];
			  a[i] = a[rand_int];
			  a[rand_int] = temp;
		  }
	  }

	  /**
	   * Runs the <a
	   * href="https://en.wikipedia.org/wiki/Langton%27s_ant">Langton's Ant</a>
	   * cellular automaton on the input matrix <em>m</em> until the ant steps
	   * off the matrix or until the simulation loop completes <em>maxSteps</em>
	   * iterations.  For a description of the automaton, follow the embedded
	   * Wikipedia link above and read the section entitled "Rules".  In this
	   * simulation, the value of false denotes a black square, and true denotes
	   * a white square.  UP is the negative vertical direction, and LEFT is the
	   * negative horizontal direction.  The simulation runs in-place on
	   * <em>m</em>.
	   *
	   * <p>For instance, given the call <em>langtonsAnt(m, 1, 1, Direction.LEFT,
	   * 100)</em> where <em>m</em> is a 3x3 matrix with all values false, the
	   * algorithm will proceed through each of the following internal states
	   * before returning with <em>m</em> referencing the final state:
	   *
	   * <p>[false, false, false]
	   * <br>[false, true, false]
	   * <br>[false, false, false]
	   * <p>[false, false, false]
	   * <br>[false, true, false]
	   * <br>[false, true, false]
	   * <p>[false, false, false]
	   * <br>[false, true, false]
	   * <br>[false, true, true]
	   * <p>[false, false, false]
	   * <br>[false, true, true]
	   * <br>[false, true, true]
	   * <p>[false, false, false]
	   * <br>[false, false, true]
	   * <br>[false, true, true]
	   * <p>[false, true, false]
	   * <br>[false, false, true]
	   * <br>[false, true, true]
	   * <p>[true, true, false]
	   * <br>[false, false, true]
	   * <br>[false, true, true]
	   * <p>[true, true, false]
	   * <br>[true, false, true]
	   * <br>[false, true, true]
	   * <p>[true, true, false]
	   * <br>[true, true, true]
	   * <br>[false, true, true]
	   * <p>[true, false, false]
	   * <br>[true, true, true]
	   * <br>[false, true, true]
	   * <p>[true, false, true]
	   * <br>[true, true, true]
	   * <br>[false, true, true]
	   *
	   * <p> To be clear: your submitted code should not return or print all of
	   * these steps (though that may be useful for debugging)!  You should only
	   * return the final matrix given above.
	   *
	   * <p> And similarly, <em>langtonsAnt(m, 1, 1, Direction.LEFT, 2)</em> should
	   * return the second above matrix.
	   *
	   * @param m A two-dimensional array of boolean
	   * @param c The ant's starting column
	   * @param r The ant's starting row
	   * @param d The ant's starting direction
	   * @param maxSteps The maximum number of iterations of the simulation
	   */
	  public static void langtonsAnt(boolean [][] m, int c, int r, Direction d, int maxSteps)
	  {
		  
		  while(maxSteps-- > 0) 
		  
		  {
	          
	            boolean white = m[r][c];
	            
	            if(white) 
	            {
	                if(d == Direction.UP) 
	                {
	                    d = Direction.RIGHT;
	                } 
	                
	                else 
	                	if(d == Direction.RIGHT) 
	                	{
	                         d = Direction.DOWN;
	                    } 
	                	else 
	                		if(d == Direction.DOWN) 
	                		{
	                              d = Direction.LEFT;
	                        } 
	                		else 
	                			if(d == Direction.LEFT) 
	                			{
	                                 d = Direction.UP;
	                             }
	            }
	            
	            else 
	            {
	                if(d == Direction.DOWN)
	                {
	                    d = Direction.RIGHT;
	                }
               
	                else 
	                	if(d == Direction.LEFT) 
	                	{
	                         d = Direction.DOWN;
	                     } 
	                	else 
	                		if(d == Direction.UP) 
	                		{
	                           d = Direction.LEFT;
	                        }
	                		else 
	                			if(d == Direction.RIGHT) 
	                			{
	                              d = Direction.UP;
	                             }
	            }
	            
	            // Flip the value at current cell
	            m[r][c] = !m[r][c];

	            // move one step now.
	            if(d == Direction.UP) 
	            {
	                r--;
	            } 
	            else 
	            	if(d == Direction.DOWN) 
	            	{
	                   r++;
	                } 
	            	else 
	            		if(d == Direction.LEFT) 
	            		{
	                       c--;
	                    } 
	            		else
	            			if(d == Direction.RIGHT) 
	            			{
	                             c++;
	                       }
	            
	            // Print the matrix if needed.
	            for(int i=0; i<m.length; i++)
	            {
	                for(int j=0; j<m[i].length; j++) 
	                {
	                    System.out.print(m[i][j] + " ");
	                }
	                
	                System.out.println();
	            }
	            
	            System.out.println();
	            
	            // if we went out of the cell
	            if(r < 0 || r >= m.length || c < 0 || c >= m[0].length) 
	            {
	                break;
	            }
	            
	        }
		  
	  }
}
		 