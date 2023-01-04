//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        // code here
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int res = 0;
        for(int i=0; i<S.length(); i++){
            char ch = S.charAt(i);
            if(ch == '('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.size() != 0){
                    int len = i - st.peek();
                    res = Math.max(res, len);
                }
                else{
                    st.push(i);
                }
            }
        }
        
        return res;
    }
}