package p59;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueWithMax <T extends Comparable> {
    private Queue<T> queue;
    private Deque<T> max;
    public QueueWithMax() {
        queue = new LinkedList<>();
        max = new ArrayDeque<>();
    }
    public void push(T val) {
        queue.offer(val);
        while (!max.isEmpty() && max.getLast().compareTo(val) < 0)
            max.pollLast();
        max.offer(val);
    }
    public T pop() {
        T temp = queue.poll();
        if (temp.compareTo(max.getFirst())==0)
            max.pollFirst();
        return temp;
    }
    public T getMax() {
        return max.getFirst();
    }
    public static void main(String[] args) {
        QueueWithMax<Integer> queue = new QueueWithMax<>();
        queue.push(2);
        System.out.println(queue.getMax());

        // {2, 3}
        queue.push(3);
        System.out.println(queue.getMax());

        // {2, 3, 4}
        queue.push(4);
        System.out.println(queue.getMax());

        // {2, 3, 4, 2}
        queue.push(2);
        System.out.println(queue.getMax());

        // {3, 4, 2}
        queue.pop();
        System.out.println(queue.getMax());

        // {4, 2}
        queue.pop();
        System.out.println(queue.getMax());

        // {2}
        queue.pop();
        System.out.println(queue.getMax());

        // {2, 6}
        queue.push(6);
        System.out.println(queue.getMax());

        // {2, 6, 2}
        queue.push(2);
        System.out.println(queue.getMax());

        // {2, 6, 2, 5}
        queue.push(5);
        System.out.println(queue.getMax());

        // {6, 2, 5}
        queue.pop();
        System.out.println(queue.getMax());

        // {2, 5}
        queue.pop();
        System.out.println(queue.getMax());

        // {5}
        queue.pop();
        System.out.println(queue.getMax());

        // {5, 1}
        queue.push(1);
        System.out.println(queue.getMax());
    }
}
