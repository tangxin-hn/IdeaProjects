package second;

import java.util.LinkedList;
import java.util.List;

public class NodeGroupInLevel {
    int levelNum;
    int thresholdNum;
    List<Level> levels;
    static long count = 0;
    public NodeGroupInLevel(List<Level> levels, int levelNum, int thresholdNum) {
        System.out.println("NodeGroupInLevel：" + count++);
        this.levelNum = levelNum;
        this.thresholdNum = thresholdNum;
        this.levels = levels;
    }
    public void getNodeGroupList() {
        List<Integer> integerList = new LinkedList<>();
        recursionGroup(integerList,levels.get(levelNum).levelNode.size(),0);
    }
    public void recursionGroup(List<Integer> integerList, int length, int pos) {
        if (pos==length) {
            Result.getGroupResult(integerList,levels,levelNum);
            for (int i=1;i<levelNum;i++) {
                levels.get(i).resetCountMap();
            }
            return;
        }
        recursionGroup(integerList,length,pos+1);
        integerList.add(pos);
        recursionGroup(integerList,length,pos+1);
        integerList.remove(integerList.size()-1);
    }
}
