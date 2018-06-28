package first;

import java.util.LinkedList;
import java.util.List;

public class NodeGroupInLevel {
    int levelNum;
    Level level;
    List<List<Integer>> nodeGroupList;
    //Map<List<Node>,Boolean> nodeGroupList2 = new HashMap<>();
    public NodeGroupInLevel(int levelNum) {
        this.levelNum = levelNum;
        level = new Level(levelNum);
        nodeGroupList = getNodeGroupList();
    }
    public List<List<Integer>> getNodeGroupList() {
        List<List<Integer>> nodeGroupList = new LinkedList<>();
        List<Integer> integerList = new LinkedList<>();
        recursionGroup(nodeGroupList,integerList,level.levelNode.size(),0);
        return nodeGroupList;
    }
    public void recursionGroup(List<List<Integer>> nodeGroupList, List<Integer> integerList, int length, int pos) {
        if (pos==length) {
            nodeGroupList.add(new LinkedList<>(integerList));
            return;
        }
        recursionGroup(nodeGroupList,integerList,length,pos+1);
        integerList.add(pos);
        recursionGroup(nodeGroupList,integerList,length,pos+1);
        integerList.remove(integerList.size()-1);
    }
}
