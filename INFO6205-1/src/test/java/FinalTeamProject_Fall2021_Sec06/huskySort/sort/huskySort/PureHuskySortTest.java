package FinalTeamProject_Fall2021_Sec06.huskySort.sort.huskySort;

import FinalTeamProject_Fall2021_Sec06.huskySort.sort.BaseHelper;
import FinalTeamProject_Fall2021_Sec06.huskySort.sort.huskySortUtils.Coding;
import FinalTeamProject_Fall2021_Sec06.huskySort.sort.huskySortUtils.HuskyCoder;
import FinalTeamProject_Fall2021_Sec06.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import FinalTeamProject_Fall2021_Sec06.huskySort.util.PrivateMethodInvoker;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class PureHuskySortTest {

    private final BaseHelper<String> helper = new BaseHelper<>("dummy helper");

    @Test
    public void testSortString1() throws IOException {
        // String[] xs={"啊","这", "都", "能", "赢"};
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Resources/shuffledChinese100.txt"), Charset.forName("UTF-8"));
        String[] xs = lines.stream().toArray(String[]::new);
        PureHuskySort<String> sorter = new PureHuskySort<>(HuskyCoderFactory.unicodeCoder, false, false);
        sorter.sort(xs);
        assertTrue("sorted", helper.sorted(xs));
    }

    @Test
    public void testSortString2() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Resources/shuffledChinese500.txt"), Charset.forName("UTF-8"));
        String[] xs = lines.stream().toArray(String[]::new);
        PureHuskySort<String> sorter = new PureHuskySort<>(HuskyCoderFactory.unicodeCoder, false, false);
        sorter.sort(xs);
        assertTrue("sorted", helper.sorted(xs));
    }

    @Test
    public void testSortString3() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Resources/shuffledChinese1000.txt"), Charset.forName("UTF-8"));
        String[] xs = lines.stream().toArray(String[]::new);
        PureHuskySort<String> sorter = new PureHuskySort<>(HuskyCoderFactory.unicodeCoder, false, false);
        sorter.sort(xs);
        assertTrue("sorted", helper.sorted(xs));
    }


    @Test
    public void testFloorLg() {
        PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(PureHuskySort.class);
        assertEquals(Integer.valueOf(1), privateMethodInvoker.invokePrivate("floor_lg", 3));
        assertEquals(Integer.valueOf(2), privateMethodInvoker.invokePrivate("floor_lg", 5));
    }

    @Test
    public void testWithInsertionSort() {
        PureHuskySort<String> sorter = new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, true);
        PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(sorter);
        HuskyCoder<String> huskyCoder = (HuskyCoder<String>) privateMethodInvoker.invokePrivate("getHuskyCoder");
        final int N = 100;
        helper.init(N);
        final String[] xs = helper.random(String.class, r -> r.nextLong() + "");
        Coding coding = huskyCoder.huskyEncode(xs);
        sorter.insertionSort(xs, coding.longs, 0, N);
        assertEquals(0, helper.inversions(xs));
    }

    @Test
    public void testInsertionSort() {
        PureHuskySort<String> sorter = new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false);
        PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(sorter);
        HuskyCoder<String> huskyCoder = (HuskyCoder<String>) privateMethodInvoker.invokePrivate("getHuskyCoder");
        final int N = 100;
        helper.init(N);
        final String[] xs = helper.random(String.class, r -> r.nextLong() + "");
        Coding coding = huskyCoder.huskyEncode(xs);
        sorter.insertionSort(xs, coding.longs, 0, N);
        assertEquals(0, helper.inversions(xs));
    }
}