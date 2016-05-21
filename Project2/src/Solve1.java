/** Solve1.java - Class containing the main method for iterative solution
 * @author Bob Wilson
 * @version 02/24/2011
 * 
 */

import java.util.Stack;

public class Solve1
{
	public static void main(String [] args)
	{
		// create the maze to solve
		Maze maze = new Maze();
    
		// create two Stack of Bird objects named traceBack and path here
		Stack<Bird> traceBack = new Stack<Bird>();
		Stack<Bird> path = new Stack<Bird>();
		// Write your code for solving the maze here using the traceback stack
		Bird curr = maze.getStart();
		Bird end  = maze.getEnd();
		
		// to check the next available bird, or jump into next bird
		while(true){
		    traceBack.push(curr);
		    curr = curr.getNextBird();
		    if (traceBack.contains(curr)){
		    	curr = traceBack.pop();
		    	traceBack.push(curr);
		    	curr = curr.getNextBird();
		    }
		    
		    if (curr == null){
		    	curr = traceBack.pop();
		    	curr = traceBack.pop();
		    }
			
			if (curr == end) {
				traceBack.push(curr);
//				System.out.println(traceBack);
				break;
			}
//			System.out.println(traceBack);
		}

		// reverse and print the results
		while (!traceBack.isEmpty())
		{
			path.push(traceBack.pop());
		}
    
		while (!path.isEmpty())
		{
			System.out.println(path.pop());
		}
	}
}