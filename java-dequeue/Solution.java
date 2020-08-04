import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int biggest = 0;
        HashSet<Integer> unique = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            unique.add(num);
            if (deque.size() == m) {
                if (unique.size() > biggest) biggest = unique.size();
                int fs = deque.remove();
                if (!deque.contains(fs)) unique.remove(fs);
            }
        }
        System.out.println(biggest);
    }
}
