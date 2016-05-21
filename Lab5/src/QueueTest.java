import junit.framework.TestCase;

/**
 * TestCase for CircularArrayQueue WITHOUT need for expanding capacity
 * @author Bob Wilson
 * @version 7/31/2006
 * 
 * Tests the queue first without wraparound then with wraparound
 */

public class QueueTest extends TestCase
{
  private QueueADT<Integer> myQueue;   // Queue to be tested
  private static final int SMALL_SIZE = 3;
    
  public void testConstruction()
  {
    // instantiate myQueue as a new CircularArrayQueue for Integer Objects
    myQueue = new CircularArrayQueue<Integer>(SMALL_SIZE);
    
    // check for proper initial state
    assertEquals(0, myQueue.size());
    assertEquals(true, myQueue.isEmpty());
    assertEquals("", myQueue.toString());
    
  }
  
  public void testEnqueuingNoWrap()
  {
    // instantiate myQueue as a new CircularArrayQueue for Integer Objects
    myQueue = new CircularArrayQueue<Integer>(SMALL_SIZE);
    
    // test enqueuing without wraparound of circular buffer inside
    myQueue.enqueue(new Integer(10));  // explicitly wrapping the int value 10
    myQueue.enqueue(20);               // implicit autoboxing the int value 20
    assertEquals(2, myQueue.size());
    assertEquals(false, myQueue.isEmpty());
   
  }
  
  public void testDequeuingNoWrap()
  {
    // instantiate myQueue as a new CircularArrayQueue for Integer Objects
    myQueue = new CircularArrayQueue<Integer>(SMALL_SIZE);
    
    // re-establish state of queue without wraparound of circular buffer inside
    myQueue.enqueue(new Integer(10));  // explicitly wrapping the int value 10
    myQueue.enqueue(20);               // implicit autoboxing the int value 20
    
    
    // test peeking and dequeuing twice without wraparound of circular buffer inside
    assertEquals(10, (int) myQueue.first());
    assertEquals(10, (int) myQueue.dequeue());
    assertEquals(1, myQueue.size());
    assertEquals(false, myQueue.isEmpty());
    
    assertEquals(20, (int) myQueue.first());
    assertEquals(20, (int) myQueue.dequeue());
    assertEquals(0, myQueue.size());
    assertEquals(true, myQueue.isEmpty());
  }
  
  public void testWrapAround ()
  {
    // instantiate myQueue as a new CircularArrayQueue for Integer Objects
    myQueue = new CircularArrayQueue<Integer>(SMALL_SIZE);
    
    // re-establish state of queue without wraparound of circular buffer inside
    myQueue.enqueue(new Integer(10));  // explicitly wrapping the int value 10
    myQueue.enqueue(20);               // implicit autoboxing the int value 20
    
    // dequeue twice without wraparound of circular buffer inside
    assertEquals(10, (int) myQueue.dequeue());
    assertEquals(20, (int) myQueue.dequeue());
    
    // enqueue twice to cause wraparound of circular buffer inside
    myQueue.enqueue(new Integer(30));  // explicitly wrapping the int value 30
    myQueue.enqueue(40);               // implicit autoboxing the int value 40
    
    // test state of queue after wraparound
    assertEquals(2, myQueue.size());
    assertEquals(false, myQueue.isEmpty());
    
    // dequeue twice with wraparound of circular buffer inside
    assertEquals(30, (int) myQueue.first());
    assertEquals(30, (int) myQueue.dequeue());
    assertEquals(1, myQueue.size());
    assertEquals(false, myQueue.isEmpty());
    
    assertEquals(40, (int) myQueue.first());
    assertEquals(40, (int) myQueue.dequeue());
    assertEquals(0, myQueue.size());
    assertEquals(true, myQueue.isEmpty());
  }
}
  