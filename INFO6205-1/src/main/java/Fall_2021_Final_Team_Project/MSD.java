package Fall_2021_Final_Team_Project;

// Java program for the above approach

import java.io.*;
import java.lang.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.CollationKey;
import java.text.Collator;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import edu.neu.coe.info6205.bqs.Dictionary;
import edu.neu.coe.info6205.sort.elementary.InsertionSortMSD;
import javafx.util.Pair;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;


public class MSD {


    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static void sort(String[] a) throws IOException {

        msd_coll(a, 0, a.length, 0, col);
        // aux = new String[a.length];
        // System.out.println("printing aux : ");
        // print(aux, a.length);
        // msd_rad(a,aux,0,a.length-1,0);

    }

    public static void msd_coll(String[] a, int lo, int hi, int d, Collator c) throws IOException {
        //convert to an array of CollationKeys
        //CollationKey keys[] = new CollationKey[a.length];

        log("Inside msd_coll");


        gA = a;
        cA = new String[n];
        THreadCutOff1 = n/5;
        THreadCutOff2 = 2 * THreadCutOff1;
        THreadCutOff3 = 3 * THreadCutOff1;
        THreadCutOff4 = 4 * THreadCutOff1;
        THreadCutOff5 = 5 * THreadCutOff1;

        log("Before Starting Threads :: " + formatter.format( Instant.now() ));
        log("Before cA Length : " + cA.length);
       // log("Before pair Length : " + pairList.size());
        log("Before multimap Length : " + multimap.size());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        log(" 5 Threads Started :: " + formatter.format( Instant.now() ));

        while(t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive() || t5.isAlive()){
           // log("thread alive loop, waiting ... ");
        }

   ///     log("Threads Done, Printing Console");
  //      printConsole(cA);
            log(" 5 Threads Completed, sending to Sort msd_rad :: " + formatter.format( Instant.now() ));
        log("After cA Length : " + cA.length);
        //log("After pair Length : " + pairList.size());
        log("After multimap Length : " + multimap.size());
            aux = new String[n];

         printBeforeSort(cA);
            msd_rad(cA,aux,0,hi,0);
            log("msd_rad sorting completed , Printing Started :: " + formatter.format( Instant.now() ));
        log("Sort After cA Length : " + cA.length);
        //log("Sort After pair Length : " + pairList.size());
        log("Sort After multimap Length : " + multimap.size());
        printAfterSort(cA);
            printWordsToFile(cA);
        log("Print After cA Length : " + cA.length);
       // log("Print After pair Length : " + pairList.size());
        log("Print After multimap Length : " + multimap.size());
            log("printing to list Completed :: " + formatter.format( Instant.now() ));



    }

