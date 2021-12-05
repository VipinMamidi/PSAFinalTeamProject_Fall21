package FinalTeamProject_Fall2021_Sec06.LSDRadixSort;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class LSDsort_Chinese_Pinyin {
    private static final int ASCII_RANGE = 256;
    private static int n;
    public static HashMap<String, String> map = new HashMap<>();
    public static DateTimeFormatter formatter;
    public static Multimap<String,String> multimap = ArrayListMultimap.create();
    public static List<String> keyList;
    public static String pi;
    public static String[] pinArr;
    private static int findMaxLength(String[] al) {
        int maxLength = al[0].length();
        for (String str : al)
            maxLength = Math.max(maxLength, str.length());
        return maxLength;
    }
    private static int charAsciiVal(String al, int charPosition) {
        if (charPosition >= al.length()) {
            return 0;
        }
        return al.charAt(charPosition);
    }
    public static String[] sort(String[] a,int from, int to) throws IOException {
        //public static void sort(String[] a,int from, int to) throws IOException {
        n=a.length;
        pinArr=new String[n];
        for(int i=0;i<n;i++){
            pi=getPinYin(a[i]);
            pinArr[i]=pi;
            multimap.put(pi,a[i]);
        }
        int maxLength = findMaxLength(pinArr);
        for (int i = maxLength - 1; i >= 0; i--)
            LSDwithPinyin(pinArr, i, from, to);
        return printWordsToFile(pinArr);
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
    public static void LSDwithPinyin(String[] a, int charPosition, int from, int to) throws IOException {
        int[] count = new int[ASCII_RANGE + 2];
        String[] result = new String[a.length];

        for (int i = from; i <= to; i++) {
            int c = charAsciiVal(a[i], charPosition);
            count[c + 2]++;
        }

        // transform counts to indices
        for (int r = 1; r < ASCII_RANGE + 2; r++)
            count[r] += count[r - 1];

        // distribute
        for (int i = from; i <= to; i++) {
            int c = charAsciiVal(a[i], charPosition);
            result[count[c + 1]++] = a[i];
        }

        // copy back
        if (to + 1 - from >= 0) System.arraycopy(result, 0, a, from, to + 1 - from);
    }
   public static String[] printWordsToFile(String[] str) throws IOException {
       // public static void printWordsToFile(String[] str) throws IOException {
        String[] op=new String[str.length];
        int i=0;
      //  FileWriter writer = new FileWriter("/Users/sowmyachinimilli/MSIS/PSA/Output/LSDsmallsortedChineseOutput.txt");
        for(String s :str){
            Collection<String> value =  multimap.get(s);
            if(!value.isEmpty()){
                for(String ss : value){
                    //writer.write( ss + "\n");
                    op[i]=ss;
                    i++;
                    //System.out.println(s +" : "+ss+"\n");
                }
                multimap.asMap().remove(s);
            }
        }
       // writer.close();
        return op;
    }
    public static void main(String[] args) throws IOException {
        formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.US)
                .withZone(ZoneOffset.UTC);
        Instant start = Instant.now();
        System.out.println("Program Started :: " + formatter.format( start ) );
        List<String> lines = Files.readAllLines(Paths.get("/Users/sowmyachinimilli/MSIS/PSA/smallSortedChineseJum.txt"), Charset.forName("UTF-8"));
        System.out.println("Files Read");
        String[] str = lines.stream().toArray(String[]::new);
        System.out.println("Converted to String Array");
        n = str.length;
        System.out.println("Sending to Sort");
        sort(str,0,n-1);
        printWordsToFile(pinArr);
        System.out.println(pinArr.length);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");
    }
}
