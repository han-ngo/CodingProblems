import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Number of ways to Decode Messages
 * Given    'a' --> 1
 *          'b' --> 2
 *          'c' --> 3
 *              ...
 *          'z' --> 26
 * Example: data1 = "12"
 *          num_ways(data1) --> return 2
 *          Because: "12" --> "ab" OR "12 --> "l"
 *
 *          data2 = "0"
 *          num_ways(data2) --> return 0
 *          Because: no letter encoded to 0
 *
 * Note:    Assume data only contains digits from 0 to 9
 *          "" --> "" --> num_ways should return 1
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scan = new Scanner(file);

        ArrayList<String> datas = new ArrayList<>();
        while (scan.hasNextLine()) {
            datas.add(scan.nextLine());
        }
        scan.close();

        for (String data : datas) {
            System.out.println("Data: " + data);
            System.out.println(num_ways(data) + " way(s) to decode");
        }
    }

    /* Time Complexity:  O(n) with n = length of data */
    private static int num_ways(String data) {
       if (data.contains("0")) {
           return 0;
       }

       int count = 1;
       for (int i = 1; i < data.length(); i++) {
           count++;
           String num = "" + data.charAt(i-1) + data.charAt(i);
           if (Integer.parseInt(num) <= 26) {
               count++;
           }
       }
       return count;
    }
}