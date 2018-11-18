import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * Number of ways to climb the stairs given N = numbers of stairs and
 * x = an array of possible number of steps
 *
 * Ex: N = 4 and x = {1, 3, 5}
 *
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scan = new Scanner(file);

        int N = scan.nextInt();
        ArrayList<Integer> x = new ArrayList<>();
        while (scan.hasNextInt()) {
            x.add(scan.nextInt());
        }
        scan.close();

        System.out.println(numWaysDP(N, x) + " possible way(s) to climb the stairs");
    }

    /* Time Complexity: O(N*|x|) */
    private static int numWaysDP(int N, ArrayList<Integer> x) {
        /* Base Cases */
        if (N == 0) {
            return 1;
        }

        int count;
        int[] counts = new int[N + 1];
        counts[0] = 1;
        for (int i = 1; i <= N; i++) {
            count = 0;
            for (int num : x) {
                if (i - num >= 0) {
                    count += counts[i - num];
                }
            }
            counts[i] = count;
        }

        return counts[N];
    }

    /* Time Complexity: O(|x|^N) --> very slow due to repeating computations */
    private static int numWays(int N, ArrayList<Integer> x) {
        /* Base Cases */
        if (N == 0) {
           return 1;
        }
        int count = 0;

        for (int num : x) {
            if (N - num >= 0) {
                count += numWays(N-num, x);
            }
        }

        return count;
    }
}