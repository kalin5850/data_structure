import java.util.*;

/**
 * Sudoku class represents the matrix of cells in a Sudoku puzzle
 * @version 01/05/2012
 * @author Bob Wilson
 */

public class Sudoku implements Iterable<Cell []>
{
  private Cell [] [] puzzle;
  public int status; // 1:row , 2:column, 3:box
  /**
   * Default constructor should not be called.  Make it private.
   */
  private Sudoku() {}

  /**
   * Puzzle constructor that uses a Scanner object to read a file.
   * File contains 81 numbers that are the values of the 81 cells.
   * @param file a Scanner object on a File object
   */
  public Sudoku(Scanner file)
  {
    int size = file.nextInt();
    System.out.println("Size: " + size);
    puzzle = new Cell[size][size];
    for (int i = 0; i < size; i++)
      for (int j = 0; j < size; j++)
        puzzle[i][j] = new Cell(file.nextInt());
  }
  
  
  /**
   * Generates and returns a String representation of the puzzle cells
   * @return A String representing the contents of the puzzle array
   */
  public String toString()
  {
    // display the puzzle
    String value = "Puzzle is:\n";
    
    for (int i = 0; i < puzzle.length; i++) {
      for (int j = 0; j < puzzle[i].length; j++) 
        value += puzzle[i][j].toString();
      value += "\n";
    }
    return value;
  }
  
  /**
   * Instantiates and returns a new SudokuIterator object
   * @return A SudokuIterator object on the puzzle array
   */
  
   // write your code for the iterator method here
  public Iterator<Cell []> iterator(){
	  SudokuIterator mySudokuIterator = new SudokuIterator(puzzle);
	  return mySudokuIterator;
  }
  
  /**
   * This is a subclass that implements Iterator interface;
   * used to instantiate a double array
   * @author Kai Lin Chang
   *@version 1.0
   */
  private class SudokuIterator implements Iterator<Cell []> {
	  private int cursor;
	  private Cell [] [] puzzle;
	  
	  /**
	   * This constructs a double array with cursor and status. 
	   * @param puzzle puzzle is a double array
	   */
	  public SudokuIterator(Cell [] [] puzzle){
		  this.puzzle = puzzle;
		  cursor = 0;	
		  status = 1;
	  }
	  
	  /**
	   * This is to check if there are having any row
	   * that can read
	   */
	  public boolean hasNext(){
		  return cursor <  puzzle.length;
	  }
	  
	  /**
	   * This is to iterate each row, column, and box
	   * 
	   */
	  public Cell [] next(){		  
		  //return an alias of the row		  
		  Cell[] value = new Cell[puzzle.length];
		  //to get box length
		  int boxSize = (int) Math.sqrt(puzzle.length);
		  
		  // return each row 
		  if (status == 1){
			  for (int i = 0; i < puzzle.length; i++){
				  value[i] = puzzle[cursor][i];
			  }
		  }
		  
		  // return each column
		  else if (status == 2){			  
			  for (int i = 0; i < puzzle.length; i++){
				  value[i] = puzzle[i][cursor];
			  }
		  }
		  
		// return each box
		  else if (status == 3){
			  int cnt = 0;
			  int startRowBox = (cursor / boxSize ) * boxSize; 
			  int endRowBox = startRowBox + boxSize;
			  
			  int startColBox = (cursor % boxSize) * boxSize ; 
			  int endColBox = startColBox + boxSize;
			  
			  for (int i = startRowBox; i < endRowBox; i++){ // row
				  for (int j = startColBox; j < endColBox; j++){ // column
						  value[cnt] = puzzle[i][j];
						  cnt++;
				  }		
			  }
		  }
		  cursor++;
		  return value;
	  }
	  
	  public void remove(){
		  
	  }
  }
}  /* 201340 */
