import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(3,3);
        treeMap.put(1,1);
        treeMap.put(2,2);
        System.out.print(treeMap.pollFirstEntry().getKey());
        System.out.print(treeMap.pollFirstEntry().getKey());
        System.out.print(treeMap.pollFirstEntry().getKey());
    }
}
