package RedBlackTree;

public interface RedBlackTreeInterface<E extends Comparable<E> > {
    Node<E> INSERT(RedBlackTreeInterface<E> T, Node<E> z);
    Node<E> DELETE(RedBlackTreeInterface<E> T, Node<E> z);
}
