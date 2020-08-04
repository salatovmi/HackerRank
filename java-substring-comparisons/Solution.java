import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        smallest = largest = smallest + s.substring(0, k);
        for (int i = 1; i <= s.length()-k; i++) {
            boolean fS = true;
            boolean fL = true;
            for (int x = 0; x < k; x++) {
                if (smallest.charAt(x) > s.charAt(i+x) && fS) {
                    smallest = s.substring(i, i+k);
                    fS = false;
                }
                else if (smallest.charAt(x) < s.charAt(i+x) && fS) fS = false;
                if (largest.charAt(x) > s.charAt(i+x) && fL) fL = false;
                else if (largest.charAt(x) < s.charAt(i+x) && fL) {
                    largest = s.substring(i, i+k);
                    fL = false;
                }
                if (!fS && !fL) break;
            }
        }
        
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
