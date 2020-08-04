import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = 0;
        for (int a = 0; a < n; a++) {
            int temp = 0;
            for (int b = a; b < n; b++) {
                temp += arr[b];
                if (temp < 0) res++;
            }
        }
        System.out.println(res);
    }
}
