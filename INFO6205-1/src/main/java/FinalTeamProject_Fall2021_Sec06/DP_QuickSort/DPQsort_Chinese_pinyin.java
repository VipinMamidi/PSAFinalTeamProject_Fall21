package FinalTeamProject_Fall2021_Sec06.DP_QuickSort;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.logging.log4j.ThreadContext;

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

public class DPQsort_Chinese_pinyin {
    private static int n;
    public static HashMap<String, String> map = new HashMap<>();
    public static DateTimeFormatter formatter;
    public static Multimap<String,String> multimap = ArrayListMultimap.create();
    public static List<String> keyList;
    public static String pi;
    public static String[] pinArr;
    public static List<String> initialList= new ArrayList<>();
    public static String[] array;
    public static String[] op;
    public static String[] outputArray;
     public static String[] sort(String[] a) throws IOException {


        n=a.length;
        pinArr=new String[n];
        for(int i=0;i<n;i++){
            pi=getPinYin(a[i]);
            pinArr[i]=pi;
            multimap.put(pi,a[i]);
        }
        DPQsortwithPinyin(pinArr,0,n-1);
        printWordsToFile(pinArr);
        return outputArray;
    }
    public static void DPQsortwithPinyin(String[] a, int low, int high) throws IOException {
        if(high<=low) return;
        if (less(a[high],a[low]))
            swap(a, low, high);
        int lt = low + 1;
        int gt = high - 1;
        int i = low + 1;
        while (i <= gt) {
            if (less(a[i],a[low]))
                swap(a, lt++, i++);
            else if (less(a[high],a[i]))
                swap(a, i, gt--);
            else
                i++;
        }
        swap(a, low, --lt);
        swap(a, high, ++gt);

        DPQsortwithPinyin(a, low, lt - 1);
        if (less(a[lt], a[gt]))   DPQsortwithPinyin(a, lt + 1, gt - 1);
        DPQsortwithPinyin(a, gt + 1, high);
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void swap(Object[] a, int i, int j){
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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
                    output.append(temp[0]);
                    output.append("");
                } else
                    System.out.println("else");
                //output.append(Character.toString(input[i]));
            }
            return output.toString();
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return output.toString();
    }


    public static void printWordsToFile(String[] str) throws IOException {
        outputArray=new String[str.length];
        op=new String[str.length];
        int i=0;
       FileWriter writer = new FileWriter("src/main/java/FinalTeamProject_Fall2021_Sec06/Result/TestDPQSortedChinese1000.txt");
        for(String s :str){
            Collection<String> value =  multimap.get(s);
            if(!value.isEmpty()){
                for(String ss : value){
                    writer.write( ss + "\n");
                //    System.out.println(s +" : "+ss+"\n");
                    op[i]=ss;
                    outputArray[i]=op[i];
                    i++;
                }
                multimap.asMap().remove(s);
            }
        }
        writer.close();
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
    public static void main(String[] args) throws IOException {
        formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.US)
                .withZone(ZoneOffset.UTC);
        Instant start = Instant.now();
        System.out.println("Program Started :: " + formatter.format( start ) );
       // List<String> lines = Files.readAllLines(Paths.get("/Users/sowmyachinimilli/MSIS/PSA/shuffledChinese4M.txt"), Charset.forName("UTF-8"));
        System.out.println("Files Read");
       // String[] str = lines.stream().toArray(String[]::new);
      //  System.out.println("Converted to String Array");
      //  n = str.length;
        String Path = "src/main/java/FinalTeamProject_Fall2021_Sec06/Resources/shuffledChinese1000.txt";
        DPQsort_Chinese_pinyin dqpSortChinese =  new DPQsort_Chinese_pinyin();
        String[] str=dqpSortChinese.getStringArray(Path);
        System.out.println("Sending to Sort");
        sort(str);
        //printWordsToFile(pinArr);
        System.out.println(pinArr.length);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");
    }


}
