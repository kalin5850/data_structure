//********************************************************************
// AVLLinkedBinarySearchTree.java      
//
// Implements the AVL Binary Search Tree with links
// - Bob Wilson 05/11/2015
// - uses balance factor attribute stored in node 
//********************************************************************

public class AVLLinkedBinarySearchTree<T extends Comparable<T>>
{
   protected int count;
   protected AVLBinarySearchTreeNode<T> root;
   
   /******************************************************************
     Creates an empty binary search tree.
   ******************************************************************/
   public AVLLinkedBinarySearchTree() 
   {
      root = null;
      count = 0;
   }
      
   public boolean isEmpty()
   {
     return count == 0;
   }

   /******************************************************************
     Adds the specified object to the binary search tree in the
     appropriate position according to its key value.  Note that
     equal elements are added to the right.  Rebalances after adding.
   ******************************************************************/
   public void addElement (T element) 
   {
      AVLBinarySearchTreeNode<T> node = new AVLBinarySearchTreeNode<T> (element);

      if (isEmpty())
         root = node;
      else 
      {
         AVLBinarySearchTreeNode<T> current = root;
         boolean added = false;

         while (!added) 
         {
            if (element.compareTo(current.element) < 0)
            {
               if (current.left == null)     // look the left side
               {
                  current.left = node;
                  node.parent = current;
                  added = true;
               } 
               else
                  current = current.left;
            }
            else
            {
               if (current.right == null)    // look the right side
               {
                  current.right = node;
                  node.parent = current;
                  added = true;
               } 
               else
                  current = current.right;
            }
         }
            
         // now go back up the tree rebalancing
         while (current != null) {
           if (added) {
        	 // there are two cases  
             // case1: we previously added node as a child of current node
             if (node == current.left) {
               // node is left child of current
               current.balanceFactor--;
               if (current.balanceFactor == 0) {
                 added = false;
               }
             }
             else {                
               // case2: node is right child of current
               current.balanceFactor++;
               if (current.balanceFactor == 0) {
                 added = false;
               }
             }
           }
           
           // balanceFactor can be not zero
           if (rebalance(current)) {
             current = null; 	// if rebalanced, stop!!
           }
           else {
             node = current;
             current = node.parent;
           }
         }
      }
      count++;  // increment parent attribute
   }
   
   private boolean rebalance(AVLBinarySearchTreeNode<T> node)
   {
     // AVL tree logic for addElement and removeElement methods
     // determine if any need for rotation at this node and rebalance
     // if rebalance performed, return true - otherwise return false

     // TODO: add your code here
	   
	   // node balanceFactor = -2 and lefe node balanceFactor = 0 or -1
	   // right rotation
	   if (node.balanceFactor == -2 && (node.left.balanceFactor == -1 || node.left.balanceFactor == 0)){
		   rotateRight(node);
		   System.out.println("Perform right rotation around: " + node);
		   return true;
	   }
	   
	   // node balanceFactor = -2 and lefe node balanceFactor = 1
	   // leftright rotation
	   if (node.balanceFactor == -2 && node.left.balanceFactor == 1){
		   rotateLeft(node.left);
		   rotateRight(node);
		   System.out.println("Perform left-right rotation around: " + node);
		   return true;
	   }
	   
	   // node balanceFactor = 2 and right node balanceFactor = -1
	   // rightleft rotation
	   if (node.balanceFactor == 2 && node.right.balanceFactor == -1){
		   rotateRight(node.right);
		   rotateLeft(node);
		   System.out.println("Perform right-left rotation around: " + node);
		   return true;
	   }
	   
	   // node balanceFactor = 2 and right node balanceFactor = 1 or 0
	   //  left rotation
	   if (node.balanceFactor == 2 && (node.right.balanceFactor == 1 || node.right.balanceFactor == 0)){
		   rotateLeft(node);
		   System.out.println("Perform left rotation around: " + node);
		   return true;
	   }
	   
	   return false;   // stub to allow it to compile

   }

