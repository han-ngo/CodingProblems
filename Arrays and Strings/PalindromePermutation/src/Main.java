import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Palindrome Permutation: Given a string, write a function to check if it
 * is a permutation of a palin­ drome. A palindrome is a word or phrase that
 * is the same forwards and backwards. A permutation is a rearrangement of
 * letters. The palindrome does not need to be limited to just dictionary words.
 *      EXAMPLE
 *      Input: Tact Coa
 *      Output: True (permutations: "taco cat", "atco eta", etc.)
 */
public class Main {
    /* Questions:
     *      Case sensitive?
     *      Whitespace is significant?
     *      ASCII or Unicode?
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
            System.out.println(isPalindromePermutation_bit(s));
        }
    }

    /* Time Complexity:  O(n) */
    private static boolean isPalindromePermutation(String s) {
        int[] count = new int[MAX_LENGTH];
        s = s.toLowerCase().replaceAll("\\s+", "");

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        int odd = 0;
        for (int c : count) {
            if (c % 2 != 0) {
                odd++;
                if (odd > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    /* Time Complexity:  O(n) */
    private static boolean isPalindromePermutation_bit(String s) {
        int bitVector = 0;
        s = s.toLowerCase().replaceAll("\\s+", "");

        for (int i = 0; i < s.length(); i++) {
            bitVector = toggle(bitVector, s.charAt(i));
        }

        return bitVector == 0 || ((bitVector - 1) & bitVector) == 0;
    }

    /* helper method */
    private static int toggle(int bitVector, int index) {
        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }
}