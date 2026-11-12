import java.util.Arrays;
import java.util.NoSuchElementException;

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

    public Heap(int capacity){
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }
    /* Helper Methods */
    private int getLeftChild(int parentIndex) { return 2 * parentIndex + 1; }
    private int getRightChild(int parentIndex) { return 2 * parentIndex + 2; }
    private int getParent(int childIndex) { return (childIndex - 1) / 2;}

    private boolean hasLeftChild(int index) { return getLeftChild(index) < size; }
    private boolean hasRightChild(int index) { return getRightChild(index) < size;}
    private boolean hasParent(int index) { return getParent(index) >= 0; }

    private void swap(int indexOne, int indexTwo){ // swap method used for shifting nodes when deleting/adding
        int temp = items[indexOne];
        items[indexOne] = items [indexTwo];
        items[indexTwo] = temp;
    }

    private void shiftUp(){
        int index = size - 1;
        while(hasParent(index) && parent(index) > items[index]) {
            swap(getParent(index), index);
            index = getParent(index);
        }

    }

    private void shiftDown(){
        int index = 0;
        while(hasLeftChild(index)) {
            int smallChild = getLeftChild(index);
            if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallChild = getRightChild(index);
            }

            if(items[index] < items[smallChild]){
                break;
            } else {
                swap(index, smallChild);

            }
            index = smallChild;
        }

        
    }



    private int leftChild(int index) { return items[getLeftChild(index)];}
    private int rightChild(int index) { return items[getRightChild(index)];}
    private int parent(int index) { return items[getParent(index)];}

    private void ensureExtraCapacity() {
        if(size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }

    }

    public void add(int item){
        ensureExtraCapacity();
        items[size] = item;
        size++;
        shiftUp();

    }

    public void pop(){
        if(size == 0) throw new NoSuchElementException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        shiftDown();
        

    }

    public int peek(){
        if(size == 0) throw new IllegalStateException();
        return items[0];
        
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size != 0;
    }



}