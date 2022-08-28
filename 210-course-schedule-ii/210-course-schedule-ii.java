class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        int[] in = new int[numCourses];
        
        for(int i=0; i<prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }
        
        Queue<Integer> qu = new LinkedList<>();
        for(int i=0; i<in.length; i++){
            if(in[i] == 0){
                qu.add(i);
            }
        }
        int[] ret = new int[numCourses];
        int idx = 0;
        while(qu.size() != 0){
            int rem = qu.remove();
            ret[idx] = rem;
            idx++;
            
            for(int n : graph[rem]){
                in[n]--;
                
                if(in[n] == 0)
                    qu.add(n);
            }
        }
        
        if(idx < numCourses)
            return new int[] {};
        
        return ret;
    }
}