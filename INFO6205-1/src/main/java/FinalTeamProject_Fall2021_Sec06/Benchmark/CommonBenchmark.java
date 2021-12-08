package FinalTeamProject_Fall2021_Sec06.Benchmark;
import FinalTeamProject_Fall2021_Sec06.DP_QuickSort.DPQsort_Chinese_pinyin;
import FinalTeamProject_Fall2021_Sec06.LSDRadixSort.LSDsort_Chinese_Pinyin;
import FinalTeamProject_Fall2021_Sec06.huskySort.sort.huskySort.PureHuskySort;
import FinalTeamProject_Fall2021_Sec06.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import FinalTeamProject_Fall2021_Sec06.MSDRadixSort.MSDRadixSort_toSortChineseWords;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommonBenchmark {
    public static void runBenchmark(String[] input, Consumer<String[]> readCon,Supplier<String[]> readsup, String desc){
        Benchmark_Timer<String[]> bT= new Benchmark_Timer<>(desc,readCon);
        double time=bT.runFromSupplier(readsup,60);
        System.out.println("Time taken is "+time+" msec for "+desc+" of input size: "+input.length);
    }

    public static String[] Supfunc(String[] ip){
        return ip;
    }
    public static String[] Confunc(String[] x) throws IOException {
         String[] a = DPQsort_Chinese_pinyin.sort(x);
         return a;
    }
    public static String[] LSDConfunc(String[] x) throws IOException {
        String[] a = LSDsort_Chinese_Pinyin.sort(x,0,x.length-1);
        return a;
    }
    public static void Huskyconfunc(String[] x) {
        PureHuskySort<String> husky = new PureHuskySort<>(HuskyCoderFactory.unicodeCoder, false, false);
        husky.sort(x);
    }

    public static String[] MSDConfunc(String[] x) throws IOException {
        String[] a = MSDRadixSort_toSortChineseWords.sort(x);
        return a;
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/FinalTeamProject_Fall2021_Sec06/Resources/100ShuffedChineseWords.txt"), Charset.forName("UTF-8"));
        String[] input = lines.stream().toArray(String[]::new);

        Supplier<String[]> sup = () -> Supfunc(input);

        Consumer<String[]> DPQsort = (x) -> {
            try {
                Confunc(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        CommonBenchmark.runBenchmark(input,DPQsort,sup,"Dual Pivot Quick Sort");

        Consumer<String[]> LSDsort = (x) -> {
            try {
                LSDConfunc(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        CommonBenchmark.runBenchmark(input,LSDsort,sup,"LSD Sort");
        Consumer<String[]> Huskysort = (x) -> Huskyconfunc(input);
        CommonBenchmark.runBenchmark(input,Huskysort,sup,"Pure Husky Sort");

        Consumer<String[]> MSD = (x) -> {
            try {
                MSDConfunc(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        CommonBenchmark.runBenchmark(input,MSD,sup,"MSD Radix Sort");
    }
}

