import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scan = new Scanner(file);

        /* Getting input */
        ArrayList<Integer> a = new ArrayList<>();

       while (scan.hasNextInt()) {
           a.add(scan.nextInt());
       }

       scan.close();

       int count = bulbs(a);
       System.out.println(count);
    }

    public static int bulbs(ArrayList<Integer> a) {
        int count = 0;
        boolean switched = false;
        ArrayList<Integer> cur = a;

        for (int i = 0; i < a.size(); i++) {
            if (!switched && cur.get(i) == 0) {
                count++;
                switched = true;
            } else if (switched && cur.get(i) == 1) {
                count++;
                switched = false;
            }
        }

        return count;
    }

    private static int flip(int num) {
        switch (num) {
            case 0:
                return 1;
            case 1:
                return 0;
        }
        return -1;
    }
}
