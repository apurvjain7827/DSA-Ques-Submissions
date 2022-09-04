class Solution {
    public class pair{
        String s;
        double val;
        pair(){}
        pair(String s, double val){
            this.s = s;
            this.val = val;
        }
    }
    
    HashMap<String, pair> parent = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for(int i=0; i<equations.size(); i++){
            List<String> al = equations.get(i);
            unionHelper(al.get(0), al.get(1), values[i]);
        }
        
        double[] ans = new double[queries.size()];
        int ind = 0;
        for(List<String> list : queries){
            pair p1 = find(list.get(0));
            pair p2 = find(list.get(1));
            if(p1 == null || p2 == null){
                ans[ind] = -1;
                ind++;
                continue;
            }
            if(!p1.s.equals(p2.s)){
                ans[ind] = -1;
                ind++;
                continue;
            }
            ans[ind] = p2.val / p1.val;
            ind++;
        }
        
        return ans;
    }
    
    void unionHelper(String x, String y, double val){
        if(!parent.containsKey(x)){
            parent.put(x, new pair(x, 1));
            rank.put(x, 0);
        }
        if(!parent.containsKey(y)){
            parent.put(y, new pair(y, 1));
            rank.put(y, 0);
        }
        pair p1 = find(x);
        pair p2 = find(y);
        
        double data = ((1/p1.val)*p2.val)/val;
        union(p1.s, p2.s, data);
        
    }
    
    pair find(String x){
        if(!parent.containsKey(x)){
            return null;
        }
        if(parent.get(x).s == x){
            return new pair(x, 1);
        }
        pair par = find(parent.get(x).s);
        return new pair(par.s, par.val * parent.get(x).val);
    }
    
    void union(String x, String y, double val){
        if(rank.get(x) > rank.get(y)){
            parent.put(y, new pair(x, 1/val));
        }
        else if(rank.get(y) > rank.get(x)){
            parent.put(x, new pair(y, val));
        }
        else{
            parent.put(x, new pair(y, val));
            rank.put(y, rank.get(y) + 1);
        }
    }
}