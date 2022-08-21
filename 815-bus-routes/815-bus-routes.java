class Solution {
    public class pair{
        int bus;
        int csf;
        pair(){}
        pair(int bus, int csf){
            this.bus = bus;
            this.csf = csf;
        }
    }
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        for(int bus = 0; bus < routes.length; bus++){
            for(int stop : routes[bus]){
                if(!hm.containsKey(stop)){
                    hm.put(stop, new HashSet<>());
                }
                hm.get(stop).add(bus);
            }
        }
        
        Queue<pair> qu = new LinkedList<>();
        for(int bus : hm.get(source)){
            qu.add(new pair(bus, 1));
        }
        
        boolean[] vis = new boolean[routes.length];
        
        while(qu.size() != 0){
            pair rem = qu.remove();
            
            if(vis[rem.bus]){
                continue;
            }
            
            vis[rem.bus] = true;
            
            for(int st : routes[rem.bus]){
                if(st == target){
                    return rem.csf;
                }
            }
            
            for(int st : routes[rem.bus]){
                for(int bus : hm.get(st)){
                    if(!vis[bus])
                        qu.add(new pair(bus, rem.csf + 1));
                }
            }
        }
        
        return -1;
    }
}