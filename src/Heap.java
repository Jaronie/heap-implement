/**
 * A min-heap. 
 * 
 * Must contain functionality for the following: (n = # of elements in heap)
 * 
 * Adding a new value to the heap  O(log(n))
 * Popping the front of the heap O(log(n))
 * Peeking at the front of the heap without removing the element O(1)
 * Getting the size of the heap O(1)
 * Checking whether the heap is empty O(1)
 * 
 * 
 * The Heap must hold ints
 * 
 * Use List/ArrayList as a backing array, but DO NOT use the 
 * PriorityQueue class. Do not make Node objects, use array
 * indexing instead.
 * 
 * It is up to you to make design decisions about how to:
 *  - name methods
 *  - determine return value and argument types
 *  - hold private instance variables
 */
public class Heap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity]; // backing list

    /* Helper Methods */
    private int getLeftChild(int parentIndex) { return 2 * parentIndex + 1; }
    private int getRightChild(int parentIndex) { return 2 * parentIndex + 2; }
    private int getParent(int childIndex) { return (childIndex - 1) / 2;}

    private boolean hasLeftChild(int index) { return getLeftChild(index) < size; }
    private boolean hasRightChild(int index) { return getRightChild(index) < size;}
    private boolean hasParent(int index) { return getParent(index) >= 0; }


    private int leftChild(int index) { return items[getLeftChild(index)];}
    private int rightChild(int index) { return items[getRightChild(index)];}
    private int parent(int index) { return items[getParent(index)];}

    private void ensureExtraCapacity() {

    }

    private void add(int item){

    }

    private void pop(int item){
        
    }

    private void peek(int item){
        
    }


}