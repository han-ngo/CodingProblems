import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
 * One Away: There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character. Given two
 * strings, write a function to check if they are one edit (or zero edits) away.
 *      EXAMPLE
 *      pale, ple -> true
 *      pales, pale -> true
 *      pale, bale -> true
 *      pale, bake -> false
 */
public class Main {
    /* Questions:
     *
     */
    public static final int MAX_LENGTH = 256;
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scan = new Scanner(file);

        ArrayList<String> strings = new ArrayList<>();
        while (scan.hasNextLine()) {
            strings.add(scan.nextLine());
        }
        scan.close();

        for (String s : strings) {
            String[] words = s.split("\\s+");
            System.out.println(isOneAway_cases(words[0], words[1]));
        }
    }

    /* Time Complexity:  O(n)
     * Note: clearer, easy to follow */
    private static boolean isOneAway_cases(String original, String edit) {
        if (Math.abs(original.length() - edit.length()) > 1) {
            return false;
        }

        ArrayList<Character> oList = toList(original.toCharArray());
        ArrayList<Character> eList = toList(edit.toCharArray());

        if (edit.length() < original.length()) {
            return oList.containsAll(eList);
        } else if (edit.length() > original.length()) {
            return eList.containsAll(oList);
        } else {
            boolean dif = false;
            for (int i = 0; i < original.length(); i++) {
                if (original.charAt(i) != edit.charAt(i)) {
                    if (dif) {
                        return false;
                    }
                    dif = true;
                }
            }
            return true;
        }
    }

    /* Time Complexity:  O(n)
     * Note: compact, DRY code */
    private static boolean isOneAway(String original, String edit) {
        if (Math.abs(original.length() - edit.length()) > 1) {
            return false;
        }

        String s1 = original.length() > edit.length() ? original : edit; // longer or equal
        String s2 = original.length() > edit.length() ? edit : original; // shorter or equal

        boolean dif = false;
        int i1 = 0;
        int i2 = 0;
        while (i1 < s1.length() && i2 < s2.length()) {
            if (s1.charAt(i1) != s2.charAt(i2)) {
                if (dif) {
                    return false;
                }
                dif = true;
                if (s1.length() == s2.length()) {
                    i2++;
                }
            } else {
                i2++;
            }
            i1++;
        }
        return true;
    }

    private static ArrayList<Character> toList(char[] arr) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : arr) {
            list.add(c);
        }
       return list;
    }
}