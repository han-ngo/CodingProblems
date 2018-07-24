package kattis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scan = new Scanner(file);

        int N = scan.nextInt(); // number of seedlings
        Integer[] daysToGrow = new Integer[N];
        for (int i = 0; i < N; i++) {
            daysToGrow[i] = scan.nextInt();
        }
        scan.close();

        System.out.println(minDaysForParty(daysToGrow));
    }

    private static int minDaysForParty(Integer[] daysToGrow) {
        int curDay = 1;
        // To optimize, plant the one take longest
        Arrays.sort(daysToGrow, Collections.reverseOrder());
        int maxDaysToGrow = daysToGrow[0] + 1;
        for (int plantGrowTime : daysToGrow) {
            curDay++;
            maxDaysToGrow = Math.max(maxDaysToGrow, plantGrowTime + curDay);
        }
        return maxDaysToGrow;
    }
}