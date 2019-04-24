package hackerrank.arrays.multidimensional;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        // TODO implement using Java 8 streams
        int max = -63;
        for(int row=0; row < 4; row++){
            for(int col=0; col < 4; col++){
                int toplam = arr[row][col] + arr[row][col+1] + arr[row][col+2];
                toplam += arr[row+1][col+1];
                toplam += arr[row+2][col] + arr[row+2][col+1] + arr[row+2][col+2];
                if (toplam > max){
                    max = toplam;
                }
            }
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        System.out.println("Result: " + result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
