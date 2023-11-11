class Graph {
    public class Edge{
        int nbr;
        int cst;
        Edge(){}
        Edge(int nbr, int cst){
            this.nbr = nbr;
            this.cst = cst;
        }
    }
    
    ArrayList<Edge>[] gr;

    public Graph(int n, int[][] edges) {
        gr = new ArrayList[n];
        for(int i = 0; i < n; i++){
            gr[i] = new ArrayList<>();
        }
        
        for(int[] arr : edges){
            gr[arr[0]].add(new Edge(arr[1], arr[2]));
        }
    }
    
    public void addEdge(int[] edge) {
        
        gr[edge[0]].add(new Edge(edge[1], edge[2]));
    }
    
    public class dp{
        int s;
        int cost;
        dp(){}
        dp(int s, int cost){
            this.s = s;
            this.cost = cost;
        }
    }
    
    public int shortestPath(int node1, int node2) {
        int src = node1;
        int n = gr.length;
        PriorityQueue<dp> pq = new PriorityQueue<>((a,b)->{
            return a.cost - b.cost;
        });
        
        boolean[] vis = new boolean[n];
        int[] path = new int[n];
        Arrays.fill(path, -1);
        
        pq.add(new dp(src, 0));
        while(pq.size() != 0){
            dp rem = pq.remove();
            
            if(vis[rem.s] == false){
                if(rem.s == node2){
                    return rem.cost;
                }
                path[rem.s] = rem.cost;
            }
            
            vis[rem.s] = true;
            
            for(Edge e : gr[rem.s]){
                if(vis[e.nbr] == false){
                    pq.add(new dp(e.nbr, rem.cost + e.cst));
                }
            }
        }
        
        return path[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */