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
        System.out.println("small chinese File");
        List<String> lines = Files.readAllLines(Paths.get("/Users/sowmyachinimilli/MSIS/PSA/smallsortedChineseJum.txt"), Charset.forName("UTF-8"));
        String[] input = lines.stream().toArray(String[]::new);
        List<String> Explines = Files.readAllLines(Paths.get("/Users/sowmyachinimilli/MSIS/PSA/Output/DPQsmallsortedChineseOutput.txt"), Charset.forName("UTF-8"));
        String[] expected = Explines.stream().toArray(String[]::new);
        String[] Output=DPQsort_Chinese_pinyin.sort(input);
        assertArrayEquals(expected,Output);
    }
    @Test
    public void testSort2() throws IOException {
        System.out.println("250k chinese File");
        List<String> lines = Files.readAllLines(Paths.get("/Users/sowmyachinimilli/MSIS/PSA/shuffledChinese250k.txt"), Charset.forName("UTF-8"));
        String[] input = lines.stream().toArray(String[]::new);
        List<String> Explines = Files.readAllLines(Paths.get("/Users/sowmyachinimilli/MSIS/PSA/Output/DPQsortChinesepin_Output250k.txt"), Charset.forName("UTF-8"));
        String[] expected = Explines.stream().toArray(String[]::new);
        String[] Output=DPQsort_Chinese_pinyin.sort(input);
        assertArrayEquals(expected,Output);
    }
    @Test
    public void testSort3() throws IOException {
        System.out.println("500k chinese File");
        List<String> lines = Files.readAllLines(Paths.get("/Users/sowmyachinimilli/MSIS/PSA/shuffledChinese500k.txt"), Charset.forName("UTF-8"));
        String[] input = lines.stream().toArray(String[]::new);
        List<String> Explines = Files.readAllLines(Paths.get("/Users/sowmyachinimilli/MSIS/PSA/Output/DPQsortChinesepin_Output500k.txt"), Charset.forName("UTF-8"));
        String[] expected = Explines.stream().toArray(String[]::new);
        String[] Output=DPQsort_Chinese_pinyin.sort(input);
        assertArrayEquals(expected,Output);
    }
    @Test
    public void testSort4() throws IOException {
        System.out.println("1M chinese File");
        List<String> lines = Files.readAllLines(Paths.get("/Users/sowmyachinimilli/MSIS/PSA/shuffledChinese.txt"), Charset.forName("UTF-8"));
        String[] input = lines.stream().toArray(String[]::new);
        List<String> Explines = Files.readAllLines(Paths.get("/Users/sowmyachinimilli/MSIS/PSA/Output/DPQsortChinesepin_Output1M.txt"), Charset.forName("UTF-8"));
        String[] expected = Explines.stream().toArray(String[]::new);
        String[] Output=DPQsort_Chinese_pinyin.sort(input);
        assertArrayEquals(expected,Output);
    }
    @Test
    public void testSort5() throws IOException {
        System.out.println("2M chinese File");
        List<String> lines = Files.readAllLines(Paths.get("/Users/sowmyachinimilli/MSIS/PSA/shuffledChinese2M.txt"), Charset.forName("UTF-8"));
        String[] input = lines.stream().toArray(String[]::new);
        List<String> Explines = Files.readAllLines(Paths.get("/Users/sowmyachinimilli/MSIS/PSA/Output/DPQsortChinesepin_Output2M.txt"), Charset.forName("UTF-8"));
        String[] expected = Explines.stream().toArray(String[]::new);
        String[] Output=DPQsort_Chinese_pinyin.sort(input);
        assertArrayEquals(expected,Output);
    }
    @Test
    public void testSort6() throws IOException {
        System.out.println("4M chinese File");
        List<String> lines = Files.readAllLines(Paths.get("/Users/sowmyachinimilli/MSIS/PSA/shuffledChinese4M.txt"), Charset.forName("UTF-8"));
        String[] input = lines.stream().toArray(String[]::new);
        List<String> Explines = Files.readAllLines(Paths.get("/Users/sowmyachinimilli/MSIS/PSA/Output/DPQsortChinesepin_Output4M.txt"), Charset.forName("UTF-8"));
        String[] expected = Explines.stream().toArray(String[]::new);
        String[] Output=DPQsort_Chinese_pinyin.sort(input);
        assertArrayEquals(expected,Output);
    }
}