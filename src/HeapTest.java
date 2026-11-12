import static org.junit.Assert.*;

import java.beans.Transient;

import org.junit.Test;

public class HeapTest {

    /* Unit Tests for:
    - add()
    - pop()
    - peek()
    - size()
    - isEmpty() */

    // Heap Reference
    Heap heap = new Heap(10);

    @Test
    void testAddNode() {
        int nums[] = {10, 20};
        heap.add(20);
        assertEquals(nums, heap);
    }

    @Test
    void testPop() {
        int nums[] = {20};
        heap.pop();
        assertEquals(nums, heap);

    }
    @Test
    void testPeek() {
        int val = 20;
        assertEquals(val, heap.peek());


    }
    @Test 
    void testSize() {
        int size = 1;
        

    }
    @Test
    void testIsEmpty(){
        Heap heap = new Heap(10);
        assertTrue(heap.isEmpty());
    }
}
