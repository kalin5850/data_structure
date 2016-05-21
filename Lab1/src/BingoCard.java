// BingoCard.java       Author: Kai
/**
 * This is to print a BingoCard
 * @author changkailin
 * @version 1.0
 * Date: Sept. 17, 2015
 */
public class BingoCard{
	private BingoSquare[][] myBingoCard;
	public final int num = 5;
  
/**
 * This constructs a bingocard by square size
 */
	public BingoCard(){
		myBingoCard = new BingoSquare[num][num];
		int k = 1;
		for (int i = 0; i < num; i++){
			for (int j = 0; j < num; j++){
				myBingoCard[i][j] = new BingoSquare(3 * k);
				k++;
			}
		}
	}
 
/**
 * This is to print a bingo card
 */
	public String toString(){
		String result = "";
	  
		for (int i = 0; i != num; ++i){
			for(int j = 0; j != num; ++j){
				if (i <= j){
					BingoSquare temp = myBingoCard[i][j];
					myBingoCard[i][j] = myBingoCard[j][i];
					myBingoCard[j][i] = temp; 
				}
				if (i == ( num - 1) / 2 && j == ( num - 1) / 2){
					myBingoCard[i][j] = null;
				}
				if (myBingoCard[i][j] != null){
					result += myBingoCard[i][j].toString() + " ";
				}
				else{
					result += "**** ";
				}
			}
			result += "\n";
		}
	      
		return result;
	}
}