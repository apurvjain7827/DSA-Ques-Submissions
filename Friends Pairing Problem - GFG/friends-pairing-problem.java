//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long countFriendsPairings(int n) 
    { 
       //code here
       long MOD = 1000000007;
       if(n <= 2){
           return n;
       }
       long l = 2;
       long sl = 1;
       for(int i=3; i<=n; i++){
           long ans = (l + ((i-1)*sl))%MOD;
        //   System.out.println(ans);
           sl = l;
           l = ans;
       }
       
       return l;
    }
}    
 