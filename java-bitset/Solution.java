import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        BitSet bitSet1 = new BitSet(n);
        BitSet bitSet2 = new BitSet(n);

        for (int i = 0; i < m; i++) {
            String oper = in.next();
            int x1 = in.nextInt();
            int x2 = in.nextInt();
            switch (oper){
                case "AND":
                    if (x1 == 1) {
                        bitSet1.and(bitSet2);
                    } else if (x1 == 2){
                        bitSet2.and(bitSet1);
                    }
                    break;
                case "OR":
                    if (x1 == 1) {
                        bitSet1.or(bitSet2);
                    } else if (x1 == 2){
                        bitSet2.or(bitSet1);
                    }
                    break;
                case "XOR":
                    if (x1 == 1) {
                        bitSet1.xor(bitSet2);
                    } else if (x1 == 2){
                        bitSet2.xor(bitSet1);
                    }
                    break;
                case "FLIP":
                    if (x1 == 1) {
                        bitSet1.flip(x2);
                    } else if (x1 == 2) {
                        bitSet2.flip(x2);
                    }
                    break;
                case "SET":
                    if (x1 == 1) {
                        bitSet1.set(x2);
                    } else if (x1 == 2) {
                        bitSet2.set(x2);
                    }
                    break;
            }
            System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
        }
    }
}
