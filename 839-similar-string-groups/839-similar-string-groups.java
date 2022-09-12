class Solution {
    public int numSimilarGroups(String[] strs) {
        parent = new int[strs.length];
        rank = new int[strs.length];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        
        for(int i=0; i<strs.length-1; i++){
            String s1 = strs[i];
            for(int j=i+1; j<strs.length; j++){
                String s2 = strs[j];
                int c = 0;
                for(int k=0; k<s1.length(); k++){
                    if(s1.charAt(k) != s2.charAt(k)){
                        c++;
                    }
                }
                if(c == 2 || c == 0)
                unionhelper(i, j, strs);
            }
        }
        
        // HashSet<Integer> hs = new HashSet<>();
        int count = 0;
        for(int i=0; i<parent.length; i++){
            // int par = find(i);
            // hs.add(par);
            if(parent[i] == i)
                count++;
        }
        
        return count;
    }
    
    int[] parent;
    int[] rank;
    
    public void unionhelper(int i, int j, String[] strs){
        int s1l = find(i);
        int s2l = find(j);
        
        if(rank[s1l] > rank[s2l]){
            parent[s2l] = s1l;
        }
        else if(rank[s2l] > rank[s1l]){
            parent[s1l] = s2l;
        }
        else{
            parent[s1l] = s2l;
            rank[s2l]++;
        }
    }
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}