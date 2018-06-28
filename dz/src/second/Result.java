package second;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Result {
    /**
    public static void getResult(int levelNum, int thresholdNum) {
        NodeGroupInLevel firstGroup = new NodeGroupInLevel(levelNum);
        for(List<Integer> group : firstGroup.nodeGroupList) {
            getGroupResult(group,firstGroup.level,levelNum,thresholdNum);
        }
    }
    **/
    static long count1 = 0;
    static long count2 = 0;
    public static void getGroupResult(List<Integer> group, List<Level> levels, int levelNum, int thresholdNum){
        //System.out.print("getGroupResult:" + count);
        boolean flag = true;
        if (group.size()<1)
            return;
        List<Node> upGroup = new LinkedList<>();
        for (Integer integer : group) {
            upGroup.add(levels.get(levelNum).levelNode.get(integer));
        }
        List<Node> resultGroup = upGroup;
        List<Node> downGroup = new LinkedList<>();
        Level upLevel = levels.get(levelNum);
        for(int i=levelNum-1;i>=thresholdNum;i--) {
            Level downLevel = levels.get(i);
            for (Node upNode : upGroup) {
                for (Node downNode : upNode.nextLevel) {
                    downGroup.add(downNode);
                    downLevel.countMap.get(downNode).addAll(upLevel.countMap.get(upNode));
                    if (i==levelNum-1)
                        downLevel.countMap.get(downNode).add(upNode);
                }
            }
            for (Map.Entry<Node,Set<Node>> entry : downLevel.countMap.entrySet()) {
                if (entry.getValue().size()>1){
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
        Level downLevel = levels.get(thresholdNum-1);
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
    public static void getGroupResult(List<Integer> group, List<Level> levels, int levelNum) {
        count1++;
        if (count1%10000==0) {
            count1 = 0;
            System.out.println("getGroupResult:" + count2++);
        }

        if (group.size()<1)
            return;

        List<Node> upGroup = new LinkedList<>();
        for (Integer integer : group) {
            upGroup.add(levels.get(levelNum).levelNode.get(integer));
        }
        List<Node> resultGroup = upGroup;
        List<Node> downGroup = new LinkedList<>();
        Level upLevel = levels.get(levelNum);

        for(int i=levelNum-1;i>=1;i--) {
            boolean flag1 = true;   //完全可区分
            boolean flag2 = true;   //完全不可区分
            Level downLevel = levels.get(i);
            for (Node upNode : upGroup) {
                for (Node downNode : upNode.nextLevel) {
                    downGroup.add(downNode);
                    downLevel.countMap.get(downNode).addAll(upLevel.countMap.get(upNode));
                    if (i==levelNum-1)
                        downLevel.countMap.get(downNode).add(upNode);
                }
            }
            for (Map.Entry<Node, Set<Node>> entry : downLevel.countMap.entrySet()) {
                if (entry.getValue().size()>1) { //不是完全可区分
                    flag1 = false;
                }
                if (entry.getValue().size() == 1) { //不是完全不可区分
                    flag2 = false;
                }
            }
            if (i!=levelNum-1 && flag2) {
                System.out.print(levelNum + "-" + (i + 1) + ": ");
                for (Node node : resultGroup) {
                    System.out.print(node.nodeList + " ");
                }
                System.out.println();
            }
            if (!flag1) {
                break;
            }
            upLevel = downLevel;
            upGroup = downGroup;
            downGroup = new LinkedList<>();
        }
    }
}
