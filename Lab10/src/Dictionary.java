import java.util.*;

public class Dictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Call the appropriate TreeMap methods to add three key-values pairs of your own choosing
		TreeMap<String, String> myTree = new TreeMap<String, String>();
		myTree.put("nice", "pleasant; agreeable; satisfactory");
		myTree.put("good", "to be desired or approved of");
		myTree.put("excellent", "extremely good");
		
		// Call the appropriate method to print the contents of the dictionary.
		System.out.println(myTree);
		
		// Call the appropriate method to find and print the value for one of the key words that you used.
		System.out.println(myTree.get("excellent"));
		
		// Call the same method for a key word that you did not use and print the result.
		System.out.println(myTree.get("result"));
		
		// Call the appropriate method to delete one of the key-value pairs that you used.
		myTree.remove("good");
		
		// Call the appropriate method to verify that the value for that key can no longer be found and print a result showing that.
		System.out.println(myTree.get("good"));

	}

}
