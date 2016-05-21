// BingoCard.java       Author: Kai
//
// Date: Sept. 17, 2015

public class BingoCard{
  private BingoSquare[][] myBingoCard;
  public final int num = 5;
  
// Constructor to initialize BingoCard  
  public BingoCard(){
    myBingoCard = new BingoSquare[num][num];
    int k = 1;
    for (int i = 0; i < num; i++)
    {
      for (int j = 0; j < num; j++)
      {
        myBingoCard[i][j] = new BingoSquare(3 * k);
        k++;
        if (i == ( num - 1) / 2 && j == ( num - 1) / 2){
          myBingoCard[i][j] = null;
        }
      }
    }
  }
  
  public boolean cover(BingoNumber myNumber ){ 
    myNumber = new BingoBall(myNumber.number);
    for (int i = 0; i < num; i++){
      for (int j = 0; j < num; j++){
        if (myNumber.equals(myBingoCard[i][j])){
          myBingoCard[i][j] = null;
          return true;
        }
      }
    }
    return false; 
  }
  
  public boolean hasBingo(){
    int countRowNull = 0;
    int countColumnNull = 0;
    int countDiagonalNullLeft = 0;
    int countDiagonalNullRight= 0;
    
    // to count DiagonalNull(left to right)
    for (int i = 0; i < num; i++){
      if (myBingoCard[i][i] == null){
        countDiagonalNullLeft++;
      }
      if (countDiagonalNullLeft == num){
        return true;
      }
    }
    
    // to count DiagonalNull(right to left)
    int k = num - 1;
    for (int i = 0; i < num; i++){
      if(myBingoCard[i][k]==null){
        countDiagonalNullRight++;
      }
      k--;
      if (countDiagonalNullRight == num){
        return true;
      }
    }
    
    // to count ColumnNull
    for (int i = 0; i < num; i++){
      countColumnNull = 0;
      for (int j = 0; j < num; j++){
        if (myBingoCard[i][j] == null){
          countColumnNull++;
        }
        if (countColumnNull == num){
          return true;
        }
      }
    }
    
    // to count RowNull
    for ( int j = 0; j < num; j++){
      countRowNull = 0;
      for ( int i = 0; i < num; i++){
        if (myBingoCard[i][j] == null){
          countRowNull++;
        }
        if (countRowNull == num){ 
          return true;
        }
      }
    }
    return false;
  }
 
 // To print the BingoCard 
  public String toString(){
	  String result = "";
	  for (int i = 0; i != num; i++){
		  for(int j = 0; j != num; j++){
			  if (i <= j){
				  BingoSquare temp = myBingoCard[i][j];
				  myBingoCard[i][j] = myBingoCard[j][i];
				  myBingoCard[j][i] = temp; 
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