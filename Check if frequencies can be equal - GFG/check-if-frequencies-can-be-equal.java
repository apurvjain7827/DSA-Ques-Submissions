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
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean sameFreq(String s) {
        // code here
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : freq){
            if(i > 0){
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        
        if(map.size() == 2){
            int f1 = -1;
            int f2 = -1;
            for(int val : map.keySet()){
                if(f1 == -1){
                    f1 = val;
                }
                else{
                    f2 = val;
                    
                    if(f1 < f2){
                        int temp = f1;
                        f1 = f2;
                        f2 = temp;
                    }
                }
            }
            
            // if(f1 - f2 != 1){
            //     return false;
            // }
            
            if(map.get(f1) == 1 || map.get(f2) == 1){
                if(map.get(f2) == 1){
                    return f2 == 1;
                    
                }
                else{
                    return f1 - f2 == 1;
                }
                // return true;
            }
            else{
                return false;
            }
        }
        
        return map.size() == 1;
    }
}