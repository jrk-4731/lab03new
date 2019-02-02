package rit.stu.act1;

import rit.cs.Queue;
import rit.cs.Node;

/**
 * A queue implementation that uses a Node to represent the structure.
 * @param <T> The type of data the queue will hold
 * @author Sean Strout @ RIT CS
 * @author Jake Koerner
 */
public class QueueNode<T> implements Queue<T> {
    /**
     * Create an empty queue.
     */

    private Node<T> queue;
    private Node<T> back;

    public QueueNode() {
        this.queue=new Node<>(null, null);
        this.back=this.queue;
    }

    @Override
    public T back() {
        assert !this.empty();
        return this.back.getData();
    }

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

    @Override
    public boolean empty() {
        return this.queue.getData()==null;
    }

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

    @Override
    public T front() {
        assert !this.empty();
        return this.queue.getData();
    }
}
