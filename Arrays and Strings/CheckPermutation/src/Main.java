import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    /* Questions:
     *      Case sensitive?
     *      Whitespace is significant?
     */
    public static final int MAX_LENGTH = 256;
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scan = new Scanner(file);

        String s1 = scan.next();
        String s2 = scan.next();
        scan.close();

        System.out.println(arePermutation(s1, s2));
    }

    /* Time Complexity:  O(n) */
    private static boolean arePermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count = new int[MAX_LENGTH];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i)]--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }

    /* Time Complexity:  O(n) but extra data structure */
    private static boolean myArePermutation(String s1, String s2) {
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

    /* Time Complexity:  O(n)
     * Clean, simple, and easy to understand */
    private static boolean arePermutation_sort(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }
}