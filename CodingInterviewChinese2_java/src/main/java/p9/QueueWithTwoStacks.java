package p9;

import java.util.Stack;

public class QueueWithTwoStacks {
    static void test(char actual, char expected)
    {
        if(actual == expected)
            System.out.println("test passed.");
        else
            System.out.println("test failed.");
    }
    public static void main(String[] args) {
        MyQueue<Character> queue = new MyQueue<>();

        queue.appendTail('a');
        queue.appendTail('b');
        queue.appendTail('c');
        char head=0;
        try {
            head = queue.deleteHead();
        }catch (Exception e) {
            System.out.println(e);
        }

        test(head, 'a');

        try {
            head = queue.deleteHead();
        }catch (Exception e) {
            System.out.println(e);
        }
        test(head, 'b');

        queue.appendTail('d');
        try {
            head = queue.deleteHead();
        }catch (Exception e) {
            System.out.println(e);
        }
        test(head, 'c');

        queue.appendTail('e');
        try {
            head = queue.deleteHead();
        }catch (Exception e) {
            System.out.println(e);
        }
        test(head, 'd');

        try {
            head = queue.deleteHead();
        }catch (Exception e) {
            System.out.println(e);
        }
        test(head, 'e');
    }
}
class MyQueue<T> {
    private Stack<T> in = new Stack<T>();
    private Stack<T> out = new Stack<T>();

    void appendTail(T node) {
        in.push(node);
    }

    T deleteHead() throws Exception {
        if (!out.empty()) {
            return out.pop();
        }
        if (in.empty()) {
            throw new Exception("queue is empty");
        }
        while (!in.empty()) {
            out.push(in.pop());
        }
        return out.pop();
    }
}