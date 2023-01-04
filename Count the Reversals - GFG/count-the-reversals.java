//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String s)
    {
        // your code here    
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{'){
                st.push(ch);
            }
            else{
                if(st.size() == 0){
                    st.push(ch);
                }
                else if(st.peek() == '{'){
                    st.pop();
                }
                else{
                    st.push(ch);
                }
            }
        }
        if(st.size() % 2 != 0){
            return -1;
        }
        int ans = 0;
        while(st.size() != 0){
            char b2 = st.pop();
            char b1 = st.pop();
            if(b1 == b2){
                ans++;
            }
            else{
                ans += 2;
            }
        }
        
        return ans;
    }
}