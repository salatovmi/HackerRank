import java.util.*;
class Solution{
	
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            if (input.isEmpty()) {
                System.out.println("true");
                continue;
            }
            else if (input.length() % 2 != 0) {
                System.out.println("false");
                continue;
            }
            char[] temp = input.toCharArray();
            int counter = 0;
            int y = 0;
            boolean ok = false;
            for (int a = 0; a < temp.length; a++) {
                ok = true;
                switch(temp[a]) {
                    case '(':
                        for (int b = a + 1; b < temp.length; b++) {
                            if (temp[b] == '(') {
                                counter++;
                            }
                            else if (temp[b] == ')' && counter != 0) {
                                counter--;
                            }
                            else if (temp[b] == ')' && counter == 0) {
                                ok = (b - a - 1) % 2 == 0;
                                break;
                            }
                        }
                        counter = 0;
                        y++;
                        break;
                    case '[':
                        for (int b = a + 1; b < temp.length; b++) {
                            if (temp[b] == '[') {
                                counter++;
                            }
                            else if (temp[b] == ']' && counter != 0) {
                                counter--;
                            }
                            else if (temp[b] == ']' && counter == 0) {
                                ok = (b - a - 1) % 2 == 0;
                                break;
                            }
                        }
                        counter = 0;
                        y++;
                        break;
                    case '{':
                        for (int b = a + 1; b < temp.length; b++) {
                            if (temp[b] == '{') {
                                counter++;
                            }
                            else if (temp[b] == '}' && counter != 0) {
                                counter--;
                            }
                            else if (temp[b] == '}' && counter == 0) {
                                ok = (b - a - 1) % 2 == 0;
                                break;
                            }
                        }
                        counter = 0;
                        y++;
                        break;
                    default:
                        if (a == 0) ok = false;
                        y--;
                }
                if (!ok) {
                    break;
                }
            }
            if (y == 0 && ok) System.out.println("true");
            else System.out.println("false");
        }
    }
}
