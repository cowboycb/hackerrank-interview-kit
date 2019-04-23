package warmup_challenges.repeated_string;


import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        long countOfOcc= findOccurences(s);

        long NumberOfRepeat = n/s.length();
        int remainChars = (int)(n%s.length());
        long total = NumberOfRepeat*countOfOcc;
        if (remainChars>0){
            total += findOccurences(s.substring(0, remainChars));
        }
        return total;
    }

    private static long findOccurences(String s){
        long[] total = new long[1];
        s.chars().mapToObj(c->(char)c).forEach(c->{
            if (c.equals('a')) total[0]++;
        });
        return total[0];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
