import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * A min-heap.
 * 
 * Must contain functionality for the following: (n = # of elements in heap)
 * 
 * Adding a new value to the heap O(log(n))
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
 * - name methods
 * - determine return value and argument types
 * - hold private instance variables
 */
public class Heap {
    private ArrayList<> heap;
    private int capacity;
    private int size;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.heap = new ArrayList<>(); // backing list
        this.size = 0;
    }

    /* Helper Methods */
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private void swap(int indexOne, int indexTwo) { // swap method used for shifting nodes when deleting/adding
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    private void shiftUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }

    }

    private void shiftDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallChild = getLeftChild(index);
            if (hasRightChild(index) && getRightChildIndex(index) < getLeftChildIndex(index)) {
                smallChild = getRightChildIndex(index);
            }

            if (items[index] < items[smallChild]) {
                break;
            } else {
                swap(index, smallChild);

            }
            index = smallChild;
        }

    }

    public void add(int item) {
        items[size] = item;
        size++;
        shiftUp();

    }

    public void pop() {
        if (size == 0)
            throw new NoSuchElementException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        shiftDown();

    }

    public int peek() {
        if (size == 0)
            throw new IllegalStateException();
        return items[0];

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size != 0;
    }

}