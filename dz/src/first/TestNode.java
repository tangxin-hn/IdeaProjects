package first;

import java.util.LinkedList;
import java.util.List;

public class TestNode {
    public static void main(String[] args) {
        //int[] array = {1,7};
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(8);
        list.add(7);
        Node node = new Node(list);
        Node node1 = new Node(new LinkedList<>(list));
        System.out.println(node.nodeList);
        for (Node nodes : node.nextLevel)
            System.out.println(nodes.nodeList);
        System.out.print(node.equals(node1));
    }
}
