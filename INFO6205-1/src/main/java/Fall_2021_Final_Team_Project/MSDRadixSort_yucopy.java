package Fall_2021_Final_Team_Project;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MSDRadixSort_yucopy {
    static void print(String str[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.println();
    }

    static void printList(List<String> items) {
        for (String e : items) {
            System.out.print(e);
            System.out.print(" ");
        }
        System.out.println();
    }


    // Driver Code
    public static void main(String[] args) {

        Instant start = Instant.now();
        String str[] = {"add", "cab", "fad", "fee", "bad", "bee", "fed", "bed", "ace"};

        // Size of the string
        n = str.length;
        List<String> wordList = Arrays.asList(str);

        System.out.println("MSDList");
        System.out.print("Unsorted array : ");

        // Print the unsorted array
        //print(str, n);
        printList(wordList);
        // Function Call
        //msd(str, 0, n - 1, 0);
        msd(wordList);

        System.out.print("Sorted array : ");

        // Print the sorted array
        // print(str, n);
        printList(wordList);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

    }

    public static List<String> msd(List<String> items) {
        return msd(items, 0);
    }

    private static List<String> msd(List<String> items, int index) {
        if (index >= items.get(0).length() || items.size() <= 1) {
            return items;
        }

        List<String> answer = new ArrayList<>();
        int start = 0;
        stableSort(items, index);
        for (int end = 1; end <= items.size(); end += 1) {
            if (end == items.size() || items.get(start).charAt(index) != items.get(end).charAt(index)) {
                List<String> subList = items.subList(start, end);
                answer.addAll(msd(subList, index + 1));
                start = end;
            }
            //printList(items);
        }
        return answer;
    }

    private static void stableSort(List<String> items, int index) {
        items.sort(Comparator.comparingInt(o -> o.charAt(index)));
    }

    private static String[] aux;
    private static final int R = 256;
    private static int n;
}
