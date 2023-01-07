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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int[] lis = new int[nums.length];
        
        lis[0] = 1;
        for(int i=1; i<nums.length; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max, lis[j]);
                }
            }
            lis[i] = max+1;
        }
        
        // for(int ele : lis){
        //     System.out.println(ele);
        // }
        
        
        int[] lisb = new int[nums.length];
        
        lisb[nums.length - 1] = 1;
        for(int i=nums.length - 2; i>=0; i--){
            int max = 0;
            for(int j=nums.length - 1; j>i; j--){
                if(nums[j] < nums[i]){
                    max = Math.max(max, lisb[j]);
                }
            }
            lisb[i] = max+1;
        }
        // System.out.println("----");
        // for(int ele : lisb){
        //   System.out.println(ele);
        // }
        
        int ans = 0;
        
        for(int i=0; i<nums.length - 1; i++){
            // if(lis[i] == 1 || lisb[i+1] == 1){
            //     continue;
            // }
            ans = Math.max(ans, lis[i] + lisb[i] - 1);
            // System.out.println(lis[i] + lisb[i+1]);
        }
        
        ans = Math.max(ans, Math.max(lis[lis.length - 1], lisb[0]));
        return ans;
    }
}