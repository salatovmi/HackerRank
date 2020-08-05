import java.io.*;
import java.util.*;
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
 public static boolean checker(PerformOperation p, int num) {
  return p.check(num);
 }
    
    PerformOperation isOdd(){
        return x -> x % 2 != 0;
    }
    PerformOperation isPrime(){
        return x -> {
            if (x <= 1) return false;
            for (int i = 2; i < x; i++) {
                if (x % i == 0) return false;
            }
            return true;
        };
    }
    PerformOperation isPalindrome(){
        return x -> {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            while (x > 0) {
                arr.add(x % 10);
                x /= 10;
            }
            for (int a = 0, b = arr.size() - 1; a < arr.size() / 2; a++, b--) {
                if (arr.get(a) != arr.get(b)) return false;
            }
            return true;
        };
    }
}

public class Solution {

 public static void main(String[] args) throws IOException {
  MyMath ob = new MyMath();
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int T = Integer.parseInt(br.readLine());
  PerformOperation op;
  boolean ret = false;
  String ans = null;
  while (T--> 0) {
   String s = br.readLine().trim();
   StringTokenizer st = new StringTokenizer(s);
   int ch = Integer.parseInt(st.nextToken());
   int num = Integer.parseInt(st.nextToken());
   if (ch == 1) {
    op = ob.isOdd();
    ret = ob.checker(op, num);
    ans = (ret) ? "ODD" : "EVEN";
   } else if (ch == 2) {
    op = ob.isPrime();
    ret = ob.checker(op, num);
    ans = (ret) ? "PRIME" : "COMPOSITE";
   } else if (ch == 3) {
    op = ob.isPalindrome();
    ret = ob.checker(op, num);
    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

   }
   System.out.println(ans);
  }
 }
}
