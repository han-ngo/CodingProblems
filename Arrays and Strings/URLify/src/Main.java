import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scan = new Scanner(file);

        while (scan.hasNext()) {
            String s = scan.next();
            if (!scan.hasNext()) {
                System.out.println(s);
                break;
            }
            System.out.print(s + "%20");
        }
        scan.close();
    }

}