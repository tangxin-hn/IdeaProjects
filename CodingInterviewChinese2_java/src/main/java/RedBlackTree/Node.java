package RedBlackTree;

import java.awt.*;

public class Node<E extends Comparable<E>> {
    E e;
    Node<E> left;
    Node<E> right;
    Node<E> parent;
    Color color;

    Node() {
        this.e = null;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.color = Color.red;
    }
    Node(E e) {
        this.e = e;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.color = Color.red;
    }
    public int compare(Node<E> n){
        return e.compareTo(n.e);
    }
}
