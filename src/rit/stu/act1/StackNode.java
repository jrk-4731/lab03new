package rit.stu.act1;

import rit.cs.Stack;
import rit.cs.Node;

/**
 * A stack implementation that uses a Node to represent the structure.
 * @param <T> The type of data the stack will hold
 * @author Sean Strout @ RIT CS
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */


public class StackNode<T> implements Stack<T> {

    /**
     * Create an empty stack.
     */
    private Node<T> stack;

    public StackNode() {
        this.stack=new Node<>(null, null);

    }

    @Override
    public boolean empty() {
        return this.stack.getData()==null;
    }

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

    @Override
    public void push(T element) {
        if (this.empty()){
            this.stack.setData(element);
        }
        else{
            this.stack=new Node<>(element, this.stack);
        }
    }

    @Override
    public T top() {
        assert !empty();
        return this.stack.getData();
    }
}
