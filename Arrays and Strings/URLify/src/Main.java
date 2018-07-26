import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scan = new Scanner(file);

<<<<<<< HEAD
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
=======
        while (scan.hasNext()) {
            String s = scan.next();
            if (!scan.hasNext()) {
                System.out.println(s);
                break;
            }
            System.out.print(s + "%20");
        }
        scan.close();
    }

>>>>>>> 11bb1b0dac0d081cd432908066bc30696202d683
}