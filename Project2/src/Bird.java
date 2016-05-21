/** Bird.java - Class representing a Bird in the Maze object
 * @author Bob Wilson
 * @version 02/24/2011
 * 
 */

import java.util.*;

public class Bird
{
	public static final int N  = 0;
	public static final int NE = 1;
	public static final int E  = 2;
	public static final int SE = 3;
	public static final int S  = 4;
	public static final int SW = 5;
	public static final int W  = 6;
	public static final int NW = 7;
  
	private static final String [] directions = {"N ", "NE", "E ", "SE", "S ", "SW", "W ", "NW"};
  
	private String name;
	private int direction;
	private Queue<Bird> queue;
	public int row;
	public int column;
	
  /**
   * This is to construct name, direction, row, and column
   * @param row row is to get the bird
   * @param column column is to get the bird
   * @param direction direction is to get the bird's direction 
   */
	public Bird(int row, int column, int direction)
	{
		this.name = "Row/Column [" + row + "][" + column + "]";
		this.direction = direction;
		this.row = row;
		this.column = column;
	}
  
	/**
	 *  This is to set queue of each bird
	 * @param queue
	 */
	public void setBirdQueue(Queue<Bird> queue)
	{
		this.queue = queue;
	}
  
	/**
	 * This is to print the bird's information 
	 */
	public String toString()
	{
		return "Location: " + name + ", Direction: " + directions[direction];
	}
  
	/**
	 * This is to get the direction of the bird
	 * @return to return direction
	 */
	public int getDirection()
	{
		return this.direction;
	}
  
	/**
	 * This is to get next bird
	 * @return to return next bird
	 */
	public Bird getNextBird()
	{
		// write code to return the next Bird from the queue or null if no Birds left.
		return queue.isEmpty() ? null : queue.poll();

	}
}