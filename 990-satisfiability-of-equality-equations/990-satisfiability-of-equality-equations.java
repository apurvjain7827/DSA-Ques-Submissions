class Solution {
    int[] parent;
    int[] rank;
    
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        for(int i=0; i<26; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(String s : equations){
            int e1 = s.charAt(0) - 'a';
            int e2 = s.charAt(3) - 'a';
            if(s.charAt(1) == '='){
                int p1 = find(e1);
                int p2 = find(e2);
                
                if(p1 == p2)
                    continue;
                
                union(p1, p2);
            }
            
        }
        
        
        for(String s : equations){
            int e1 = s.charAt(0) - 'a';
            int e2 = s.charAt(3) - 'a';
            
            if(s.charAt(1) == '!'){
                if(find(e1) == find(e2)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public int find(int ele){
        if(parent[ele] == ele){
            return ele;
        }
        else{
            parent[ele] = find(parent[ele]);
            return parent[ele];
        }
    }
    
    public void union(int p1, int p2){
        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
        }
        else if(rank[p2] > rank[p1]){
            parent[p1] = p2;
        }
        else{
            parent[p1] = p2;
            rank[p2]++;
        }
    }
}