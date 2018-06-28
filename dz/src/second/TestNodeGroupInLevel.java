package second;

import java.util.LinkedList;
import java.util.List;

public class TestNodeGroupInLevel {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int levelNum = 8;
        List<Level> levels = new LinkedList<>();
        levels.add(null);
        for (int i=1;i<=levelNum;i++) {
            levels.add(new Level(i));
        }
        NodeGroupInLevel groups = new NodeGroupInLevel(levels,levelNum,levelNum-1);
        long mid = System.currentTimeMillis();
        long initializationTime = mid - start;
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println("initialization time:" + initializationTime);

        groups.getNodeGroupList();
        /**
        for (int i=levelNum-1;i>1;i--) {
            long start2 = System.currentTimeMillis();
            System.out.println(levelNum + "-" + i);
            groups.thresholdNum = i;
            groups.getNodeGroupList();
            System.out.print(System.currentTimeMillis()-start2);
            System.out.println();
        }
         **/
        long end = System.currentTimeMillis();
        long useTime = end - start;
        System.out.println("initialization time:" + initializationTime);
        System.out.println("time:" + useTime);
    }
}
