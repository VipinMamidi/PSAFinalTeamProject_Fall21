package FinalTeamProject_Fall2021_Sec06.MSDRadixSort;

// Java program for the above approach

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import edu.neu.coe.info6205.sort.elementary.InsertionSortMSD;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;


public class MSDRadixSort_toSortChineseWords {


    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static String[] sort(String[] a) throws IOException {

        /*a = "阿兵 阿滨 阿冰 阿安 阿斌 阿彬".split(" ");*/
        msd_coll(a, 0, a.length, 0);
        return finalArray;
    }

    public static void msd_coll(String[] a, int lo, int hi, int d) throws IOException {

       // log("Inside msd_coll");
        n = a.length;

        gA = a;
        cA = new String[n];
        finalArray = new String[n];

       // log("Before Assigning cA Length : " + cA.length);
      //  log("Before Assigning multimap Length : " + multimap.size());
        assignToMultimap();

      //  log("After Assigning cA Length : " + cA.length);
      //  log("After Assigning multimap Length : " + multimap.size());
        aux = new String[n];
      //  log("Printing cA Before Sort and Sending to Sort");

        msd_rad(cA,aux,0,hi,0);

      //  log("Sort After cA Length : " + cA.length);
      //  log("Sort After multimap Length : " + multimap.size());

        a = cA;

        printWordsToFile(cA);

      //  log(" cA Length After Printing: " + cA.length);
      //  log("multimap Length After Printing: " + multimap.size());


        finalArray = new String[finalList.size()];
        finalArray = finalList.toArray(finalArray);

    }

    public static void assignToMultimap(){
        for (int i = 0; i < n; i++) {
            String or = gA[i];
            String pi = getPinYin(or);
            //log(pi);
            cA[i] = pi;
            multimap.put(pi,or);
        }

    }

    public static String getPinYin(String sa) {
        StringBuffer output = new StringBuffer("");
        try {
            HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
            format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            format.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER);
            format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

            char[] input = sa.trim().toCharArray();
            for (int j = 0; j < input.length; j++) {
                if (Character.toString(input[j]).matches("[\\u4E00-\\u9FA5]+")) {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[j], format);

                    //print(temp, temp.length);
                    for(String s : temp){
                        output.append(s);
                        output.append("");
                    }
                } else
                    System.out.println("Not Chinese Characters!");

            }

            return output.toString();
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return output.toString();
    }


    public static void msd_rad(String[] a,String[] aux, int lo, int hi, int d) {
        if (hi < lo + cutoff) InsertionSortMSD.sort(a, lo, hi, d);
        else {
            int[] count = new int[R + 2];        // Compute frequency counts.
            for (int i = lo; i < hi; i++)
                count[charAt(a[i], d) + 2]++;
            for (int r = 0; r < R + 1; r++)      // Transform counts to indices.
                count[r + 1] += count[r];
            for (int i = lo; i < hi; i++)     // Distribute.
                aux[count[charAt(a[i], d) + 1]++] = a[i];
            if (hi - lo >= 0) System.arraycopy(aux, 0, a, lo, hi - lo);
            for (int r = 0; r < R; r++)
                msd_rad(a, aux, lo + count[r], lo + count[r + 1] , d + 1);
        }
    }

    public static void main(String[] args) throws IOException {


        Instant start = Instant.now();

        String Path = "src/main/java/FinalTeamProject_Fall2021_Sec06/Resources/1000ShuffedChineseWords.txt";



        MSDRadixSort_toSortChineseWords msd = new MSDRadixSort_toSortChineseWords();
        array = msd.getStringArray(Path);

      //  log("Files Read");

      //  log("Converted to String Array");
        n = array.length;
     //   log("Sending to Sort");
        sort(array);

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");
    }

    public String[] getStringArray(String path) throws IOException {

        String lines = "";

        try {
            BufferedReader objBr = new BufferedReader(new FileReader(path));

            while ((lines = objBr.readLine()) != null) {
                String values = lines.toString();
                initialList.add(values);
            }
            String[] ar = new String[initialList.size()];
            ar = initialList.toArray(ar);

            array = ar;
        }
        catch(FileNotFoundException ex){
        }
        catch(IOException ex){
        }

        return  array;

    }


    public static void printWordsToFile(String[] str) throws IOException {

        // FileWriter writer = new FileWriter("src/main/java/FinalTeamProject_Fall2021_Sec06/Result/1000sortedhuffedChineseWords_UsingMSD.txt");
        //FileWriter writer_withPi = new FileWriter("src/main/java/FinalTeamProject_Fall2021_Sec06/Result/sortedShuffledChinese_withTone.txt");
        finalList = new ArrayList<String>();
        for(String s :str){
            Collection<String> value =  multimap.get(s);

            if(!value.isEmpty()){
                for(String ss : value){
                    //     writer.write( ss + "\n");
                    //     writer_withPi.write( s + " :: " + ss + "\n");
                    finalList.add(ss);
                }
                multimap.asMap().remove(s);
            }
        }

        // writer.close();
    }

    public static void log(String str){
        System.out.println(str);
    }

    private static String[] aux;
    private static final int R = 256;
    private static final int cutoff = 2;
    private static int n;


    public static String[] array;
    public static String[] gA; //Global Array
    public static String[] cA; //Chinese Array

    public static DateTimeFormatter formatter;

    public static Multimap<String,String> multimap = ArrayListMultimap.create();
    public static List<String> keyList;

    public static ArrayList<String> finalList = new ArrayList<String>();
    public static ArrayList<String> initialList = new ArrayList<String>();
    public static String[] finalArray;



}
