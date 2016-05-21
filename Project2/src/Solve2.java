/** Solve2.java - Class containing the main method for recursive solution
 * @author Bob Wilson
 * @version 02/24/2011
 * 
 */

import java.util.Stack;

public class Solve2
{
	static boolean chk_end = false;
	public static void main(String [] args)
	{
		// create the maze to solve
		Maze maze = new Maze();
		
		// create a Stack of Bird objects named path here
		Stack<Bird> path = new Stack<Bird>();
    
		// call recursive method to solve the maze and print the path
		recurse(path, maze.getStart(), maze.getEnd());
		print(path);
	}
	
	/**
	 *  This is to recurse each available bird into system stack
	 * @param path path is to get a solution of this puzzle
	 * @param current current refers to current bird
	 * @param end end is we have to reach that 
	 * @return to return false if it does not reach the end bird
	 */
	private static boolean recurse(Stack<Bird> path, Bird current, Bird end){
		if(!chk_end){
			// write your code for the solution of the maze here
			if (current != null && current == end){
				path.push(current);
				//System.out.println("got it : ");
				return true;
			}
			else if (current == null){
				return false;
			}
			else if (recurse(path, current.getNextBird(), end) == false){
				recurse(path, current.getNextBird(), end);
				recurse(path, current.getNextBird(), end);
//				return false;
			}

//			recurse(path, current.getNextBird(), end);

//			System.out.println(current);
			path.push(current);
//			return false;
			return current == end ? false : recurse(path, current.getNextBird(), end);
		}
		else{
			return false;
		}
	}
    
/*	private static boolean recurse(Stack<Bird> path, Bird current, Bird end)
	{
		// write your code for the solution of the maze here
//		System.out.println(current);
		if (current != null && current == end){
			path.push(current);
//			System.out.println("got it");
			return true;
		}
		else if (current == null){
			return false;
		}
		else if (recurse(path, current.getNextBird(), end) == false){
			recurse(path, current.getNextBird(), end);
			recurse(path, current.getNextBird(), end);
//			return false;
		}
		
		recurse(path, current.getNextBird(), end);
//		System.out.println(current);
		path.push(current);
		return false;
	}
*/

	/**
	 * This is to recurse the solution from system stack
	 * @param stack stack is the solution
	 */
	private static void print(Stack<Bird> stack)
	{
		// write your code for recursively printing the stack here
//		System.out.println(stack.size());
//		Maze maze = new Maze();
		Bird buff = stack.pop();
		System.out.println("["+buff.row+"]["+buff.column+"] : "+chk_end);
		if(!chk_end){
			if ((buff.row==2) && (buff.column==6)){ // !stack.empty()
				chk_end = true;
			}
			else{
				System.out.println(buff);
				print(stack);
			}
		}
	}
}