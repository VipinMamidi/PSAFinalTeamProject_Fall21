package Fall_2021_Final_Team_Project;

// Java program for the above approach

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.CollationKey;
import java.text.Collator;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Locale;


public class MSD_copy {


    private static int charAt(CollationKey s, int d)
    {  if (d < s.getSourceString().length()) return s.getSourceString().charAt(d); else return -1;  }

    public static void sort(String[] a){

        msd_coll(a,0,a.length-1,0,col);
       // aux = new String[a.length];
       // System.out.println("printing aux : ");
       // print(aux, a.length);
       // msd_rad(a,aux,0,a.length-1,0);

    }

    public static void msd_coll(String[] a, int lo, int hi, int d, Collator c){
        //convert to an array of CollationKeys
        CollationKey keys[  ] = new CollationKey[a.length];
        byte bt[] = new byte[a.length];

        for (int i =0; i <=a.length-1; i++) {
            keys[i] = c.getCollationKey(a[i]);

        }

        /*for (int i = a.length-1; i >= 0; i--) {
            bt = new byte[a[i].length()];
            bt = c.getCollationKey(a[i]).toByteArray();

            //keys[i] = bt;
        }*/

        CollationKey aux[  ] = new CollationKey[a.length];

        msd_rad_col(keys,aux,0,a.length-1,0);

        /*for (int i = a.length-1; i >= 0; i--)
            a[i] = keys[i].getSourceString(  );*/
        for (int i =0; i <=a.length-1; i++)
            a[i] = keys[i].getSourceString(  );
    }

    private static void msd_rad_col(CollationKey[] a, CollationKey[] aux, int lo, int hi, int d){
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
            msd_rad_col(a, aux,lo + count[r], lo + count[r+1] - 1, d+1);
        }

    }

   /* private static void msd_rad(String[] a, String[] aux, int lo, int hi, int d){
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

    static void printList(List<String> items) {
        for (String e : items) {
            System.out.print(e);
            System.out.print(" ");
        }
        System.out.println();
    }

    static void print(String str[], int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.println();
    }

    static void printin(int in[], int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.print(in[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        //Charset charset = Charset.forName("UTF-8");
        Instant start = Instant.now();
        //System.out.println("def : " + Charset.defaultCharset().displayName());
        List<String> lines = Files.readAllLines(Paths.get("/Users/vipinmamidi/Documents/NEU/1st SEM/PSA/FinalProject/Twords.txt"),Charset.forName("UTF-8"));

        //printList(lines);


        String[] str = lines.stream().toArray(String[]::new);

        n = str.length;

        //print(str,n);

        System.out.println("MSD Sorting Started");

        sort(str);

        System.out.println("Sorting Completed, Writing to txt File");

        printWordsToFile(str,n);

        System.out.println("Printing Completed");

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
    }

    public static void printWordsToFile(String str[],int n) throws IOException {
        FileWriter writer = new FileWriter("/Users/vipinmamidi/Documents/NEU/1st SEM/PSA/FinalProject/out.txt");
        for (int i = 0; i < n; i++) {
            writer.write(str[i] + "\n");
        }
        writer.close();
    }


    private static String[] aux;
    private static final int R = 2097152;
    private static int n;
    static Collator col = Collator.getInstance(Locale.CHINA);


}
