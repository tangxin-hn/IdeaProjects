import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args){
        Scanner scanner;
        try {
            scanner = new Scanner(new File("test.txt"));
            int [] tall = new int [100];
            int i = 0;
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    tall[i] = scanner.nextInt();
                    System.out.println(tall[i]);
                    i++;
                } else {
                    scanner.next();
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
