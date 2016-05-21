import java.util.*;
import java.io.*;
import javax.swing.*;

public class BalanceCheck
{
	public static void main(String [] args)
	{
		Scanner file = null;
		JFileChooser myChooser = new JFileChooser();
		int status = myChooser.showOpenDialog(null);
		try
		{
			file = new Scanner(myChooser.getSelectedFile());
		}
		catch (Exception e)
		{
			System.out.println("Can not open File");
			System.exit(0);
		}
    
        // instantiate a stack to hold wrapper class Character objects
        // 1.  add a line of code here to do that
		Stack<Character> checkDelimiter = new Stack<Character>();
    
		char c1 = ' ';   // current character from the line
		char c2 = ' ';   // last {, (, or [ character (from stack)
    
		boolean error = false;
		while (!error && file.hasNext())
		{
			String line = file.nextLine();
      
			for (int i = 0; !error && i < line.length(); i++)
			{
        // 2.  add code here to do the balance check using the stack 
				c1 = line.charAt(i);
				if (c1 == '{' || c1 == '(' || c1 == '['){
					char temp = checkDelimiter.push(c1);
/////					System.out.print("push.c1: "+ temp + " --->");
				}
				if (c1 == '}' || c1 == ')' || c1 ==']'){
					char lastStack = checkDelimiter.peek();
					if (c1 == '}' && lastStack == '{' || 
						c1 == ')' && lastStack == '(' || 
						c1 == ']' && lastStack == '['){						
						c2 = checkDelimiter.pop();
/////						System.out.print("pop.c2:" + c2 + " --->");
					}
					else {
						error = true;
						c2 = checkDelimiter.peek();
						break;
					}
				}
			}
/////			System.out.println();
		}
/////		System.out.println(checkDelimiter.size());
/////		System.out.println(checkDelimiter);
/////		System.out.println("c1:"+ c1+" "+"c2:"+ c2);
/////		System.out.println("error is "+ error);
    
        // 3.  add code here to print the results of the balance check
		if (error){
			System.out.println("mismatched pair " + c1 + " and " + c2);
		}
		if (!error && checkDelimiter.empty()){
			System.out.println("the balance check is OK");
		}
		if (!error && !checkDelimiter.empty()){
			System.out.println("there are missing closing delimiters");
		}
	}
}