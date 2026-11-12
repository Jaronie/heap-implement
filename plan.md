Heap Implementation Plans by Jaron Bautista

After reviewing ` Heap.java ` and `HeapRunner.java `, my plan is to construct a Heap data structure in the form of a min-heap - a type of heap where as the tree progresses the values within the heap grow in size/value.

The methods I am considering implementing in ` Heap.java ` is as follows:

` -- Heap.java -- `
<h1> Variables </h1>
<ul>
<li>capacity & size -- for upsizing possible list and tracking
<li>items[ ] -- initial backing list
</ul>
<h1>Methods</h1>
<ul>


<li>add( i ) -- adds a node to the heap
<li>pop() -- pops the front of the heap
<li>peek() -- displays the front of the heap without removing it
<li>size() -- returns the amount of existing data in the heap
<li>isEmpty() -- returns a boolean result determining existence of values in heap

</ul>
<h1>Helper Methods</h1>
<ul>
<li> getParent( i ) - returns node values and/or sets
<li> getLeftChild( i ), getRightChild( i ) - returns node values and/or sets
<li> hasParent( i ), hasLeftChild( i ), hasRightChild( i ) -- checks for parent node or children
</ul>

-- </> --