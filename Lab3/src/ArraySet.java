import java.util.*;

/************************************************************
 * This class extends from ArrayList to keep BingoBall
 * @author Kai Lin Chang
 * @version 1.0
 * Date: Oct. 11, 2015
 *
 * @param <T> T is generice type
 * @param rand rand is a radom object
 ************************************************************/
public class ArraySet<T> extends ArrayList<T>{
	private Random rand;
	
	/**
	 * This constructs its super class and 
	 * instantiate a random object
	 */
	public ArraySet(){
		super();
		rand = new Random();
	}
	
	/**
	 * This is to check the element being added,
	 * return true if the element exists;
	 * otherwise, return false
	 */
	public boolean add(T elememt){
		if(!super.contains(elememt))
			return true;
		return false;
	}
	
	/**
	 * This method is to remove an index from ArraySet
	 * @param size the size of ArrarSet
	 * @return return an element being removed from ArraySet
	 */
	public T removeRandom(int size){
		return super.remove(rand.nextInt(size - 1));
	}
}
