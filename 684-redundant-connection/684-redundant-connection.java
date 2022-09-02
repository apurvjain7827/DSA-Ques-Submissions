class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];
        int n = edges.length;
        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        for(int i=0; i<n; i++){
            int src = edges[i][0];
            int nbr = edges[i][1];
            
            int srcLead = find(src);
            int nbrLead = find(nbr);
            
            if(srcLead == nbrLead){
                int[] ans = {edges[i][0], edges[i][1]};
                return ans;
            }
            
            union(srcLead, nbrLead);
        }
        return new int[2];
    }
    
    public int find(int node){
        if(parent[node] == node){
            return node;
        }
        else{
            parent[node] = find(parent[node]);
            return parent[node];
        }
    }
    
    public void union(int s1l, int s2l){
        if(rank[s1l] < rank[s2l]){
            parent[s1l] = s2l;
        }
        else if(rank[s2l] < rank[s1l]){
            parent[s2l] = s1l;
        }
        else{
            parent[s1l] = s2l;
            rank[s2l]++;
        }
    }
}