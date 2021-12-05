package Fall_2021_Final_Team_Project;

import javafx.util.Pair;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.CollationKey;
import java.text.Collator;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class msdsort_usinglong {

    public static void main(String[] args) throws Exception {
        Instant start = Instant.now();
        List<String> lines = Files.readAllLines(Paths.get("/Users/vipinmamidi/Documents/NEU/1st SEM/PSA/FinalProject/shuffledChinese.txt"), Charset.forName("UTF-8"));
        String[] str = lines.stream().toArray(String[]::new);
        n = str.length;
        System.out.println("MS LONG Started");
        sort(str);
        System.out.println("Sorting Completed, Writing to txt File");
        System.out.println("Printing Completed");
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");


    }

    public static void sort(String[] a) throws IOException {

        msd_colll(a, 0, a.length - 1, 0, col);
    }


    public static void msd_colll(String[] a, int lo, int hi, int d, Collator c) throws IOException {
        //convert to an array of CollationKeys
        CollationKey keys[] = new CollationKey[a.length];


        for (int i = 0; i < a.length; i++) {

            String or = a[i];
            long l = utf8ToLong(or);
            Long myObj = new Long(l);
           // keys[i] = c.getCollationKey(myObj);
            p= new Pair<>(myObj,or);
            pairList.add(i,p);


        }


    }

     private static void msd_rad(String[] a, String[] aux, int lo, int hi, int d){
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

    }

    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static long[] byteArray(String input){
        byte[] bytes = input.getBytes();
        LongBuffer tmpBuf = ByteBuffer.wrap(bytes).asLongBuffer();
        long[] lArr = new long[tmpBuf.remaining()];
        for (int i = 0; i < lArr.length; i++)
            lArr[i] = tmpBuf.get();
        /*System.out.println(input);
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(lArr));*/
        return lArr;
    }

    static long utf8ToLong(final String str) {
        // TODO Need to test that the mask value is correct. I think it might not be.
        return longArrayToLong(toUTF8Array(str), MAX_LENGTH_UTF8, BIT_WIDTH_UTF8, MASK_UTF8) >>> 1;
    }

    private static long longArrayToLong(final long[] xs, final int maxLength, final int bitWidth, final int mask) {
        final int length = Math.min(xs.length, maxLength);
        long result = 0;
        if (((~mask)) == 0)
            for (int i = 0; i < length; i++) result = result << bitWidth | xs[i];
        else
            for (int i = 0; i < length; i++) result = result << bitWidth | xs[i] & mask;
        result = result << (bitWidth * (maxLength - length));
        return result;
    }

    private static long[] toUTF8Array(final String str) {
        final int length = str.length();
        final LongBuffer byteBuffer = LongBuffer.allocate(length << 2);
        int count = 0;
        final char[] codes = str.toCharArray();
        for (int i = 0; i < length; i++) {
            final char code = codes[i];
            if (code < 0x80) {
                count++;
                byteBuffer.put(code);
            } else if (code < 0x800) {
                count += 2;
                byteBuffer.put(0xC0 | (code >> 6));
                byteBuffer.put(0x80 | (code & 0x3F));
            } else if (code < 0xD800 || code >= 0xE000) {
                count += 3;
                byteBuffer.put(0xE0 | (code >> 12));
                byteBuffer.put(0x80 | ((code >> 6) & 0x3F));
                byteBuffer.put(0x80 | (code & 0x3F));
            } else {
                i++;
                final int tempCode = 0x10000 + (((code & 0x3FF) << 10) | codes[i] & 0x3FF);
                count += 4;
                byteBuffer.put(0xF0 | (tempCode >> 18));
                byteBuffer.put(0x80 | ((tempCode >> 12) & 0x3F));
                byteBuffer.put(0x80 | ((tempCode >> 6) & 0x3F));
                byteBuffer.put(0x80 | (tempCode & 0x3F));
            }
        }
        final long[] result = new long[count];
        byteBuffer.rewind();
        byteBuffer.get(result);
        return result;
    }

    private static final int BITS_LONG = 64;
    private static final int MASK_BYTE = 0xFF;
    private static final int BIT_WIDTH_UTF8 = 8;
    private static final int MAX_LENGTH_UTF8 = BITS_LONG / BIT_WIDTH_UTF8;
    private static final int MASK_UTF8 = MASK_BYTE;


    private static String[] aux;
    private static final int R = 2097152;
    private static int n;
    static Collator col = Collator.getInstance(Locale.CHINA);
    public static HashMap<String, String> map = new HashMap<>();
    public static ArrayList<Pair<Long,String>> pairList=new ArrayList<>();
    private static Pair<Long,String> p;



}
