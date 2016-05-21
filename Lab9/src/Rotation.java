import java.util.Iterator;

public class Rotation
{
  public static void main(String [] args)
  {
    // set up the test case binary tree for right rotation (L&C Figure 13.10)
    LinkedBinaryTree<String> greatgrandchildLeft = new LinkedBinaryTree<String>("3");
    LinkedBinaryTree<String> grandchildLeft = new LinkedBinaryTree<String>("5", greatgrandchildLeft, null);
    LinkedBinaryTree<String> grandchildRight = new LinkedBinaryTree<String>("10", null, null);
    LinkedBinaryTree<String> childLeft = new LinkedBinaryTree<String>("7", grandchildLeft, grandchildRight);
    LinkedBinaryTree<String> childRight = new LinkedBinaryTree<String>("15", null, null);
    LinkedBinaryTree<String> rightTree = new LinkedBinaryTree<String>("13",childLeft, childRight);
    
    // set up the test case binary tree for left rotation (L&C Figure 13.11)
    LinkedBinaryTree<String> greatgrandchildRight = new LinkedBinaryTree<String>("15");
                             grandchildLeft = new LinkedBinaryTree<String>("7");
                             grandchildRight = new LinkedBinaryTree<String>("13", null, greatgrandchildRight);
                             childLeft = new LinkedBinaryTree<String>("3", null, null);
                             childRight = new LinkedBinaryTree<String>("10", grandchildLeft, grandchildRight);
    LinkedBinaryTree<String> leftTree = new LinkedBinaryTree<String>("5",childLeft, childRight);
                                             
    System.out.println("Contents of rightTree before right rotation");
    Iterator<String> itr = rightTree.iteratorLevelOrder();
    while (itr.hasNext())
      System.out.println(itr.next());
    
    rightTree.rotateRight();
    
    System.out.println("Contents of rightTree after right rotation");
    itr = rightTree.iteratorLevelOrder();
    while (itr.hasNext())
      System.out.println(itr.next());
    System.out.println();
    
    System.out.println("Contents of leftTree before left rotation");
    itr = leftTree.iteratorLevelOrder();
    while (itr.hasNext())
      System.out.println(itr.next());
    
    leftTree.rotateLeft();
    
    System.out.println("Contents of leftTree after left rotation");
    itr = leftTree.iteratorLevelOrder();
    while (itr.hasNext())
      System.out.println(itr.next());
  }
}