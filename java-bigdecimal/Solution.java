import java.math.BigDecimal;
import java.util.*;
class Solution{

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
      	sc.close();
        
        int index = 0;
        String[] sorted = new String[n];
        for (int x = 0; x < n; x++) {
            for (int a = 0; a < n; a++) {
                if (new BigDecimal(s[x]).compareTo(new BigDecimal(s[a])) >= 0) {
                    index++;
                }
            }
            for (int z = n - index; z < n; z++) {
                if (sorted[z] == null) {
                    sorted[z] = s[x];
                    break;
                }
            }
            index = 0;
        }
        s = sorted;
        
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

}
