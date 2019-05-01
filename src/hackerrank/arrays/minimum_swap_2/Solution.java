package hackerrank.arrays.minimum_swap_2;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        int start = 0, end = arr.length - 1;
        int swaps = 0;
        while (start < end) {
            while (arr[start] == start + 1 && start < end) start++;
            if (start < end) {
                swap(arr, arr[start] - 1, arr[start]);
                int temp = arr[arr[start] - 1];
                arr[arr[start] - 1] = arr[start];
                arr[start] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    static void swap(int[] arr, int i, int j){

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

