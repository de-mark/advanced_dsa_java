package stacks;

public class ArrayStack {
    private int[] stack;
    private int top;

    public ArrayStack(int size) {
        stack = new int[size];
        top = -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int newItem) {
        if (!isFull()) {
            top++;
            stack[top] = newItem;
        } else {
            System.out.println("Stack is full; please remove before adding");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stack[top--];
        } else {
            System.out.println("Stack is empty; please add items to stack before removing");
            return -1;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack is empty; please add items to stack before peeking.");
            return -1;
        }
    }
}
