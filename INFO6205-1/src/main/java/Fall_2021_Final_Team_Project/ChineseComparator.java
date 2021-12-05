package Fall_2021_Final_Team_Project;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Collator;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * @author: Joseph Li @ Dancincloud
 * Date: 11/7/21 11:53
 **/

public class ChineseComparator implements Comparator<String> {

    Collator collator = Collator.getInstance(Locale.CHINA);

    public int compare(String s1, String s2){
        return collator.compare(s1, s2);
    }

    public static void main(String[] args) throws IOException {
        // "啊","这", "都", "能", "赢" => "a", "zhe", "dou", "neng", "ying"
        Instant start = Instant.now();
        List<String> lines = Files.readAllLines(Paths.get("/Users/vipinmamidi/Documents/NEU/1st SEM/PSA/FinalProject/split/OneTh.txt"));
        String words[] = lines.stream().toArray(String[]::new);
       // String[] words = new String[]{"啊","这", "都", "能", "赢"};
        System.out.println("Sorting Started using comparator");
        Arrays.sort(words, new ChineseComparator());
        System.out.println("After Sorting, Printing");
        printWordsToFile(words,words.length);
        System.out.println("Printing Completed");
        /*for(String word : words){
            System.out.print(word + ", ");
        }*/

        System.out.println();
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
    }

    public static void printWordsToFile(String str[],int n) throws IOException {
        FileWriter writer = new FileWriter("/Users/vipinmamidi/Documents/NEU/1st SEM/PSA/FinalProject/split/JosOneTh.txt");
        for (int i = 0; i < n; i++) {
            writer.write(str[i] + "\n");
        }
        writer.close();
    }
}
