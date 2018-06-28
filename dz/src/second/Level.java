package second;

import java.util.*;

public class Level {
    final int levelNum;
    final List<Node> levelNode;
    Map<Node, Set<Node>> countMap;
    static long count = 0;
    public Level(int levelNum) {
        System.out.println("Level" + count++);
        this.levelNum = levelNum;
        levelNode = getLevelNode();
        countMap = getCountMap();
    }

    public List<Node> getLevelNode(){
        List<List<Integer>> result = new LinkedList<>();
        List<List<Integer>> listList = new LinkedList<>();
        List<Integer> integerList = new LinkedList<>();
        integerList.add(levelNum);
        List<Integer> tList = new LinkedList<>(integerList);
        listList.add(tList);
        while (!listList.isEmpty()) {
            tList = listList.remove(0);
            integerList = new LinkedList<>(tList);
            //if (result.contains(tList))
                //continue;
            result.add(tList);
            for (int i=0;i<integerList.size();i++) {
                if (integerList.get(i)!=1) {
                    List<Integer> tempList = new LinkedList<>(integerList);
                    int tempInt = tempList.remove(i);
                    for (int j=1;j<=integerList.get(i)/2;j++) {
                        tempList.add(j);
                        tempList.add(tempInt-j);
                        tList = new LinkedList<>(tempList);
                        Collections.sort(tList);
                        if (!listList.contains(tList))
                            listList.add(tList);
                        tempList.remove(tempList.size()-1);
                        tempList.remove(tempList.size()-1);
                    }
                    tempList.add(i,tempInt);
                }
            }
        }
        List<Node> finalResult = new LinkedList<>();
        for (List list : result) {
            finalResult.add(new Node(list));
        }
        return finalResult;
    }

    public Map<Node, Set<Node>> getCountMap() {
        Map<Node, Set<Node>> countMap = new HashMap<>();
        for (Node node : levelNode) {
            countMap.put(node,new HashSet<>());
        }
        return countMap;
    }

    public void resetCountMap() {
        for (Map.Entry<Node, Set<Node>> entry : countMap.entrySet()) {
            //System.out.println("resetCountMap");
            entry.getValue().clear();
        }
    }

}