    static Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < THreadCutOff1; i++) {
                String or = gA[i];
                String pi = getPinYin(or);
                //log(pi);
                cA[i] = pi;
              //  log("t1 : " + cA[i]);
                // map.put(pi,or);
                // keys[i] = c.getCollationKey(pi);
                multimap.put(pi,or);
                /*p = new Pair<>(pi, or);
                pairList.add(p);*/
            }
        }
    });

    static Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = THreadCutOff1; i < THreadCutOff2; i++) {
                String or = gA[i];
                String pi = getPinYin(or);
                cA[i] = pi;
            //    log("t2 : " + cA[i]);
                // map.put(pi,or);
                // keys[i] = c.getCollationKey(pi);
                multimap.put(pi,or);
                /*p = new Pair<>(pi, or);
                pairList.add(p);*/
            }
        }
    });

    static Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = THreadCutOff2; i < THreadCutOff3; i++) {
                String or = gA[i];
                String pi = getPinYin(or);
                cA[i] = pi;
           //     log("t3 : " + cA[i]);
                // map.put(pi,or);
                // keys[i] = c.getCollationKey(pi);
                multimap.put(pi,or);
                /*p = new Pair<>(pi, or);
                pairList.add(p);*/
            }
        }
    });

    static Thread t4 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = THreadCutOff3; i < THreadCutOff4; i++) {
                String or = gA[i];
                String pi = getPinYin(or);
                cA[i] = pi;
          //      log("t4 : " + cA[i]);
                // map.put(pi,or);
                // keys[i] = c.getCollationKey(pi);
                multimap.put(pi,or);
                /*p = new Pair<>(pi, or);
                pairList.add(p);*/
            }
        }
    });

    static Thread t5 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = THreadCutOff4; i < n; i++) {
                String or = gA[i];
                String pi = getPinYin(or);
                cA[i] = pi;
           //     log("t5 : " + cA[i]);
                // map.put(pi,or);
                // keys[i] = c.getCollationKey(pi);
                multimap.put(pi,or);
                /*p = new Pair<>(pi, or);
                pairList.add(p);*/
            }
        }
    });



    public static String getPinYin(String sa) {
        StringBuffer output = new StringBuffer("");
        try {
            HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
            format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
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

    /*private static void msd_rad_col(CollationKey[] a, CollationKey[] aux, int lo, int hi, int d) {
        // System.out.println("in  msd_rad: lo " + lo + "hi " + hi + "d " + d);
        if (hi <= lo) return;
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }
        for (int r = 0; r < R; r++) {
            msd_rad_col(a, aux, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }

    }*/

 /*   private static void msd_rad(String[] a, String[] aux, int lo, int hi, int d){
       // System.out.println("in  msd_rad: lo " + lo + "hi " + hi + "d " + d);
        if (hi <= lo) return;
        int[] count = new int[R+2];
        for(int i=lo;i<=hi;i++){
            count[charAt(a[i],d) + 2]++;
        }
        for(int r = 0; r<R+1;r++){
            count[r+1] += count[r];
        }
        for(int i=lo;i<=hi;i++){
            aux[count[charAt(a[i],d)+1]++] = a[i];
        }
        for(int i=lo;i<=hi;i++){
            a[i] = aux[i-lo];
        }
        for(int r=0;r<R;r++){
            msd_rad(a, aux,lo + count[r], lo + count[r+1] - 1, d+1);
        }

    }*/

    private static void msd_rad(String[] a,String[] aux, int lo, int hi, int d) {
        if (hi < lo + cutoff) InsertionSortMSD.sort(a, lo, hi, d);
        else {
            int[] count = new int[R + 2];        // Compute frequency counts.
            for (int i = lo; i < hi; i++)
                count[charAt(a[i], d) + 2]++;
            for (int r = 0; r < R + 1; r++)      // Transform counts to indices.
                count[r + 1] += count[r];
            for (int i = lo; i < hi; i++)     // Distribute.
                aux[count[charAt(a[i], d) + 1]++] = a[i];
            // Copy back.
            if (hi - lo >= 0) System.arraycopy(aux, 0, a, lo, hi - lo);
            // Recursively sort for each character value.
            // TO BE IMPLEMENTED
            for (int r = 0; r < R; r++)
                msd_rad(a, aux, lo + count[r], lo + count[r + 1] , d + 1);
        }
    }



    public static void main(String[] args) throws IOException {

        formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.US)
                .withZone(ZoneOffset.UTC);
        Instant start = Instant.now();
        log("Program Started :: " + formatter.format( start ) );
        List<String> lines = Files.readAllLines(Paths.get("/Users/vipinmamidi/Documents/NEU/1st SEM/PSA/FinalProject/split/OneTh.txt"), Charset.forName("UTF-8"));
        log("Files Read");
        String[] str = lines.stream().toArray(String[]::new);
        log("Converted to String Array");
        n = str.length;
        log("Sending to Sort");
        sort(str);

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");
    }



   /* public static void printWordsToFile(String str[], int n) throws IOException {
        FileWriter writer = new FileWriter("/Users/vipinmamidi/Documents/NEU/1st SEM/PSA/FinalProject/mybeforesortout.txt");
        for (int i = 0; i < n; i++) {
            if(map.containsKey(str[i])){
                writer.write(map.get(str[i]) + "\n");
            }
        }
        writer.close();
    }*/



    /*public static void printWordsToFile(String[] str) throws IOException {
        FileWriter writer = new FileWriter("/Users/vipinmamidi/Documents/NEU/1st SEM/PSA/FinalProject/mchout.txt");
        for(String s :str){
            for(Pair<String,String> p: pairList){
                if(p.getKey().equals(s)){
                    writer.write(p.getKey() + "::" +p.getValue() + "\n");
                    removePair(p);
                    break;
                }
                //System.out.println(p.getKey()+" "+);
            }
        }

        writer.close();
    }*/



    public static void printWordsToFile(String[] str) throws IOException {
        FileWriter writer = new FileWriter("/Users/vipinmamidi/Documents/NEU/1st SEM/PSA/FinalProject/split/VipOneTh.txt");
        for(String s :str){
            Collection<String> value =  multimap.get(s);

             if(!value.isEmpty()){
                 for(String ss : value){
                     writer.write( ss + "\n");
                 }
                 multimap.asMap().remove(s);
             }
        }

        writer.close();
    }

    static void printBeforeSort(String str[]) throws IOException {
        FileWriter writer = new FileWriter("/Users/vipinmamidi/Documents/NEU/1st SEM/PSA/FinalProject/split/DebugOneTh.txt");

        for (int i = 0; i < str.length; i++) {
          //  System.out.print(str[i] + " ");
            writer.write(str[i]  + "\n");
        }
        System.out.println();
        writer.close();
    }

    static void printAfterSort(String str[]) throws IOException {
        FileWriter writer = new FileWriter("/Users/vipinmamidi/Documents/NEU/1st SEM/PSA/FinalProject/split/AfterOneTh.txt");

        for (int i = 0; i < str.length; i++) {
            //  System.out.print(str[i] + " ");
            writer.write(str[i]  + "\n");
        }
        System.out.println();
        writer.close();
    }

    static void printConsole(String str[]) throws IOException {

        for (int i = 0; i < str.length; i++) {
              System.out.print(str[i] + " ");
        }
        System.out.println();

    }

    public static void log(String str){
        System.out.println(str);
    }

    public static void removePair(Pair p){
        pairList.remove(p);
    }




    private static String[] aux;
    private static final int R = 256;
    private static final int cutoff = 2;
    private static int n;
    static Collator col = Collator.getInstance(Locale.CHINA);
    public static HashMap<String, String> map = new HashMap<>();

    private static ArrayList<Pair<String,String>> pairList=new ArrayList<>();
    private static Pair<String,String> p;
    public static String[] gA; //Global Array
    public static String[] cA; //Chinese Array

    public static int THreadCutOff1 ;
    public static int THreadCutOff2 ;
    public static int THreadCutOff3 ;
    public static int THreadCutOff4 ;
    public static int THreadCutOff5 ;

    public static DateTimeFormatter formatter;

    public static Multimap<String,String> multimap = ArrayListMultimap.create();
    public static List<String> keyList;


}
