package p9;

import java.util.Stack;

public class QueueWithTwoStacks {
    static void Test(char actual, char expected)
    {
        if(actual == expected)
            System.out.println("Test passed.");
        else
            System.out.println("Test failed.");
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

        Test(head, 'a');

        try {
            head = queue.deleteHead();
        }catch (Exception e) {
            System.out.println(e);
        }
        Test(head, 'b');

        queue.appendTail('d');
        try {
            head = queue.deleteHead();
        }catch (Exception e) {
            System.out.println(e);
        }
        Test(head, 'c');

        queue.appendTail('e');
        try {
            head = queue.deleteHead();
        }catch (Exception e) {
            System.out.println(e);
        }
        Test(head, 'd');

        try {
            head = queue.deleteHead();
        }catch (Exception e) {
            System.out.println(e);
        }
        Test(head, 'e');
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