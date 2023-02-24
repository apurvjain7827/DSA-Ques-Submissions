//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
    
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
	    Complete obj = new Complete();
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    int arr [][] = new int[K][2];
		    for(int i = 0;i<K;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            int ans = obj.doctorStrange(N, K, arr);
            System.out.println(ans);
    	    
		}
	}
}




// } Driver Code Ends


//User function Template for Java

//User function Template for Java


class Complete{
    
    // Function for finding maximum and value pair
    static int res;
    public static int doctorStrange (int n, int k, int g[][]) {
        //Complete the function
        res = 0;
        time = 0;
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        
        for(int i=0; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] a : g){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
        }
        
        boolean[] vis = new boolean[n+1];
        int[] low = new int[n+1];
        int[] dis = new int[n+1];
        
        dfs(1, -1, adj, vis, low, dis);
        
        return res;
    }
    
    static int time;
    
    public static void dfs(int u, int p, ArrayList<Integer>[] adj, boolean[] vis, int[] low, int[] dis){
        vis[u] = true;
        low[u] = dis[u] = time++;
        int c = 0;
        boolean ap = false;
        for(int v : adj[u]){
            if(v == p){
                continue;
            }
            else if(vis[v] == true){
                low[u] = Math.min(low[u], dis[v]);
            }
            else{
                c++;
                dfs(v, u, adj, vis, low, dis);
                low[u] = Math.min(low[u], low[v]);
                
                if(p != -1 && low[v] >= dis[u]){
                    ap = true;
                }
            }
        }
        
        if(p == -1 && c > 1){
            ap = true;
        }
        
        if(ap){
            res++;
        }
    } 
    
    
}