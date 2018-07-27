import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * String Compression: Implement a method to perform basic string compression
 * using the counts of repeated characters. For example, the string aabcccccaaa
 * would become a2b1c5a3. If the "compressed" string would not become smaller
 * than the original string, your method should return the original string.
 * You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scan = new Scanner(file);

        ArrayList<String> strings = new ArrayList<>();
        while (scan.hasNextLine()) {
            strings.add(scan.nextLine());
        }
        scan.close();

        for (String s : strings) {
            System.out.println(compress(s));
        }
    }

    /* Time Complexity:  O() */
    private static StringBuilder compress(String s) {
        if (isUnique(s)) {
            return new StringBuilder(s);
        }

        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char prev = s.charAt(i-1);
            if (s.charAt(i) == prev) {
                count++;
                if (i == s.length() - 1){
                    result.append(prev);
                    result.append(count);
                }
            } else {
                result.append(prev);
                result.append(count);
                count = 1;
                if (i == s.length() - 1){
                    result.append(s.charAt(i));
                    result.append(count);
                }
            }
        }
        return result;
    }

    /* Time Complexity: O(n) */
    private static boolean isUnique(String s) {
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
}