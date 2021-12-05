package FinalTeamProject_Fall2021_Sec06.Benchmark;
import FinalTeamProject_Fall2021_Sec06.DP_QuickSort.DPQsort_Chinese_pinyin;
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
        double time=bT.runFromSupplier(readsup,20);
        System.out.println("Time taken is "+time+" msec for "+desc+" of input size: "+input.length);
    }

    public static String[] Supfunc(String[] ip){
        return ip;
    }
    public static String[] Confunc(String[] x) throws IOException {
         String[] a = DPQsort_Chinese_pinyin.sort(x);
         return a;
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("/Users/sowmyachinimilli/MSIS/PSA/shuffledChinese250k.txt"), Charset.forName("UTF-8"));
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
        Supplier<String[]> LSDsup = () -> Supfunc(input);

        Consumer<String[]> LSDsort = (x) -> {
            try {
                Confunc(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        CommonBenchmark.runBenchmark(input,LSDsort,LSDsup,"LSD Sort");
    }
}

