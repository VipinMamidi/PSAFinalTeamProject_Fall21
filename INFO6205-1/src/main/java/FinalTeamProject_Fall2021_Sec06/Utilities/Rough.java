package FinalTeamProject_Fall2021_Sec06.Utilities;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;

public class Rough {

    public static void main(String[] args) throws Exception {






       /* ArrayList<String> scripts = new ArrayList<String>();
        scripts.add("test3");
        scripts.add("test4");
        scripts.add("test5");

        String[] stockArr = new String[scripts.size()];
        stockArr = scripts.toArray(stockArr);

        for(String s : stockArr)
            System.out.println(s);*/


        /*MultiMap Code*/
        /*List list;
        MultiValueMap map = new MultiValueMap();
        map.put("fánhuīhuī", "樊辉辉");
        map.put("gāomínzhèng", "高民政");
        map.put("hóngwénshèng", "洪文胜");
        map.put("liúchípíng", "刘持平");
        map.put("sūhuìmĭn", "苏会敏");
        map.put("hóngwénshèng", "洪文胜");
        map.put("liúchípíng", "刘持平");
        map.put("sūhuìmĭn", "苏会敏");
        map.put("fánhuīhuī", "樊辉辉");
        map.put("gāomínzhèng", "高民政");

        Set entrySet = map.entrySet();
        Iterator it = entrySet.iterator();
        System.out.println("  Object key");
        while (it.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) it.next();
            list = (List) map.get(mapEntry.getKey());
            for (int j = 0; j < list.size(); j++) {
                System.out.println("\t" + mapEntry.getKey() + "\t  " + list.get(j));
            }
        }
*/




       /* Collator collator = Collator.getInstance(Locale.FRENCH);
        collator.setStrength(Collator.SECONDARY);


        if (collator.compare("débárquér", "debarquer") == 0) {
            System.out.println("Both Strings are equal");
        } else {
            System.out.println("Both Strings are not equal");
        }
*/
        /*Collator c = Collator.getInstance(Locale.CHINA);
        c.setStrength(Collator.PRIMARY);
        Map<CollationKey, String> dictionary = new TreeMap<CollationKey, String>();
        dictionary.put(c.getCollationKey("都"), "都");

        CollationKey query = c.getCollationKey("都");
        System.out.println(dictionary.get(query));
*/
        //Portion 01
        /*String str = "vipin";
        byte[] bytearray = str.getBytes();
        String i = Arrays.toString(bytearray);
        System.out.println(i);

        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

        System.out.println(Arrays.toString(bytes));
        String str1 = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(str1);*/









       // byte [] bytes2 = {0, 6, 36, -84, 113, 125, -118, -47};
        //System.out.println(ByteBuffer.wrap(bytearray).getLong());
        //System.out.println(convertByteArrayToLong(bytearray));

       // readFile();

        //Portion 02
        /*String rawString = "汉啊汉啊汉啊汉啊汉";
        byte[] bytes = rawString.getBytes();
        System.out.println(rawString);

        System.out.println(Arrays.toString(bytes));
        System.out.println(ByteBuffer.wrap(bytes).getLong());
        ByteBuffer buffer = StandardCharsets.UTF_8.encode(rawString);*/

        /*String utf8EncodedString = StandardCharsets.UTF_8.decode(buffer).toString();
        System.out.println(buffer);
        System.out.println(buffer.getLong());
        System.out.println(utf8EncodedString);*/

       /* String input = "汉啊";

        byte[] bytes = input.getBytes();

        LongBuffer tmpBuf = ByteBuffer.wrap(bytes).asLongBuffer();

        long[] lArr = new long[tmpBuf.remaining()];
        for (int i = 0; i < lArr.length; i++)
            lArr[i] = tmpBuf.get();

        System.out.println(input);
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(lArr));

        *//*long[] longs = { -1823524754958915919L, -8510231497038263835L, -7671065365075094134L };*//*
      byte[] inputBytes = new byte[lArr.length * 8];
        ByteBuffer bbuf = ByteBuffer.wrap(inputBytes);
        for (long l : lArr)
            bbuf.putLong(l);
        System.out.println(new String(inputBytes));*/

// store longs...

// ...load longs
        /*Working Logic of Long to original characters*/
        //long[] longs = { -1823524754958915919L, -8510231497038263835L, -7671065365075094134L };
       /* byte[] inputBytes = new byte[lArr.length * 8];
        ByteBuffer bbuf = ByteBuffer.wrap(inputBytes);
        for (long l : lArr)
            bbuf.putLong(l);
        System.out.println(new String(inputBytes));*/


        /*String s = "vipinmama";
        long l = utf8ToLong(s);
        System.out.println(l);
        byte[] numberByte = Longs.toByteArray(l);
        String str4 = new String(numberByte, StandardCharsets.UTF_8);
        System.out.println(str4);
       // System.out.println(str1);
        System.out.println("string : " + Arrays.toString(numberByte));*/
        /* final int PADDING_SIZE = 4;
        byte[] aKey = {1, 2, 3, 4}; // your array of size 8
        System.out.println(Arrays.toString(aKey));
        byte[] newKey = new byte[8];
        System.arraycopy(newKey, aKey.length-1, aKey, PADDING_SIZE, aKey.length - PADDING_SIZE); // right shift
        System.out.println(Arrays.toString(newKey));*/

        /*Logic to append zeros to byteArray*/
        /*byte src[] = { 5, 10, 20, 30, 40,50,60 };
        byte dest[] = { 0,0,0,0,0,0,0,0 };
        int srcPo = 0;
        int destPo = 0;
        int len = src.length;

        // copies an array from the specified source array
        System.arraycopy(src, srcPo, dest, destPo, len);
        for (int i = 0; i < dest.length; i++)
            System.out.print(dest[i] + " ");*/

    }

    public static long convertByteArrayToLong(byte[] longBytes)
    {
        ByteBuffer byteBuffer = ByteBuffer.allocate(Long.BYTES);
        byteBuffer.put(longBytes);
        byteBuffer.flip();
        return byteBuffer.getLong();
    }

    /*public static void readFile() throws  Exception{
        BufferedReader  reader=new BufferedReader(new InputStreamReader(new FileInputStream("/Users/vipinmamidi/Documents/NEU/1st SEM/PSA/FinalProject/jc.txt"),Charset.defaultCharset()));
        String strLine=null;
        while ((strLine = reader.readLine()) != null){
            System.out.println(strLine);
        }
        reader.close();
    }*/

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

   /* public static String[] toPingyin(char cr) {
        HanyuPinyinOutputFormat hanYuPinOutputFormat = new HanyuPinyinOutputFormat();
        hanYuPinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        try {
            return PinyinHelper.toHanyuPinyinStringArray (cr, hanYuPinOutputFormat);
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();

        }
    }*/

}
