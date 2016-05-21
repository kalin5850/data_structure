/**
 * This class implement a each cell for Sudoku puzzle.
 * @author Kai Lin Chang
 * @version 1.0
 */

public class Cell {
	private int value;
	
	/**
	 * This constructs a value for each cell.
	 * @param value the value of a cell
	 */
	public Cell(int value){
		this.value = value;
	}
	
	/**
	 * This is to get value
	 * @return This returns value.
	 */
	public int getValue(){
		return value;
	}
	
	/**
	 * This is to compare the two values
	 * return true if two values are the same.
	 * @param that
	 * @return
	 */
	public boolean equals(Cell that){
		return this.value == that.value;
	}

	/**
	 * This to print a value.
	 */
	public String toString(){
		return " " + value;
	}

}
