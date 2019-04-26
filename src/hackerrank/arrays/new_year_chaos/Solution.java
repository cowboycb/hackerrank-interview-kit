package hackerrank.arrays.new_year_chaos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        Map<Integer, Integer> mapBribeCount = new HashMap<>();

        boolean isFinished = false;
        int idx = 0;
        while (!isFinished) {
            int pointer = q[idx];
            if (pointer > q[idx + 1]) {
                swap(q, idx, idx + 1);
                mapBribeCount.put(pointer, (mapBribeCount.containsKey(pointer) ? mapBribeCount.get(pointer) + 1 : 1));
                if (mapBribeCount.get(pointer) == 3) {
                    System.out.println("Too chaotic");
                    break;
                }
            }
//            System.out.println("i = " + idx + ", LastStutation" + Arrays.toString(q));
//            System.out.println(mapBribeCount.toString());
            idx++;
            if (idx == q.length - 1) {
                isFinished = isSorted(q);
//                System.out.println("isSorted: " + isFinished);
                idx = 0;
            }
        }

        if (isFinished) {
            AtomicInteger total = new AtomicInteger(0);
            mapBribeCount.forEach((briber, count) -> {
                total.getAndAdd(count);
            });
            System.out.println(total.get());
        }
    }

    private static boolean isSorted(int[] q) {
        for (int i = 0; i < q.length - 1; i++) {
            if (q[i] > q[i + 1]) return false;
        }
        return true;
    }

    private static void swap(int[] q, int i, int j) {
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

