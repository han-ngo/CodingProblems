import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    /*
     * Given a sorted array arr and a value k, return the index of k in the array.
     * EX: if arr[i] == k --> return i
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scan = new Scanner(file);

        HashMap<int[], Integer> cases = new HashMap<>();
        while (scan.hasNextLine()) {
            int n = scan.nextInt();
            int val = scan.nextInt();
            int[] arr = new int[n];
            String[] data = scan.nextLine().split("\\s+");
            for (int i = 0; i < data.length; i++) {
                arr[i] = Integer.parseInt(data[i]);
            }
            cases.put(arr, val);
        }
        scan.close();

        for (Map.Entry<int[], Integer> entry : cases.entrySet()) {
            int[] arr = entry.getKey();
            int val = entry.getValue();
            System.out.println("Index = " + getIndex(arr, val));
        }
    }

    private static int getIndex(int[] arr, int val) {
        int start = 0;
        int end = arr.length - 1;
        while (end > start) {

        }
    }
}
