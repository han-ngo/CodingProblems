import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /* Questions:
     *      ASCII or Unicode string
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scan = new Scanner(file);

        ArrayList<String> strings = new ArrayList<>();
        while (scan.hasNextLine()) {
            strings.add(scan.nextLine());
        }
        scan.close();

        boolean[] results = eachString(strings);
        for (boolean result : results) {
            System.out.println(result);
        }
    }

    /* Time Complexity: O(n) */
    private static boolean isUnique_extraSpace(String s) {
        int MAX_LENGTH = 256;
        int[] ascii = new int[MAX_LENGTH];
        for (int i = 0; i < s.length(); i++) {
            int value = (int) s.charAt(i);
            ascii[value]++;
            if (ascii[s.charAt(i)] > 1) {
                return false;
            }
        }
        return true;
    }

    /* Time Complexity: O(n)
     * Note: Only valid for alphabetical string & Not case sensitive */
    private static boolean isUnique_checker(String s) {
        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - 'a';
            if ((checker & (1<<value)) > 0) {
                return false;
            }
            checker |= 1<<value;
        }
        return true;
    }

    /* Time Complexity: O(n log n) */
    private static boolean isUnique_noExtraSpace(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i] == chars[i+1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean[] eachString(ArrayList<String> strings) {
        int len = strings.size();
        boolean[] results = new boolean[len];
        for (int i = 0; i < len; i++) {
            results[i] = isUnique_noExtraSpace(strings.get(i));
        }
        return results;
    }
}