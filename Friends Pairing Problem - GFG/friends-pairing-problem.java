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
       long mod = 1000000007;
       if(n <= 2){
           return (long)n;
       }
       long n1 = 1;
       long n2 = 2;
       long ans = 4;
       long num = 3;
       while(num <= n){
           ans = (n2 + ((num - 1)*n1)%mod)%mod;
           n1 = n2;
           n2 = ans;
           num++;
       }
       
       return ans;
    }
}    
 