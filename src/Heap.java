import java.util.ArrayList;
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
    private final ArrayList<Integer> heap;

    public Heap() {
        heap = new ArrayList<>(); // backing list
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
        return getLeftChildIndex(index) < heap.size();
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < heap.size();
    }

    private boolean hasParent(int index) {
        return index >= 0;
    }

    private void swap(int indexOne, int indexTwo) { // swap method used for shifting nodes when deleting/adding
        int temp = heap.get(indexOne);
        heap.set(indexOne, heap.get(indexTwo));
        heap.set(indexTwo, temp);
    }

    private int leftChild(int index) {
        return heap.get(getLeftChildIndex(index));
    }

    private int rightChild(int index) {
        return heap.get(getRightChildIndex(index));
    }

    private int parent(int index) {
        return heap.get(getParentIndex(index));
    }

    private void shiftUp() {
        int index = heap.size() - 1;
        while (hasParent(index) && parent(index) > heap.get(index)) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }

    }

    private void shiftDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallChild = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallChild = getRightChildIndex(index);
            }

            if (heap.get(index) < heap.get(smallChild)) {
                break;
            } else {
                swap(index, smallChild);

            }
            index = smallChild;
        }

    }

    public void add(int item) {
        heap.add(item);
        shiftUp();

    }

    public int pop() {
        if (heap.isEmpty())
            throw new NoSuchElementException();
        int lastIdx = heap.size() - 1;
        int removedVal = heap.get(0);
        heap.set(0, heap.get(lastIdx));
        heap.remove(lastIdx);
        if (!heap.isEmpty()) {
            shiftDown();
        }

        return removedVal;

    }

    public int peek() {
        if (heap.isEmpty())
            throw new NoSuchElementException();
        return heap.get(0);

    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

}