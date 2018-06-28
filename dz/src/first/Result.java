package first;

import java.util.LinkedList;
import java.util.List;

public class Result {
    public static void getResult(int levelNum, int thresholdNum) {
        NodeGroupInLevel firstGroup = new NodeGroupInLevel(levelNum);
        for(List<Integer> group : firstGroup.nodeGroupList) {
            getGroupResult(group,firstGroup.level,levelNum,thresholdNum);
        }
    }
    public static void getGroupResult(List<Integer> group,Level level,int levelNum,int thresholdNum){
        boolean flag = true;
        if (group.size()<1)
            return;
        List<Node> upGroup = new LinkedList<>();
        for (Integer integer : group) {
            upGroup.add(level.levelNode.get(integer));
        }
        List<Node> resultGroup = upGroup;
        List<Node> downGroup = new LinkedList<>();
        Level upLevel = level;
        for(int i=levelNum-1;i>=thresholdNum;i--) {
            Level downLevel = new Level(i);
            for (Node upNode : upGroup) {
                for (Node downNode : upNode.nextLevel) {
                    downGroup.add(downNode);
                    downLevel.countMap.get(downNode).addAll(upLevel.countMap.get(upNode));
                    if (i==levelNum-1)
                        downLevel.countMap.get(downNode).add(upNode);
                }
            }
            for (Node downNode : downLevel.levelNode) {
                if (downLevel.countMap.get(downNode).size()>1) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            upLevel = downLevel;
            upGroup = downGroup;
            downGroup = new LinkedList<>();
        }
        if (!flag)
            return;
        Level downLevel = new Level(thresholdNum-1);
        for (Node upNode : upGroup) {
            for (Node downNode : upNode.nextLevel) {
                downGroup.add(downNode);
                downLevel.countMap.get(downNode).addAll(upLevel.countMap.get(upNode));
            }
        }
        for (Node downNode : downLevel.levelNode) {
            if (downLevel.countMap.get(downNode).size()==1) {
                flag = false;
                break;
            }
        }
        if (!flag)
            return;
        for (Node node : resultGroup) {
            System.out.print(node.nodeList + " ");
        }
        System.out.println();
    }
}
