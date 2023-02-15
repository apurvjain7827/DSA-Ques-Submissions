//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long countKdivPairs(int arr[], int n, int k)
    {
        //code here
        long res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // map.put(k, 1);
        for(int val : arr){
            int rem = val % k;
            if(rem == 0){
                rem = k;
            }
            res += map.getOrDefault(k - rem, 0);
            // System.out.println(val + " " + map.getOrDefault(k - rem, 0) + " " + res);
            
            if(rem == k){
                rem = 0;
            }
            // System.out.println(rem + " " + (map.getOrDefault(rem, 0) + 1));
            map.put(rem, map.getOrDefault(rem, 0) + 1);
            
        }
        
        return res;
    }
}