package Fall_2021_Final_Team_Project;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class bA2L2bA {

    public static void main(String[] args) throws Exception {




       String input = "汉啊";

        byte[] bytes = input.getBytes();
        byte[] passBytes;
        if(bytes.length < 8){
            passBytes = passFulBA(bytes);
        }
        else{
            passBytes = bytes;
        }
        LongBuffer tmpBuf = ByteBuffer.wrap(passBytes).asLongBuffer();

        long[] lArr = new long[tmpBuf.remaining()];
        for (int i = 0; i < lArr.length; i++)
            lArr[i] = tmpBuf.get();

        System.out.println(input);
        System.out.println(Arrays.toString(passBytes));
        System.out.println(Arrays.toString(lArr));


      byte[] inputBytes = new byte[lArr.length * 8];
        ByteBuffer bbuf = ByteBuffer.wrap(inputBytes);
        for (long l : lArr)
            bbuf.putLong(l);

        System.out.println(new String(inputBytes));
        //long lin = returnLongFromLArr(lArr);
        //System.out.println("lin : " + lin);



    }




    public static byte[] passFulBA(byte[] sb){

       /* byte src[] = { 5, 10, 20, 30, 40,50,60 };*/
        byte dest[] = { 0,0,0,0,0,0,0,0 };
        int srcPo = 0;
        int destPo = 0;
        int len = sb.length;

        // copies an array from the specified source array
        System.arraycopy(sb, srcPo, dest, destPo, len);
        /*for (int i = 0; i < dest.length; i++)
            System.out.print(dest[i] + " ");*/
        return dest;
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
