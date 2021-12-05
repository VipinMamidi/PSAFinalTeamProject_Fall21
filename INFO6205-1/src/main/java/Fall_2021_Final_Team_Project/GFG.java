package Fall_2021_Final_Team_Project;

// Java program for the above approach
import java.io.*;
import java.lang.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class GFG {

    // Utility function to get the ASCII
    // value of the character at index d
    // in the string
    static int char_at(String str, int d)
    {
        if (str.length() <= d)
            return -1;
        else
            return (int)(str.charAt(d));
    }

    // Function to sort the array using
    // MSD Radix Sort recursively
   /* static void MSD_sort(String str[], int lo, int hi,
                         int d)
    {
        // Recursive break condition
        if (hi <= lo) {
            return;
        }

        // Stores the ASCII Values
        int count[] = new int[256 + 1];

        // Temp is created to easily
        // swap strings in str[]
        HashMap<Integer, String> temp = new HashMap<>();

        // Store the occurrences of the most
        // significant character from
        // each string in count[]
        for (int i = lo; i <= hi; i++) {
            int c = char_at(str[i], d);
            //count = count+1;
        }

        // Change count[] so that count[]
        // now contains actual position
        // of this digits in temp[]
        for (int r = 0; r < 256; r++)
            count[r + 1] += count[r];

        // Build the temp
        for (int i = lo; i <= hi; i++) {
            int c = char_at(str[i], d);
            temp.put(count[i+1], str[i]);
        }

        // Copy all strings of temp to str[],
        // so that str[] now contains
        // partially sorted strings
        for (int i = lo; i <= hi; i++)
            str[i] = temp.get(i - lo);

        // Recursively MSD_sort() on each
        // partially sorted strings set to
        // sort them by their next character
        for (int r = 0; r < 256; r++)
            MSD_sort(str, lo + count[r],
                    lo + count[r + 1] - 1, d + 1);
    }*/



    /*private static void msd(String[] a, int lo, int hi, int d)
    {
        if (hi <= lo + 1) return;
        int[] count = new int[256+1];
        for (int i = 0; i < N; i++)
            count[a[i].charAt(d) + 1]++;
        for (int k = 1; k < 256; k++)
            count[k] += count[k-1];
        for (int i = 0; i < N; i++)
            temp[count[a[i].charAt(d)]++] = a[i];
        for (int i = 0; i < N; i++)
            a[i] = temp[i];
        for (int i = 0; i < 255; i++)
            msd(a, l + count[i], l + count[i+1], d+1);
    }*/

    private static int charAt(String s, int d)
    {  if (d < s.length()) return s.charAt(d); else return -1;  }

    public static void sort(String[] a){
        aux = new String[a.length];
        msd_rad(a,aux,0,a.length-1,0);
    }

    private static void msd_rad(String[] a, String[] aux, int lo, int hi, int d){
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
        //print(a, n);
        for(int r=0;r<R;r++){
            msd_rad(a, aux,lo + count[r], lo + count[r+1] - 1, d+1);
        }

    }

    // Function to print an array
    static void print(String str[], int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.println();
    }

    // Driver Code
    public static void main(String[] args)
    {
        Instant start = Instant.now();

        // Input String
        /*String str[] = { "midnight", "badge", "bag",
                "worker", "banner", "wander" };*/
        String str[] = { "add","cab","fad","fee","bad","bee","fed","bed","ace" };

        // Size of the string
        n = str.length;

        System.out.println("GFG");
        System.out.print("Unsorted array : ");

        // Print the unsorted array
        print(str, n);

        // Function Call
        //msd(str, 0, n - 1, 0);
        sort(str);

        System.out.print("Sorted array : ");

        // Print the sorted array
        print(str, n);

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
    }

    private static String[] aux;
    private static final int R = 256;
    private static int n;

}

// This code is contributed by Kingash.

