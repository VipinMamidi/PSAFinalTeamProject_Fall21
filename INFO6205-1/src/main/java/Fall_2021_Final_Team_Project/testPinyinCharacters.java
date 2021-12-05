package Fall_2021_Final_Team_Project;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class testPinyinCharacters {


    public static String[] readArray;
    public static String[] convArray;
    public static int length;
    public static void main(String[] args) throws IOException, BadHanyuPinyinOutputFormatCombination {

        List<String> lines = Files.readAllLines(Paths.get("/Users/vipinmamidi/Documents/NEU/1st SEM/PSA/FinalProject/split/OneTh.txt"), Charset.forName("UTF-8"));
        String[] str = lines.stream().toArray(String[]::new);

        str = "阿安 阿滨 阿斌 阿彬 阿兵 阿冰".split(" ");
        length = str.length;
        readArray = str;
        convArray = new String[str.length];

        for(String s : str){
            String p = getPinYin(s);
            System.out.println(s +  " :: " + p);
        }
       // printWordsToFile();
    }

    public static String getPinYin(String sa) throws BadHanyuPinyinOutputFormatCombination {
        StringBuffer output = new StringBuffer("");
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
                System.out.println("else");
            //output.append(Character.toString(input[i]));
        }

        return output.toString();
    }

    public static void printWordsToFile() throws IOException, BadHanyuPinyinOutputFormatCombination {
        FileWriter writer = new FileWriter("/Users/vipinmamidi/Documents/NEU/1st SEM/PSA/FinalProject/split/TestPinToneVipshuffledChinese.txt");

        for (int i = 0; i < length; i++) {
            String or = readArray[i];
            String pi = getPinYin(or);
            writer.write( pi + " :: " + or + "\n");
        }

        writer.close();
    }
}
