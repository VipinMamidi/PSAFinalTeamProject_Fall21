package FinalTeamProject_Fall2021_Sec06.LSDRadixSort;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class LSDsort_Chinese_PinyinTest {

    @Test
    public void testSort1() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Resources/shuffledChinese100.txt"), Charset.forName("UTF-8"));
        String[] input = lines.stream().toArray(String[]::new);
        List<String> Explines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Result/LSDsortedChinese100.txt"), Charset.forName("UTF-8"));
        String[] expected = Explines.stream().toArray(String[]::new);
        String[] Output=LSDsort_Chinese_Pinyin.sort(input,0, input.length-1);
        assertArrayEquals(expected,Output);
    }

    @Test
    public void testSort2() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Resources/shuffledChinese500.txt"), Charset.forName("UTF-8"));
        String[] input = lines.stream().toArray(String[]::new);
        List<String> Explines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Result/LSDsortedChinese500.txt"), Charset.forName("UTF-8"));
        String[] expected = Explines.stream().toArray(String[]::new);
        String[] Output=LSDsort_Chinese_Pinyin.sort(input,0, input.length-1);
        assertArrayEquals(expected,Output);
    }
    /*@Test
    public void testSort3() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Resources/shuffledChinese1000.txt"), Charset.forName("UTF-8"));
        String[] input = lines.stream().toArray(String[]::new);
        List<String> Explines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Result/LSDsortedChinese1000.txt"), Charset.forName("UTF-8"));
        String[] expected = Explines.stream().toArray(String[]::new);
        String[] Output=LSDsort_Chinese_Pinyin.sort(input,0, input.length-1);
        assertArrayEquals(expected,Output);
    }*/
}