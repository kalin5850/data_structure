//********************************************************************
//  BingoGame.java       Author: Bob Wilson
//
//  CS210 Lab 01 - Fall 2006
//  Initial Driver for BingoCard Testing
//********************************************************************

public class BingoGame
{
  /******************************************************************
    Creates myBingoCard (a 5 x 5 array of BingoSquares)
    Prints the contents of myBingocard
  *******************************************************************/
	public static void main (String[] args)
	{
    // create a bingo card
		BingoCard myBingoCard = new BingoCard();

    // display the contents of myBingoCard
		System.out.println(myBingoCard);
	}
}
