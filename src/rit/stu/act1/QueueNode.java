package rit.stu.act1;

import rit.cs.Queue;
import rit.cs.Node;

/**
 * A queue implementation that uses a Node to represent the structure.
 * @param <T> The type of data the queue will hold
 * @author Sean Strout @ RIT CS
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public class QueueNode<T> implements Queue<T> {

    /**Using the node class as the underlying structure of the queue*/
    private Node<T> queue;

    /**Using a new node object to keep track of the back of the queue*/
    private Node<T> back;

    /**
     * Creates empty queue
     */
    public QueueNode() {
        this.queue=new Node<>(null, null);
        this.back=this.queue;
    }

    /**Following method documentation copied from Queue interface*/

    /**
     * Get the last element in the queue.
     * @rit.pre queue must not be empty
     * @throws AssertionError if queue empty
     * @return the back element
     */
    @Override
    public T back() {
        assert !this.empty();
        return this.back.getData();
    }

    /**
     * Remove and return the front element in the queue.
     * @rit.pre queue must not be empty
     * @throws AssertionError if queue empty
     * @return the front element
     */
    @Override
    public T dequeue() {
        assert !this.empty();
        T element = this.queue.getData();
        if (this.queue.getNext()==null){
            this.queue.setData(null);
        }
        else{
            this.queue=this.queue.getNext();
        }
        return element;
    }

    /**
     * Check if the queue is currently empty or not.
     * @return true if empty, false otherwise
     */
    @Override
    public boolean empty() {
        return this.queue.getData()==null;
    }

    /**
     * Add a new element to the back of the queue.
     * @param element The new data element
     */
    @Override
    public void enqueue(T element) {
        Node to_add=new Node(element, null);
        if (this.empty()){
            this.queue=to_add;
            this.back=to_add;
        }
        else{
            this.back.setNext(to_add);
            this.back=this.back.getNext();
        }
    }

    /**
     * Get the front element in the queue.
     * @rit.pre queue must not be empty
     * @throws AssertionError if queue empty
     * @return the front element
     */
    @Override
    public T front() {
        assert !this.empty();
        return this.queue.getData();
    }
}