   private void rotateLeft(AVLBinarySearchTreeNode<T> pivot)
   {
     AVLBinarySearchTreeNode<T> parent = pivot.parent;
     AVLBinarySearchTreeNode<T> newPivot = pivot.right;
     newPivot.parent = pivot.parent;
     
     if (parent != null) {        // we are attached to a node in the path to the root
       if (pivot == parent.left)
         parent.left = newPivot;  // on the left
       else
         parent.right = newPivot; // on the right
     } 
     else                         // or we are at root of the tree
       this.root = newPivot;
     
     pivot.right = newPivot.left;
     if (pivot.right != null)
        pivot.right.parent = pivot;
     
     newPivot.left = pivot;
     pivot.parent = newPivot;
     
     // adjust balance factors
     // TODO: add your code here
     // only update newPivot and Pivot
     
     pivot.balanceFactor = pivot.balanceFactor - 1 - Math.max(newPivot.balanceFactor, 0);
     newPivot.balanceFactor = newPivot.balanceFactor - 1 + Math.min(pivot.balanceFactor, 0);
   }
   
   private void rotateRight(AVLBinarySearchTreeNode<T> pivot)
   {
     AVLBinarySearchTreeNode<T> parent = pivot.parent;
     AVLBinarySearchTreeNode<T> newPivot = pivot.left;
     newPivot.parent = pivot.parent;

     if (parent != null) {        // we are attached to a node in the path to the root
       if (parent.left == pivot)
         parent.left = newPivot;  // on the left
       else
         parent.right = newPivot; // on the right
     }
     else                         // or we are at root of the tree
       this.root = newPivot;
     
     pivot.left = newPivot.right;
     if (pivot.left != null)
       pivot.left.parent = pivot;
     
     newPivot.right = pivot;
     pivot.parent = newPivot;
     
     // adjust balance factors
     // TODO: add your code here
//     updateBalanceFacetor(pivot, newPivot);
     
     pivot.balanceFactor = pivot.balanceFactor + 1 - Math.min(newPivot.balanceFactor, 0);
     newPivot.balanceFactor = newPivot.balanceFactor + 1 + Math.max(pivot.balanceFactor, 0);
     
//     updateBalanceFacetor(pivot, newPivot);
     
   }
   
   private void updateBalanceFacetor(AVLBinarySearchTreeNode<T> pivot, AVLBinarySearchTreeNode<T> newPivot){
	   int countRight = 0, countLeft = 0;
	   if (pivot.left == null && pivot.right == null){
		   pivot.balanceFactor = 0;
	   }
	   if (pivot.left == null){
		   countRight = 1 + pivot.right.balanceFactor;
	   }
	   if (pivot.right == null){
		   countLeft = 1 - pivot.left.balanceFactor;
	   }
	   pivot.balanceFactor = countRight - countLeft;
	   newPivot.balanceFactor = (1 + countRight + countLeft) - (1 - newPivot.left.balanceFactor);
	   
   } 
/*   
   private void updateBalanceFacetor(AVLBinarySearchTreeNode<T> node){
	   int countRight = 0, countLeft = 0;
	   if (node.left == null && node.right == null){
		   node.balanceFactor = 0;
	   }
	   else if (node.left == null){
		   
	   }
	   else if (node.right == null){
		   countLeft += 1;
		   updateBalanceFacetor(node.left);
	   }
   } 
*/   
   /******************************************************************
     Removes the first element that matches the specified target
     element from the binary search tree and returns a reference to
     it.  Returns null if the specified target element is not found.
   ******************************************************************/
   public T removeElement (T targetElement)
   {
      T result = null;

      AVLBinarySearchTreeNode<T> current = root;           // start at root
      boolean found = false;
      while (current != null && !found) {                  // look for target
        if (targetElement.equals(current.element)) { 
          found = true;
          count--;
          result =  current.element;
        } // end found
        else                                               // keep looking
        {
          if (targetElement.compareTo(current.element) < 0)
            current = current.left;
          else
            current = current.right;
        }
      } // end while
      
      // rebalance after a successful find
      // swape the in order sucessor to be root
      if (result != null) {
        // move replacement elements upward until we reach a leaf
        AVLBinarySearchTreeNode<T> newCurrent = replacement(current);
        while (newCurrent != null) {
          current.element = newCurrent.element;
          current = newCurrent;
          newCurrent = replacement(current);
        }
           
        if (current == root)   // if we are still at the root
          root = null;
        else {
          // remove leaf node that is now irrelevent and rebalance upward
          if (current == current.parent.left) {
            current.parent.left = null;
            current.parent.balanceFactor++;
          }
          else {
            current.parent.right = null;
            current.parent.balanceFactor--;    
          }
                  
          // rebalance upward from parent of leaf node removed
          while (current.parent != null) {
            if (rebalance(current.parent)) {             // if its unbalanced, rebalance                
              current = root;                            // and now we didn't shorten the height
            }
            else if (current.parent.balanceFactor != 0)  // it still in balance
              current = root;                            // but we didn't shorten the height
            else //we shortened the height so continue the loop upward
              current = current.parent;
                    
            if (current.parent != null) {
              if (current == current.parent.left) 
                current.parent.balanceFactor++;          // current is on the left of its parent
              else 
                current.parent.balanceFactor--;          // current is on the right of its parent
            }
          }
        }
      }
      return result;
   }

