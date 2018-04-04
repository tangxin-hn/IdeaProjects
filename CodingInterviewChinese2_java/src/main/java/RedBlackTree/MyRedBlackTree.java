package redblacktree;

import java.awt.*;

public class MyRedBlackTree<E extends Comparable<E> >{
    private Node<E> root;
    private Node<E> nil;

    MyRedBlackTree() {
        root = null;
        nil = new Node<E>();
        nil.color = Color.black;
    }

    public void INORDER_WALK(Node<E> x) {
        if (x!=nil){
            INORDER_WALK(x.left);
            System.out.println(x.e);
            INORDER_WALK(x.right);
        }
    }

    public Node<E> SEACHER(Node<E> x,E k) {
        while (x!=nil && x.e.compareTo(k)==0) {
            if (x.e.compareTo(k)>0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }

    public Node<E> MININUM(Node<E> x) {
        while (x.left!=nil) {
            x = x.left;
        }
        return x;
    }

    public Node<E> MAXINUM(Node<E> x) {
        while (x.right!=nil) {
            x = x.right;
        }
        return x;
    }

    public Node<E> SUCCESSOR(Node<E> x) {
        if (x.right!=nil) {
            return MININUM(x.right);
        }
        Node<E> y = x.parent;
        while (y!=nil && x==y.right) {
            x = y;
            y = x.parent;
        }
        return y;
    }

    public Node<E> PREDECESSOR(Node<E> x) {
        if (x.left!=nil) {
            return MAXINUM(x.left);
        }
        Node<E> y = x.parent;
        while (y!=nil && x==y.left) {
            x = y;
            y = x.parent;
        }
        return y;
    }

    public void INSERT(MyRedBlackTree<E> T, Node<E> z) {
        Node<E> y=T.nil;
        Node<E> x=T.root;
        while (x!=T.nil) {
            y=x;
            if (z.e.compareTo(x.e)<0)
                x = x.left;
            else
                x = x.right;
        }
        z.parent = y;
        if (y==T.nil)
            T.root = z;
        else if (z.e.compareTo(y.e)<0)
            y.left = z;
        else
            y.right = z;
        z.left = T.nil;
        z.right = T.nil;
        z.color = Color.red;
        RB_INSERT_FIXUP(T,z);
    }

    public Node<E> DELETE(MyRedBlackTree<E> T, Node<E> z) {
        Node<E> x,y;
        if (z.left==T.nil || z.right==T.nil) {
            y = z;
        } else {
            y = SUCCESSOR(z);
        }
        if (y.left!=T.nil) {
            x = y.left;
        } else {
            x = y.right;
        }
        x.parent = y.parent;
        if (y.parent==T.nil) {
            T.root = x;
        } else if (y==y.parent.left){
            x = y.parent.left;
        } else {
            x = y.parent.right;
        }
        if (y!=z) {
            z.e = y.e;
        }
        if (y.color == Color.black)
            RB_DELETE_FIXUP(T,x);
        return y;
    }

    private void RB_INSERT_FIXUP(MyRedBlackTree<E> T, Node<E> z){
        while (z.parent.color==Color.red) {
            if (z.parent==z.parent.parent.left) {
                Node<E> y=z.parent.parent.right;
                if (y.color==Color.red) {
                    z.parent.color = Color.black;
                    y.color = Color.black;
                    z.parent.parent.color = Color.red;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        LEFT_ROTATE(T, z);
                    }
                    z.parent.color = Color.black;
                    z.parent.parent.color = Color.red;
                    RIGHT_ROTATE(T, z.parent.parent);
                }
            }else{
                Node<E> y=z.parent.parent.left;
                if (y.color==Color.red) {
                    z.parent.color = Color.black;
                    y.color = Color.black;
                    z.parent.parent.color = Color.red;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        RIGHT_ROTATE(T, z);
                    }
                    z.parent.color = Color.black;
                    z.parent.parent.color = Color.red;
                    LEFT_ROTATE(T, z.parent.parent);
                }
            }
        }
        T.root.color = Color.black;
    }

    private void RB_DELETE_FIXUP(MyRedBlackTree<E> T, Node<E> x){
        Node<E> w;
        while (x!=T.nil && x.color==Color.black) {
            if (x==x.parent.left) {
                w=x.parent.right;
                if (w.color==Color.red) {
                    x.color = Color.black;
                    LEFT_ROTATE(T,x.parent);
                    w = x.parent.right;
                }
                if (w.left.color==Color.black && w.right.color==Color.black) {
                    w.color = Color.red;
                    x = x.parent;
                } else {
                    if (w.right.color == Color.black) {
                        w.left.color = Color.black;
                        w.color = Color.red;
                        RIGHT_ROTATE(T, w);
                        w = x.parent.right;
                    }
                    w.color = x.parent.color;
                    x.parent.color = Color.black;
                    w.right.color = Color.black;
                    LEFT_ROTATE(T,x.parent);
                    x = T.root;
                }
            } else {
                w = x.parent.left;
                if (w.color==Color.red) {
                    w.color = Color.black;
                    RIGHT_ROTATE(T,x.parent);
                    w = x.parent.left;
                }
                if (w.left.color==Color.black && w.right.color==Color.black){
                    w.color = Color.red;
                    x = x.parent;
                } else {
                    if (w.left.color==Color.black) {
                        w.right.color = Color.black;
                        w.color = Color.red;
                        LEFT_ROTATE(T,w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = Color.black;
                    w.left.color = Color.black;
                    RIGHT_ROTATE(T,x.parent);
                    x = T.root;
                }
            }
        }
        x.color = Color.black;
    }

    private void LEFT_ROTATE(MyRedBlackTree<E> T, Node<E> x){
        Node<E> y = x.right;
        x.right = y.left;
        if (y.left!=T.nil)
            y.left.parent = x;
        y.parent = x.parent;
        if (x.parent==T.nil)
            T.root = y;
        else if (x==x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    private void RIGHT_ROTATE(MyRedBlackTree<E> T, Node<E> y){
        Node<E> x = y.left;
        y.left = x.right;
        if (x.right!=T.nil)
            x.right.parent = y;
        x.parent = y.parent;
        if (y.parent==T.nil)
            T.root = x;
        else if (y==y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;
        x.right = y;
        y.parent = x;
    }
}
