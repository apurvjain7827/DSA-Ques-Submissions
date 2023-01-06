//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int keys[]= new int[n];
            for(int i = 0; i < n; i++)
                keys[i] = Integer.parseInt(input_line[i]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int freq[]= new int[n];
            for(int i = 0; i < n; i++)
                freq[i] = Integer.parseInt(input_line1[i]);
            Solution ob = new Solution();
            System.out.println(ob.optimalSearchTree(keys, freq, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        // code here
        int[][] dp = new int[n][n];
        int[] arr = new int[n];
        arr[0] = freq[0];
        
        for(int i=1; i<n; i++){
            arr[i] = arr[i-1] + freq[i];
        }
        
        for(int g=0; g<n; g++){
            for(int i=0, j=g; j<n; i++, j++){
                if(g == 0){
                    dp[i][j] = freq[i];
                }
                else if(g == 1){
                    if(freq[i] < freq[i+1]){
                        dp[i][j] = 2*freq[i] + freq[i+1];
                    }
                    else{
                        dp[i][j] = freq[i] + 2*freq[i+1];
                    }
                }
                else{
                    int min = Integer.MAX_VALUE;
                    for(int k1=g+1, k2=1;k1 >= 1; k1--, k2++){
                        int left = (j - k1) == -1? 0: dp[i][j - k1];
                        int right = (i+k2) > (n-1) ? 0 : dp[i+k2][j];
                        int factor = i > 0 ? arr[j] - arr[i-1] : arr[j];
                        
                        min = Math.min(min, left + right + factor);
                    }
                    
                    dp[i][j] = min;
                }
            }
        }
        
        return dp[0][n-1];
    }
}
