package first;

import java.util.List;

public class TestNodeGroupInLevel {
    public static void main(String[] args) {
        NodeGroupInLevel temp = new NodeGroupInLevel(8);
        for (List list : temp.nodeGroupList) {
            System.out.println(list);
        }
        System.out.println(Math.pow(2,temp.level.levelNode.size()));
        System.out.println(temp.nodeGroupList.size());
    }
}
