package hackerrank.warmup_challenges.counting_valleys;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        Map<Character, Character> stepToggle = new HashMap<>();
        stepToggle.put('U', 'D');
        stepToggle.put('D', 'U');

        Map<Character, Integer> map = new HashMap<>();
        map.put('U', 0);
        map.put('D', 0);


        Stack<Character> step = new Stack<>();

        IntStream stream = s.chars();
        stream.mapToObj(c -> (char)c).forEachOrdered(c -> {
            char op = stepToggle.get(c);
            if (!step.empty() && step.peek() == op){
                step.pop();
                if (step.empty()){
                    map.put(op, map.get(op) + 1);
                }
            }else{
                step.push(c);
            }
        });

        return map.get('D');

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }

}

