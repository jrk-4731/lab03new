package rit.stu.act1;

import rit.cs.Stack;
import rit.cs.Node;

/**
 * A stack implementation that uses a Node to represent the structure.
 * @param <T> The type of data the stack will hold
 * @author Sean Strout @ RIT CS
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */

/**
 * A StackNode class implementing the Stack interface and using the Node class
 * as the underlying data structure.
 *
 * @param <T> The type of data held in the StackNode.
 */
public class StackNode<T> implements Stack<T> {

    /**Using the node class to implement the stack*/
    private Node<T> stack;

    /**
     * Create an empty stack.
     */
    public StackNode() {
        this.stack=new Node<>(null, null);

    }

    /**The following documentation is copied from the Stack interface*/

    /**
     * Check if the stack is currently empty or not.
     * @return true if empty, false otherwise
     */
    @Override
    public boolean empty() {
        return this.stack.getData()==null;
    }

    /**
     * Remove and return the top element in the stack.
     * @rit.pre stack must not be empty
     * @throws AssertionError if stack empty
     * @return the front element
     */
    @Override
    public T pop() {
        assert !empty();
        T element=this.stack.getData();
        if (this.stack.getNext()==null){
            this.stack.setData(null);
        }
        else {
            this.stack = this.stack.getNext();
        }
        return element;
    }

    /**
     * Add a new element to the top of the stack.
     * @param element The new data element
     */
    @Override
    public void push(T element) {
        if (this.empty()){
            this.stack.setData(element);
        }
        else{
            this.stack=new Node<>(element, this.stack);
        }
    }

    /**
     * Get the top element on the stack.
     * @rit.pre stack must not be empty
     * @throws AssertionError if stack empty
     * @return The top element
     */
    @Override
    public T top() {
        assert !empty();
        return this.stack.getData();
    }
}
