class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashSet<Integer> freq = new HashSet<>();
        // boolean[] par = new boolean[n];
        for(int val : leftChild){
            if(val == -1){
                continue;
            }
            if(freq.contains(val)){
                return false;
            }
            // par[val] = t
            freq.add(val);
        }

        for(int val : rightChild){
            if(val == -1){
                continue;
            }
            if(freq.contains(val)){
                return false;
            }
            freq.add(val);
        }

        int cnt = 0;
        int par = -1;
        for(int i=0; i<n; i++){
            if(freq.contains(i) == false){
                par = i;
                cnt++;
            }
        }

        if(cnt != 1){
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        boolean ans = helper(par, 0, leftChild, rightChild, map);
        for(int i=0; i<n; i++){
            if(map.containsKey(i) == false){
                return false;
            }
        }
        return ans;
    }

    public boolean helper(int node, int lev, int[] left, int[] right, HashMap<Integer, Integer> map){
        if(map.containsKey(node)){
            return map.get(node) == lev;
        }

        map.put(node, lev);
        boolean ret = true;
        if(left[node] != -1){
            if(!helper(left[node], lev+1, left, right, map)){
                ret = false;
            }
        }

        if(right[node] != -1){
            if(!helper(right[node], lev+1, left, right, map)){
                ret = false;
            }
        }

        return ret;
    }
}