//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
    static long minTime(int[] arr,int n,int k){
        //code here
        long lo = -1;
        long hi = 0;
        for(int ele : arr){
            lo = Math.max(lo, ele);
            hi += ele;
        }
        
        while(lo < hi){
            long mid = (lo + hi)/2;
            int countParts = 1;
            int currSum = 0;
            for(int time : arr){
                if(currSum + time <= mid){
                    currSum += time;
                }
                else{
                    currSum = time;
                    countParts++;
                }
            }
            
            if(countParts > k){
                lo = mid + 1;            
            }
            else{
                hi = mid;
            }
        }
        
        return hi;
    }
}


