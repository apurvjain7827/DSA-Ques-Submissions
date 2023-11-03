class Solution {
    public List<String> buildArray(int[] target, int n) {
        int ind = 0;
        if(target[0] == 1){
            ind++;
        }
        List<String> ans = new ArrayList<>();
        ans.add("Push");
        if(target[0] != 1){
            ans.add("Pop");
        }
        for(int i=2; i<=n; i++){
            if(ind == target.length){
                break;
            }
            ans.add("Push");
            
            if(target[ind] != i){
                ans.add("Pop");
            }
            else{
                ind++;
                if(ind == target.length){
                    break;
                }
            }
        }

        return ans;
    }
}