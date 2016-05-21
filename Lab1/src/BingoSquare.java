/**
 * This class extends BingoNumber
 * @author changkailin
 * @version 1.0
 */
public class BingoSquare extends BingoNumber
{
	public BingoSquare(int num)
	{
		super(num);
	}
/**
 * This is to compare two numbers:
 * return true if two numbers are the same;
 * otherwise return false  
 */
	public boolean equals(BingoNumber that)
	{
		return this.number == that.number;
	}
}