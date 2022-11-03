//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.getSmallest(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String getSmallest(Long N) {
        // code here
        if(N == 1){
            return "1";
        }
        ArrayList<Integer> dig = new ArrayList<>();
        long num = N;
        int chk = 9;
        while(num != 1 && chk != 1){
            while(num % chk == 0){
                num = num / chk;
                dig.add(chk);
            }
            chk--;
        }
        
        if(num != 1){
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        
        // int raise = Math.pow(10, dig.size() - 1);
        for(int i = dig.size() - 1; i>=0; i--){
            sb.append(dig.get(i));
        }
        
        return sb.toString();
    }
};