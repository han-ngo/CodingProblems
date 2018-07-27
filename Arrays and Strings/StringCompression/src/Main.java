import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * String Compression: Implement a method to perform basic string compression
 * using the counts of repeated characters. For example, the string aabcccccaaa
 * would become a2blc5a3. If the "compressed" string would not become smaller
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
            String[] words = s.split("\\s+");
            System.out.println(isOneAway_cases(words[0], words[1]));
        }
    }

    /* Time Complexity:  O() */
    private static boolean isOneAway_cases(String original, String edit) {

    }
}