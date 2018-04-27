package p30;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackWithMin <T extends Comparable> {
    private Stack<T> data = new Stack<>();
    private Stack<T> min = new Stack<>();
    public T pop() {
        if (data.empty())
            throw new EmptyStackException();
        if (min.peek()==data.peek()) {
            min.pop();
        }
        return data.pop();
    }
    public void push(T val) {
        data.push(val);
        if (min.empty() || val.compareTo(min.peek())<=0)
            min.push(val);
    }
    public T minVal() {
        if (data.empty())
            throw new EmptyStackException();
        return min.peek();
    }

    public static void main(String[] args) {
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(3);
        System.out.println(stack.minVal());

        stack.push(4);
        System.out.println(stack.minVal());

        stack.push(2);
        System.out.println(stack.minVal());

        stack.push(3);
        System.out.println(stack.minVal());

        stack.pop();
        System.out.println(stack.minVal());

        stack.pop();
        System.out.println(stack.minVal());

        stack.pop();
        System.out.println(stack.minVal());

        stack.push(0);
        System.out.println(stack.minVal());
    }
}
