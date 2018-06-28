package first;

public class TestLevel {
    public static void main(String[] args) {

        for(int i=1;i<=20;i++) {
            Level level = new Level(i);
            System.out.println(level.levelNode.size());
        }
        /**
        for (Node node : level.levelNode)
            System.out.println(node.nodeList);
        System.out.println(level.levelNode.size());

        for (Map.Entry<Node, Integer> entry : level.countMap.entrySet()) {
            System.out.println(entry.getKey().nodeList + " " + entry.getValue());
        }
        **/
    }
}
