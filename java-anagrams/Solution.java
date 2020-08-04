import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        HashMap<Character,Integer> aMap = new HashMap<>();
        HashMap<Character,Integer> bMap = new HashMap<>();

        for (char c : aa) {
            if (aMap.containsKey(c)) {
                aMap.replace(c, aMap.get(c)+1);
            }
            else {
                aMap.put(c, 1);
            }
        }
        for (char c : bb) {
            if (bMap.containsKey(c)) {
                bMap.replace(c, bMap.get(c)+1);
            }
            else {
                bMap.put(c, 1);
            }
        }
        return aMap.equals(bMap);
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
