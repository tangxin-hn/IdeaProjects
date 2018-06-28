package first;

import java.util.*;

public class Node {
    List<Integer> nodeList;
    List<Node> nextLevel;
    public Node(List<Integer> nodeList){
        this.nodeList = nodeList;
        Collections.sort(this.nodeList);
        this.nextLevel = getNextLevel();
    }
    public List<Node> getNextLevel() {
        List<Node> nextLevel = new LinkedList<>();
        if (nodeList.isEmpty())
            return nextLevel;
        for (int i=0; i<nodeList.size(); i++) {
            if (i > 0 && nodeList.get(i-1) == nodeList.get(i))
                continue;
            if (nodeList.get(i) > 1) {
                nodeList.set(i,nodeList.get(i)-1);
                Node node = new Node(new LinkedList<>(nodeList));
                if (!nodeList.contains(node))
                    nextLevel.add(node);
                nodeList.set(i,nodeList.get(i)+1);
            } else {
                int temp = nodeList.remove(i);
                Node node = new Node(new LinkedList<>(nodeList));
                if (!nodeList.contains(node))
                    nextLevel.add(node);
                nodeList.add(i,temp);
            }
        }
        return nextLevel;
    }
    @Override
    public int hashCode() {
        int result = nodeList.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Node && this.nodeList.equals(((Node) obj).nodeList);
    }
}
