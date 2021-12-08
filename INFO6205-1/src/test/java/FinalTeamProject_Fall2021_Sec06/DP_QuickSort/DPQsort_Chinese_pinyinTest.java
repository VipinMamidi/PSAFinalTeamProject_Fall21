package FinalTeamProject_Fall2021_Sec06.DP_QuickSort;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class DPQsort_Chinese_pinyinTest {


    @Test
    public void testSort1() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Resources/shuffledChinese100.txt"), Charset.forName("UTF-8"));
        String[] input = lines.stream().toArray(String[]::new);
        List<String> Explines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Result/DPQSortedChinese100.txt"), Charset.forName("UTF-8"));
        String[] expected = Explines.stream().toArray(String[]::new);
        String[] Output=DPQsort_Chinese_pinyin.sort(input);
        assertArrayEquals(expected,Output);
    }
    @Test
    public void testSort2() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Resources/shuffledChinese500.txt"), Charset.forName("UTF-8"));
        String[] input = lines.stream().toArray(String[]::new);
        List<String> Explines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Result/DPQSortedChinese500.txt"), Charset.forName("UTF-8"));
        String[] expected = Explines.stream().toArray(String[]::new);
        String[] Output=DPQsort_Chinese_pinyin.sort(input);
        assertArrayEquals(expected,Output);
    }
    @Test
    public void testSort3() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Resources/shuffledChinese1000.txt"), Charset.forName("UTF-8"));
        String[] input = lines.stream().toArray(String[]::new);
        List<String> Explines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Result/DPQSortedChinese1000.txt"), Charset.forName("UTF-8"));
        String[] expected = Explines.stream().toArray(String[]::new);
        String[] Output=DPQsort_Chinese_pinyin.sort(input);
        assertArrayEquals(expected,Output);
    }

}