//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int numerator = Integer.parseInt(S[0]);
            int denominator = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            String ans = ob.fractionToDecimal(numerator, denominator);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String  fractionToDecimal(int numerator, int denominator)
    {
        // code here
        int n = numerator;
        int d = denominator;
        StringBuilder sb = new StringBuilder();
        sb.append(n/d);
        sb.append(".");
        // int ind = sb.length();
        HashMap<Integer, Integer> hs = new HashMap<>();
        n = n%d;
        n = n*10;
        hs.put(n, sb.length());
        if(n == 0){
            return sb.toString().substring(0, sb.length() - 1);
        }
        while(n != 0){
            sb.append(n/d);
            n = n%d;
            n = n*10;
            if(hs.containsKey(n)){
                int ind = hs.get(n);
                return sb.toString().substring(0, ind) + "(" +sb.toString().substring(ind) + ')';
            }
            hs.put(n, sb.length());
        }
        
        return sb.toString();
    }
}