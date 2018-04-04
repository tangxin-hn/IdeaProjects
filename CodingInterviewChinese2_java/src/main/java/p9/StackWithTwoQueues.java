package p9;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueues {
    public static void main(String[] args) {
        MyStack<Character> stack = new MyStack<>();
        stack.appendTail('a');
        stack.appendTail('b');
        stack.appendTail('c');
        try {
            System.out.println(stack.deleteTail());
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            System.out.println(stack.deleteTail());
        } catch (Exception e) {
            System.out.println(e);
        }
        stack.appendTail('d');
        stack.appendTail('e');
        try {
            System.out.println(stack.deleteTail());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
class MyStack<T> {
    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();
    void appendTail(T node) {
        queue1.offer(node);
    }
    T deleteTail() throws Exception {
        if (queue1.isEmpty()) {
            throw new Exception("stack is empty");
        }
        T temp = queue1.poll();
        while (!queue1.isEmpty()) {
            queue2.offer(temp);
            temp = queue1.poll();
        }
        Queue<T> tQueue = queue1;
        queue1 = queue2;
        queue2 = tQueue;
        return temp;
    }
}
