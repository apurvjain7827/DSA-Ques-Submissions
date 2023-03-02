//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        int[] nnr = new int[N];
        Stack<Integer> st = new Stack<>();
        // st.push(0);
        Arrays.fill(nnr, N);
        for(int i=0; i<N; i++){
            if(A[i] < 0){
                nnr[i] = i;
                while(st.size() != 0){
                    int ind = st.pop();
                    nnr[ind] = i;
                }
            }
            else{
                st.push(i);
            }
        }
        
        long[] res = new long[N - K + 1];
        int j = 0;
        for(int i=0; i<res.length; i++){
            if(j < i){
                j = i;
            }
            while(nnr[j] != j && nnr[j] < i + K){
                j = nnr[j];
            }
            
            if(i == j && A[j] >= 0){
                // if(A[j] < 0){
                    res[i] = 0;
                // }
            }
            else{
                res[i] = A[j];
            }
            
            
        }
        
        // for(int ele : nnr){
        //     System.out.println(ele);
        // }
        
        return res;
    }
}