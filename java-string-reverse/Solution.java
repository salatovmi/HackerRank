import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        boolean palindrome = true;
        for (int i = 0; i <= A.length()-1-i; i++) {
            if (A.charAt(i) != A.charAt(A.length()-1-i)) {
                palindrome = false;
                break;
            }
        }
        if (palindrome) System.out.println("Yes");
        else System.out.println("No");
    }
}
