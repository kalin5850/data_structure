import java.util.*;
import java.io.*;

/** 
 * This class instantiates a Sudoku object passing a Scanner on a
 * file to the Sudoku constructor.  It prints the puzzle using the
 * Sudoku toString method.  It determines if the digit matrix is a
 * valid solution for a Sudoku puzzle or not and prints the result.
 * 
 * @version 01/05/2012
 * @author Bob Wilson
 * 
 */

public class SudokuValidator
{
  private Sudoku puzzle;
  
  /**
   * @param args - not used
   */
  public static void main( String [] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter name of file containing puzzle to verify");   
    SudokuValidator myValidator = new SudokuValidator(scan.nextLine());
    System.out.println(myValidator.isSolution() ? 
                "It is a valid solution" : "It is not a valid solution");
    
 }
    
  public SudokuValidator(String fileName)
  {
    Scanner file = null;
    try
    {
      file = new Scanner(new File(fileName));
    }
    catch (Exception e)
    {
      System.out.println("Bad file name");
      System.exit(0);
    }
    
    puzzle = new Sudoku(file);
    System.out.println(puzzle);
  }
  
  /**
   * This is to check if the Sudoku has the a correct solution 
   * @return return true if it is a correct solution;
   * false if it is a not correct solution
   */
  public boolean isSolution()
  {
    // write your code to validate the puzzle solution here
	  Iterator<Cell []> iter = puzzle.iterator();
	  
	  boolean rowCheck = false;
	  boolean colCheck = false;
	  boolean boxCheck = false;
	  
	  // check row value
	  while (iter.hasNext()){
		  Cell[] value = iter.next();
		  for (int i = 0; i < value.length; i++){
			  for (int j = i + 1; j < value.length; j++){
				  if (value[i].getValue() == value[j].getValue()){
					  rowCheck = false;
					  for (int k = 0; k < value.length; k++){
						  System.out.print(value[k]);
					  }
					  System.out.println();
					  break;
				  }
				  else{
					  rowCheck = true;
				  }
			  }
			  if (rowCheck == false) { break; }
		  }
		  if (rowCheck == false) { break; }
	  }
	  
	  //check column value
	  iter = puzzle.iterator();
	  puzzle.status = 2;
	  while (iter.hasNext()){
		  Cell[] value = iter.next();
		  for (int i = 0; i < (value.length-1); i++){
			  for (int j = i + 1; j < value.length; j++){
				  if (value[i].getValue() == value[j].getValue()){
					  colCheck = false;
					  for (int k = 0; k < value.length; k++){
						  System.out.print(value[k]);
					  }
					  System.out.print("\n"); 
					  break;
				  }
				  else{
					  colCheck = true;
				  }  
			  }
			  if (colCheck == false) { break; } 
		  }
		  if (colCheck == false) { break; }
	  }	
		  
	  // check box value
	  iter = puzzle.iterator();
	  puzzle.status = 3;
	  while (iter.hasNext()){
		  Cell[] value = iter.next();
		  for (int i = 0; i < (value.length-1); i++){
			  for (int j = i + 1; j < value.length; j++){
				  if (value[i].getValue() == value[j].getValue()){
					  boxCheck = false;
					  for (int k = 0; k < value.length; k++){
						  System.out.print(value[k]);
					  }
					  System.out.print("\n"); 
					  break;
				  } else {
					  boxCheck = true;
				  }
			  }
			  if (boxCheck == false) { break; } 
		  }
		  if (boxCheck == false) { break; } 
	  }			  
	  
	  System.out.println();
	  
	  if(rowCheck == true && colCheck == true && boxCheck == true){
		  return true;
	  }
	  else{
		  return false;
	  }
 
    
  }
}  /* 201340 */
