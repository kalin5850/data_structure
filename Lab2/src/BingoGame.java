//********************************************************************
//  BingoGame.java       Author: Bob Wilson
//
//  CS210 Lab 02 - Fall 2006
//  Driver to test cover method in BingoCard class
//********************************************************************

public class BingoGame
{
  /******************************************************************
    Creates myBingoCard as a 5 x 5 array of BingoBalls
    Creates 5 specific BingoBalls and covers myBingocard
    Prints "Bingo" on a true return from cover method
    Prints final state of myBingoCard
  *******************************************************************/
  public static void main (String[] args)
  {
    // create my Bingo Card
    BingoCard myBingoCard = new BingoCard();
    
    // create some Bingo Balls, cover on myBingoCard, and check for Bingo
    // change BingoBall values to test numbers on and not on your card
    // test at least one Bingo on a row, a column, or a diagonal
    if (myBingoCard.cover(new BingoBall(1)) && myBingoCard.hasBingo())  // not on myBingoCard
      System.out.println("Bingo on 1st");    
    if (myBingoCard.cover(new BingoBall(3)) && myBingoCard.hasBingo())  // next four are a diagonal
      System.out.println("Bingo on 2nd");
    if (myBingoCard.cover(new BingoBall(21)) && myBingoCard.hasBingo())
      System.out.println("Bingo on 3rd");
    if (myBingoCard.cover(new BingoBall(57)) && myBingoCard.hasBingo())
      System.out.println("Bingo on 4th");
    if (myBingoCard.cover(new BingoBall(75)) && myBingoCard.hasBingo())
      System.out.println("Bingo on 5th");
    
    // print the final state of myBingoCard
    System.out.println(myBingoCard);
  }
}
