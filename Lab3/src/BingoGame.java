
/******************************************************
 * This is to run a Bingo Game
 * @author Kai Lin Chang
 * @version 1.0
 * Date: Oct. 11, 2015
 ******************************************************/
public class BingoGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArraySet<BingoBall> myBingo = new ArraySet<BingoBall>();		
		for (int i = 0; i < 75; i++){
			myBingo.add(i, new BingoBall(i+1));
		}
		
		BingoCard myBingoCard = new BingoCard();				
		while(true){
			if (myBingoCard.cover(myBingo.removeRandom(myBingo.size())) && myBingoCard.hasBingo()){
				System.out.println("Bingo!");
				break;
			}
		}
				
		System.out.print(myBingoCard.toString());
	}
}
		
//		boolean chk = true;
//		double g = -1.0;
		
//		int b = (int) (g * 75);
//		System.out.println(b + " , " + g);
//		System.out.println(myBingo.get(b));
//		System.out.print(myBingoCard.toString());	
/*		int b;
		while(true){ 
			chk = true;
			//g = -1.0;
			while(chk){
				g = Math.random();
				if(g!=0){
					chk=false;
				}
			}
			//System.out.println("g : " + g);
			b = (int) (g * 75);
			System.out.println("=> "+ b + " : "+myBingoCard.cover(myBingo.get(b))+" <="+myBingoCard.hasBingo());
			if(myBingoCard.cover(myBingo.get(b)) && myBingoCard.hasBingo()){
					break;			
			}
		}*/	



