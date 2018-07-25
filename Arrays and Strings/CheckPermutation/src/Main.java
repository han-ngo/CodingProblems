import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scan = new Scanner(file);

        String s1 = scan.next();
        String s2 = scan.next();
        scan.close();

        System.out.println(arePermutation(s1, s2));
    }

    /* Time Complexity:  O(n)*/
    private static boolean arePermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        for (int i : map.values()) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}