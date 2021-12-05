package FinalTeamProject_Fall2021_Sec06;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MSDRadixSort_toSortChineseWordsTest {

    /*String[] input = "麻爱华, 赛蕾娜, 戴喜东, 饶金生, 阿冰冰, 许岳林".split(" ");
    String[] expected = "阿冰冰, 戴喜东, 麻爱华,饶金生, 赛蕾娜, 许岳林".split(" ");*/
    String[] input = "阿兵 阿滨 阿冰 阿安 阿斌 阿彬".split(" ");
    String[] expected = "阿安 阿滨 阿斌 阿彬 阿兵 阿冰".split(" ");


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void sort() throws IOException {
        System.out.println(Arrays.toString(input));
        String[] a = MSDRadixSort_toSortChineseWords.sort(input);
        assertArrayEquals(expected, a);
    }









    @Test
    public void msd_coll() {
    }

    @Test
    public void assignToMultimap() {
    }

    @Test
    public void getPinYin() {
    }

    @Test
    public void printWordsToFile() {
    }

    @Test
    public void removePair() {
    }
}