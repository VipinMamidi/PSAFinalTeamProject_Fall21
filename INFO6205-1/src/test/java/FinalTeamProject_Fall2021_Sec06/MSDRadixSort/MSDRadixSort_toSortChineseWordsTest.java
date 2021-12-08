package FinalTeamProject_Fall2021_Sec06.MSDRadixSort;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MSDRadixSort_toSortChineseWordsTest {

    /*String[] input = "麻爱华, 赛蕾娜, 戴喜东, 饶金生, 阿冰冰, 许岳林".split(" ");
    String[] expected = "阿冰冰, 戴喜东, 麻爱华,饶金生, 赛蕾娜, 许岳林".split(" ");*/
    String[] input ;

    String[] expected ;


    @Test
    public void sorttest1() throws IOException {

        input = "阿兵 阿滨 阿冰 阿安 阿斌 阿彬".split(" ");
        expected = "阿安 阿滨 阿斌 阿彬 阿兵 阿冰".split(" ");
        String[] a = MSDRadixSort_toSortChineseWords.sort(input);
        assertArrayEquals(expected, a);
    }

    @Test
    public void testSort1() throws IOException {
        System.out.println("100 words file");
        String inPath = "src/main/java/FinalTeamProject_Fall2021_Sec06/Resources/100ShuffedChineseWords.txt";
        String outPath = "src/main/java/FinalTeamProject_Fall2021_Sec06/Result/100sortedhuffedChineseWords_UsingMSD.txt";
        String[] input= getStringArray(inPath);
        String[] expected= getStringArray(outPath);
        String[] Output=MSDRadixSort_toSortChineseWords.sort(input);
        assertArrayEquals(expected,Output);
    }

    @Test
    public void testSort2() throws IOException {
        System.out.println("500 words file");
        String inPath = "src/main/java/FinalTeamProject_Fall2021_Sec06/Resources/500ShuffedChineseWords.txt";
        String outPath = "src/main/java/FinalTeamProject_Fall2021_Sec06/Result/500sortedhuffedChineseWords_UsingMSD.txt";
        String[] input= getStringArray(inPath);
        String[] expected= getStringArray(outPath);
        String[] Output=MSDRadixSort_toSortChineseWords.sort(input);
        assertArrayEquals(expected,Output);
    }

    @Test
    public void testSort3() throws IOException {
        System.out.println("1000 words file");
        String inPath = "src/main/java/FinalTeamProject_Fall2021_Sec06/Resources/1000ShuffedChineseWords.txt";
        String outPath = "src/main/java/FinalTeamProject_Fall2021_Sec06/Result/1000sortedhuffedChineseWords_UsingMSD.txt";
        String[] input= getStringArray(inPath);
        String[] expected= getStringArray(outPath);
        String[] Output=MSDRadixSort_toSortChineseWords.sort(input);
        assertArrayEquals(expected,Output);
    }

    public String[] getStringArray(String path) throws IOException {

        String lines = "";
        ArrayList<String> initialList = new ArrayList<String>();

        try {
            BufferedReader objBr = new BufferedReader(new FileReader(path));

            while ((lines = objBr.readLine()) != null) {
                String values = lines.toString();
                initialList.add(values);
            }
            String[] ar = new String[initialList.size()];
            ar = initialList.toArray(ar);

            return ar;
        }
        catch(FileNotFoundException ex){
        }
        catch(IOException ex){
        }

        return null;
    }



}