import java.util.*;
/*
    Max Stack

    Design a stack data structure that supports the following operations in O(1) time:

    push(int value): Push an integer onto the stack.
    pop(): Remove and return the element at the top of the stack.
    top(): Return the element at the top without removing it.
    getMax(): Return the largest element currently in the stack.
 */

public class MaxStack {
    Stack<Integer> mainStack;
    Stack<Integer> maxStack;
    public MaxStack() {
        this.mainStack = new Stack<Integer>();
        this.maxStack = new Stack<Integer>();
    }
    /*
        main = [1]
        max =  []
     */

    public void push(int value) {
        this.mainStack.push(value);
        if (this.maxStack.empty() || this.mainStack.peek() <= value) {
            this.maxStack.push(value);
        }
    }

    public void pop() {
        if (this.mainStack.peek().equals(this.maxStack.peek())) {
            this.maxStack.pop();
        }
        this.mainStack.pop();
    }

    public int top() {
        return this.mainStack.peek();
    }

    public int getMax() {
        return this.maxStack.peek();
    }
}
