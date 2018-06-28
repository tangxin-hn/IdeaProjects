package first;

public class Main {
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        int levelNum =6;
        for (int i=levelNum-1;i>=levelNum-1;i--) {
            System.out.println("/////////////////////////////////////////////////");
            System.out.println(levelNum + "-" + i);
            Result.getResult(levelNum,i);
            System.out.println();
        }
        long end = System.currentTimeMillis();
        long useTime = end - start;
        System.out.println(useTime);
    }
}
