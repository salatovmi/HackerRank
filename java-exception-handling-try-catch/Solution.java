import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            int x = scan.nextInt();
            int y = scan.nextInt();
            try {
                int res = x / y;
                System.out.println(res);
            } catch (Exception e) {
                System.out.println("java.lang.ArithmeticException: / by zero");
            }
        } catch (Exception e) {
            System.out.println("java.util.InputMismatchException");
        }
    }
}
