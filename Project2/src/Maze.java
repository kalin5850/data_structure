/** Maze.java - Class representing a Maze object
 * @author Bob Wilson
 * @version 02/24/2011
 * 
 */
import java.util.*;

public class Maze
{
	private Bird start;
	private Bird end;
	
	/**
	 * This is to initial the maze bird puzzle
	 */
	public Maze()
	{
		// construct the diagrammed maze
		int MAX_ROW = 5;
		int MAX_COL = 7;
		Bird [][] maze = new Bird[MAX_ROW][MAX_COL];
    
		// row 0
		maze[0][0] = new Bird(0, 0, Bird.S);
		maze[0][1] = new Bird(0, 1, Bird.SW);
		maze[0][2] = new Bird(0, 2, Bird.S);
		maze[0][3] = new Bird(0, 3, Bird.SE);
		maze[0][4] = new Bird(0, 4, Bird.SW);
		maze[0][5] = new Bird(0, 5, Bird.SW);
		maze[0][6] = new Bird(0, 6, Bird.SW);
		
		// row 1
		maze[1][0] = new Bird(1, 0, Bird.S);
		maze[1][1] = new Bird(1, 1, Bird.W);
		maze[1][2] = new Bird(1, 2, Bird.SW);
		maze[1][3] = new Bird(1, 3, Bird.S);
		maze[1][4] = new Bird(1, 4, Bird.N);
		maze[1][5] = new Bird(1, 5, Bird.S);
		maze[1][6] = new Bird(1, 6, Bird.W);
    
		// row 2
		maze[2][0] = new Bird(2, 0, Bird.NE);
		maze[2][1] = new Bird(2, 1, Bird.NW);
		maze[2][2] = new Bird(2, 2, Bird.N);
		maze[2][3] = new Bird(2, 3, Bird.W);
		maze[2][4] = new Bird(2, 4, Bird.SE);
		maze[2][5] = new Bird(2, 5, Bird.NE);
		maze[2][6] = new Bird(2, 6, Bird.E);
    
		// row 3
		maze[3][0] = new Bird(3, 0, Bird.SE);
		maze[3][1] = new Bird(3, 1, Bird.NE);
		maze[3][2] = new Bird(3, 2, Bird.E);
		maze[3][3] = new Bird(3, 3, Bird.NW);
		maze[3][4] = new Bird(3, 4, Bird.NW);
		maze[3][5] = new Bird(3, 5, Bird.E);
		maze[3][6] = new Bird(3, 6, Bird.W);
    
		// row 4
		maze[4][0] = new Bird(4, 0, Bird.N);
		maze[4][1] = new Bird(4, 1, Bird.NE);
		maze[4][2] = new Bird(4, 2, Bird.N);
		maze[4][3] = new Bird(4, 3, Bird.N);
		maze[4][4] = new Bird(4, 4, Bird.NE);
		maze[4][5] = new Bird(4, 5, Bird.W);
		maze[4][6] = new Bird(4, 6, Bird.N);
    
		start = maze[2][0];
		end   = maze[2][6];
    
		// for each Bird in the 2-D array 
		//   instantiate a queue to contain Bird objects 
		//   find the direction for this Bird
		//   calculate the indices for each Bird in the direction
		//   add a reference to each Bird along the direction to the queue
		//   call the Bird object's setBirdQueue method with the queue

		// write your code here
		for (int i = 0; i != maze.length; ++i){
			for (int j = 0; j != maze[i].length; ++j){
				Queue<Bird> birdQueue = new LinkedList<Bird>();
				int birdDirection = maze[i][j].getDirection();
	
				//north direction
				if (birdDirection == 0){
					for (int rowNorth = i - 1; rowNorth >= 0; rowNorth--){
						birdQueue.offer(maze[rowNorth][j]);
					}
					maze[i][j].setBirdQueue(birdQueue);
//					System.out.println(birdQueue);
				}
				
				//north east direction
				if (birdDirection == 1){
					for (int rowNorthEast = i, columnNorthEast = j;
						 rowNorthEast > 0 && columnNorthEast < maze[i].length - 1;
						 rowNorthEast--, columnNorthEast++ ){
						birdQueue.offer(maze[rowNorthEast - 1][columnNorthEast + 1]);					
					}
					maze[i][j].setBirdQueue(birdQueue);
//					System.out.println(birdQueue);
				}
				
				//east direction
				if (birdDirection == 2){
					for (int columnEast = j; columnEast < maze[i].length; columnEast++){
						birdQueue.offer(maze[i][columnEast]);
					}
					maze[i][j].setBirdQueue(birdQueue);
//					System.out.println(birdQueue);
				}
				
				//south east direction
				if (birdDirection == 3){
					for (int rowSouthEast = i, columnSouthEast = j;
						 rowSouthEast < maze.length - 1 && columnSouthEast < maze[i].length - 1;
						 rowSouthEast++, columnSouthEast++){
						birdQueue.offer(maze[rowSouthEast + 1][columnSouthEast + 1]);
					}
					maze[i][j].setBirdQueue(birdQueue);
//					System.out.println(birdQueue);
				}
				
				// south direction
				if (birdDirection == 4){
					for (int rowSouth = i; rowSouth < maze.length - 1; rowSouth++){
						birdQueue.offer(maze[rowSouth + 1][j]);
//						System.out.println(maze[rowSouth][j]);
					}
					maze[i][j].setBirdQueue(birdQueue);
//					System.out.println(birdQueue);
				}
				
				// south west direction
				if (birdDirection == 5){
					for (int rowSouthWest = i, columnSouthWest = j;
						 rowSouthWest < maze.length - 1 && columnSouthWest > 0;
						 rowSouthWest++, columnSouthWest--){
						birdQueue.offer(maze[rowSouthWest + 1][columnSouthWest - 1]);
					}
					maze[i][j].setBirdQueue(birdQueue);
//					System.out.println(birdQueue);
				}
				
				// west direction
				if (birdDirection == 6){
					for (int columnWest = j; columnWest > 0; columnWest--){
						birdQueue.offer(maze[i][columnWest - 1]);
					}
					maze[i][j].setBirdQueue(birdQueue);
//					System.out.println(birdQueue);
				}
				
				// north west direction
				if (birdDirection == 7){
					for (int rowNorthWest = i, columnNorthWest = j;
						 rowNorthWest > 0 && columnNorthWest > 0;
						 rowNorthWest--, columnNorthWest--){
						birdQueue.offer(maze[rowNorthWest - 1][columnNorthWest - 1]);
					}
					maze[i][j].setBirdQueue(birdQueue);
//					System.out.println(birdQueue);
				}
				
			}
		}
	}
  
	/**
	 * This is getting start bird
	 * @return to return start bird
	 */
	public Bird getStart()
	{
		return this.start;
	}
  
	/**
	 * This is to get the end bird
	 * @return to return end bird
	 */
	public Bird getEnd()
	{
		return this.end;
	}
  
}