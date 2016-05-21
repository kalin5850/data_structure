//********************************************************************
//  BingoNumber.java     Author: Bob Wilson
//                       Adapted: from Lewis and Chase
//
//  CS210 Lab 01 - Fall 2011
//  Represents a number used in a Bingo game.
//********************************************************************

public class BingoNumber
{
	
	protected char letter;
	protected int number;
  
  /******************************************************************
    Sets up this Bingo number with the specified number and the
    appropriate letter.
  ******************************************************************/
	public BingoNumber (int num)
	{
		number = num;
    
		if (num <= 15)
			letter = 'B';
		else
			if (num <= 30)
				letter = 'I';
			else
				if (num <= 45)
					letter = 'N';
				else
					if (num <= 60)
						letter = 'G';
					else
						letter = 'O';
	}
  
  /******************************************************************
    Returns a boolean true if this number equals that number.
    Returns false otherwise.
  ******************************************************************/
  
	public boolean equals (BingoNumber that)
	{
		return that != null && this.number == that.number;
	}
  
  /******************************************************************
    Returns a string representation of this Bingo number.
  ******************************************************************/
	public String toString ()
	{
		return (letter + " " + ((number > 9) ? number : "0" + number));
	}
}
