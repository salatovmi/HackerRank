import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game, int start) {
        // Return true if you can win the game; otherwise, return false.
        if (start < 0 || game[start] == 1) return false;
        if (start == game.length - 1 || start + leap > game.length - 1) return true;
        game[start] = 1;
        return canWin(leap, game, start+leap) || canWin(leap, game, start+1) || canWin(leap, game, start-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game, 0)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
