package Fall_2021_Final_Team_Project;


// Java program to Store duplicate
// keys-values pair and sort the
// key-value pair by key
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(String arrk[], int l, int m,
               int r, String arrv[])
    {
        // Sizes of two subarrays
        // that are to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temporary arrays */
        String L[] = new String[n1];
        String R[] = new String[n2];
        String Lk[] = new String[n1];
        String Rk[] = new String[n2];

        /* Copy data to temporary arrays */
        for (int i = 0; i < n1; ++i) {
            L[i] = arrk[l + i];
            Lk[i] = arrv[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arrk[m + 1 + j];
            Rk[j] = arrv[m + 1 + j];
        }

        // Initial indexes of
        // first and second subarrays
        int i = 0, j = 0;

        int k = l;

        while (i < n1 && j < n2) {
            if (  /*L[i].compareTo(R[j])*/ true )  {
                arrk[k] = L[i];
                arrv[k] = Lk[i];

                i++;
            }
            else {
                arrk[k] = R[j];
                arrv[k] = Rk[j];

                j++;
            }

            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arrk[k] = L[i];
            arrv[k] = Lk[i];

            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arrk[k] = R[j];
            arrv[k] = Rk[j];

            j++;
            k++;
        }
    }

    // Function that sorts arr[l..r] using merge()
    void sort(String arrk[], int l, int r, String arrv[])
    {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arrk, l, m, arrv);
            sort(arrk, m + 1, r, arrv);

            // Merge the sorted halves
            merge(arrk, l, m, r, arrv);
        }
    }

    /* Function to print array of size n */
    static void printArray(String arr[])
    {
        int n = arr.length;

        for (int i = 0; i < n; ++i)

            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver code
    public static void main(String[] args)
            throws java.lang.Exception
    {

        // Size of Array
        int n = 5;

        // array of keys
        /*String[] arrk = { "5", "1","4","6","8","0",
                "6","6","5","5" };*/
        String[] arrk = { "fánhuīhuī","gāomínzhèng","liúchípíng","sūhuìmĭn","hóngwénshèng" };

        // array of values
        String[] arrv = { "樊辉辉","高民政","刘持平","苏会敏","洪文胜"};

        Solution ob = new Solution();

        ob.sort(arrk, 0, n - 1, arrv);

        System.out.print("Keys: ");
        printArray(arrk);

        System.out.println();

        System.out.print("Values: ");
        printArray(arrv);
    }
}

