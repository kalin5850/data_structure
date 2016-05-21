import junit.framework.TestCase;

/**
 * TestCase for CircularArrayQueue WITH need for expanding capacity
 * @author Bob Wilson
 * @version 08/10/2009
 * 
 * Tests the queue with overflow so that expand capacity is invoked inside
 */

public class QueueTest extends TestCase
{
  private QueueADT<Integer> myQueue;   // Queue to be tested
  private static final int SMALL_SIZE = 3;
  
  public void testExpandCapacity ()
  {
    // force wraparound without expansion
    
    myQueue = new CircularArrayQueue<Integer>(SMALL_SIZE);
    
    myQueue.enqueue(10);               // implicit autoboxing the int value 10
    myQueue.enqueue(20);               // implicit autoboxing the int value 20
    myQueue.enqueue(30);               // implicit autoboxing the int value 30
    
    assertEquals(10, (int) myQueue.first());
    assertEquals(10, (int) myQueue.dequeue());
    assertEquals(2, myQueue.size());
    assertEquals(false, myQueue.isEmpty());
    
    assertEquals(20, (int) myQueue.first());
    assertEquals(20, (int) myQueue.dequeue());
    assertEquals(1, myQueue.size());
    assertEquals(false, myQueue.isEmpty());
    
    myQueue.enqueue(40);               // implicit autoboxing the int value 40
    myQueue.enqueue(50);               // implicit autoboxing the int value 50
    
    // force expansion of circular buffer inside

    myQueue.enqueue(60);               // implicit autoboxing the int value 60
    
    // test state of queue after expansion
    assertTrue(myQueue.size() > SMALL_SIZE);  // note: larger than original capacity
    assertEquals(false, myQueue.isEmpty());
    
    assertEquals(30, (int) myQueue.first());
    assertEquals(30, (int) myQueue.dequeue());
    assertEquals(3, myQueue.size());
    assertEquals(false, myQueue.isEmpty());
    
    assertEquals(40, (int) myQueue.first());
    assertEquals(40, (int) myQueue.dequeue());
    assertEquals(2, myQueue.size());
    assertEquals(false, myQueue.isEmpty());
    
    assertEquals(50, (int) myQueue.first());
    assertEquals(50, (int) myQueue.dequeue());
    assertEquals(1, myQueue.size());
    assertEquals(false, myQueue.isEmpty());
    
    assertEquals(60, (int) myQueue.first());
    assertEquals(60, (int) myQueue.dequeue());
    assertEquals(0, myQueue.size());
    assertEquals(true, myQueue.isEmpty());
  }
}