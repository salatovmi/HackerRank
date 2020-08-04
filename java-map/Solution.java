import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []arg)
    {
        Map<String, Integer> phoneBook = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            phoneBook.put(name, phone);
            in.nextLine();
        }
        ArrayList<String> temp = new ArrayList<String>();
        while(in.hasNext())
        {
            String s=in.nextLine();
            temp.add(s);
        }
        for (String q : temp) {
            if (phoneBook.containsKey(q)){
                System.out.println(q + "=" + phoneBook.get(q));
            }
            else {
                System.out.println("Not found");
            }
        }
    }
}
