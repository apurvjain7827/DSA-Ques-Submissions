//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
    
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
            input_line = read.readLine().trim().split("\\s+");
            for(int i=0;i<M;i++)
            {
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[3*i]));
                e.add(Integer.parseInt(input_line[3*i+1]));
                e.add(Integer.parseInt(input_line[3*i+2]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            int ans = ob.findMaxFlow(N, M, Edges); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int findMaxFlow(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        int mflow = 0;
        
        int[][] graph = new int[N + 1][N + 1];
        int[][] rgraph = new int[N + 1][N + 1];
        for(ArrayList<Integer> edge: Edges){
            graph[edge.get(0)][edge.get(1)] += edge.get(2);
            graph[edge.get(1)][edge.get(0)] += edge.get(2);
            rgraph[edge.get(0)][edge.get(1)] += edge.get(2);
            rgraph[edge.get(1)][edge.get(0)] += edge.get(2);
        }
        
        int[] p = new int[N + 1]; 
        while(traverse(rgraph, p, 1, N) == true){
            int flow = Integer.MAX_VALUE;
            
            for(int i = N; i != 1; i = p[i]){
                flow = Math.min(flow, rgraph[p[i]][i]);
            }
            
            for(int i = N; i != 1; i = p[i]){
                rgraph[p[i]][i] -= flow;
                rgraph[i][p[i]] += flow;
            }
            
            mflow += flow;
            Arrays.fill(p, -1);
        }
        
        return mflow;
    }
    
    boolean traverse(int[][] rgraph, int[] p, int s, int d){
        boolean[] vis = new boolean[rgraph.length];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        
        while(queue.size() > 0){
            int rem = queue.remove();
            
            if(vis[rem] == true){
                continue;
            }
            vis[rem] = true;
            
            if(rem == d){
                return true;
            }
            
            for(int i = 1; i < rgraph[rem].length; i++){
                if(rgraph[rem][i] > 0 && !vis[i]){
                    p[i] = rem;
                    queue.add(i);
                }
            }
        }
        
        
        return false;
    }
}