   /******************************************************************
     Returns a reference to a node that will replace the one
     specified for removal.  In the case where the removed node has 
     two children, the inorder successor is used as its replacement.
   ******************************************************************/
   private AVLBinarySearchTreeNode<T> replacement (AVLBinarySearchTreeNode<T> node) 
   {
      AVLBinarySearchTreeNode<T> result = null;

      if ((node.left == null)&&(node.right==null))
         result = null;
      
      else if ((node.left != null)&&(node.right==null))
         result = node.left;
      
      else if ((node.left == null)&&(node.right != null))
         result = node.right;
      
      else
      {
         // to find "inorder successor" 
         // go down one level on the right
         AVLBinarySearchTreeNode<T> current = node.right;
         
         // and go down as many levels as possible on the left
         while (current.left != null)
            current = current.left;
         result = current;
      }
      return result;
   }
   
   public void displayState()
   {
     System.out.println("-------------------------\nState of Tree at Top");
     if (root != null) {
       System.out.println("Root Element: " + root.element);
       System.out.println("Balance Factor: " + root.balanceFactor);
       System.out.println("Parent: " + root.parent);
       System.out.println();
       if (root.left != null) {
         System.out.println("Left Element: " + root.left.element);
         System.out.println("Balance Factor: " + root.left.balanceFactor);
         System.out.println("Parent: " + root.left.parent.element);
         System.out.println();
       
         if (root.left.left != null) {
           System.out.println("Left Left Element: " + root.left.left.element);
           System.out.println("Balance Factor: " + root.left.left.balanceFactor);
           System.out.println("Parent: " + root.left.left.parent.element);
           System.out.println();
         }
         if (root.left.right != null) {
           System.out.println("Left Right Element: " + root.left.right.element);
           System.out.println("Balance Factor: " + root.left.right.balanceFactor);
           System.out.println("Parent: " + root.left.right.parent.element);
           System.out.println();
         }
       }
       if (root.right != null) {
         System.out.println("Right Element: " + root.right.element);
         System.out.println("Balance Factor: " + root.right.balanceFactor); 
         System.out.println("Parent: " + root.right.parent.element);
         System.out.println();
         if (root.right.left != null) {
           System.out.println("Right Left Element: " + root.right.left.element);
           System.out.println("Balance Factor: " + root.right.left.balanceFactor); 
           System.out.println("Parent: " + root.right.left.parent.element);
           System.out.println();
         }
         if (root.right.right != null) {
           System.out.println("Right Right Element: " + root.right.right.element);
           System.out.println("Balance Factor: " + root.right.right.balanceFactor); 
           System.out.println("Parent: " + root.right.right.parent.element);
         }
       }
     }
   System.out.println("----------------------------");
   }
}
