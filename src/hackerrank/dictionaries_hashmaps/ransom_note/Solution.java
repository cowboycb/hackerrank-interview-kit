package hackerrank.dictionaries_hashmaps.ransom_note;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        Stream<String> stream = Stream.of(magazine);

        Map<String, Integer> mapMagazine = stream.collect(Collectors.toMap(s -> s, s -> 1, (oldValue, newValue) -> oldValue + 1 ));

        System.out.println(mapMagazine);
        boolean isAllMatch = Stream.of(note).allMatch(s -> {
            Integer count = mapMagazine.get(s);
            if (count == null){
                return false;
            }else if (count == 1){
                mapMagazine.remove(s);
            }else{
                mapMagazine.put(s, count-1);
            }
            return true;
        });

        if (isAllMatch){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}

