import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> arr = new ArrayList<List<Integer>>(n);
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            arr.add(new ArrayList<>(m));
            for (int a = 0; a < m; a++) {
                int l = sc.nextInt();
                arr.get(i).add(l);
            }
        }
        int queries = sc.nextInt();
        for (int x = 0; x < queries; x++) {
            int o = sc.nextInt();
            int p = sc.nextInt();
            if (arr.size() < o || arr.get(o-1).size() < p) {
                System.out.println("ERROR!");
            }
            else {
                System.out.println(arr.get(o - 1).get(p-1));
            }
        }
    }
}
