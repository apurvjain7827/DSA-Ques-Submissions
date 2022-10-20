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
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] G = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    G[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.maximumMatch(G);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maximumMatch(int[][] G)
    {
        // Code here
        int n = G.length + G[0].length + 2;
        int[][] graph = new int[n][n];
        int[][] rgraph = new int[n][n];
        for(int i=0; i<G.length; i++){
            for(int j=0; j<G[0].length; j++){
                if(i < G.length && j < G[0].length){
                    if(G[i][j] == 1){
                        graph[i][j] = 1;
                        rgraph[i][j] = 1;
                    }
                    graph[n-2][i] = 1;
                    rgraph[n-2][i] = 1;
                    
                    graph[j][n-1] = 1;
                    rgraph[j][n-1] = 1;
                }
            }
        }
        
        int[] p = new int[n];
        int mflow = 0;
        while(traversal(rgraph, p, n-2, n-1)){
            int flow = Integer.MAX_VALUE;
            for(int i=n-1; i != n-2; i = p[i]){
                flow = Math.min(flow, rgraph[p[i]][i]);
            }
            for(int i=n-1; i != n-2; i = p[i]){
                rgraph[i][p[i]] += flow;
                rgraph[p[i]][i] -= flow;
            }
            mflow += flow;
            Arrays.fill(p, -1);
        }
        
        return mflow;
    }
    
    public boolean traversal(int[][] rgraph, int[] p, int src, int des){
        boolean[] vis = new boolean[rgraph.length];
        Queue<Integer> qu = new LinkedList<>();
        qu.add(src);
        while(qu.size() != 0){
            int rem = qu.remove();
            if(vis[rem]){
                continue;
            }
            vis[rem] = true;
            if(rem == des){
                return true;
            }
            for(int i=0; i<rgraph[rem].length; i++){
                if(rgraph[rem][i] > 0 && !vis[i]){
                    p[i] = rem;
                    qu.add(i);
                }
            }
        }
        
        return false;
    }
}