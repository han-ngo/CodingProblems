import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scan = new Scanner(file);

        String s = "";
        while (scan.hasNextLine()) {
            s = scan.nextLine();
        }
        scan.close();

        char[] chars = s.toCharArray();
        System.out.println(URLify(chars));
    }

    /* Time Complexity: O(n) */
    private static String URLify(char[] s) {
        String result = "";
        boolean isOneWord = false;
        int start = 0, end = 0;
        for (int i = s.length-1; i >= 0; i--) {
            if (i != 0 && s[i-1] != ' ' && s[i] == ' ') {
                end = i-1;
            } else if (s[i] != ' ' && (i == 0 || s[i-1] == ' ')) {
                start = i;
                isOneWord = true;
            }

            if (start != end && isOneWord) {
                String word = new String(s, start, end-start+1);
                if (start == 0) {
                    result = word + result;
                } else {
                    result = "%20" + word + result;
                }
                isOneWord = false;
            }
        }
        return result;
    }
}