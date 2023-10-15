class Solution {
    public int numWays(int steps, int arrLen){
        if(arrLen == 1){
            return 1;
        }
        // int[][] dp = new int[steps + 1][arrLen + 1];
        HashMap<ArrayList<Integer>, Integer> dp = new HashMap<>();
        // for(int i=0; i<dp.length; i++){
        //     for(int j=0; j<dp[0].length; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        return helper(steps, 0, arrLen, dp);
    }

    int mod = 1000000007;

    public int helper(int steps, int ind, int len, HashMap<ArrayList<Integer>, Integer> dp){
        if(ind < 0 || ind >= len){
            return 0;
        }

        if(steps == 1){
            if(ind == 0 || ind == 1){
                return 1;
            }
            else{
                return 0;
            }
        }

        ArrayList<Integer> base = new ArrayList<>();
        base.add(steps);
        base.add(ind);

        if(dp.containsKey(base)){
            return dp.get(base);
        }

        if(ind > steps){
            return 0;
        }

        int ans = 0;
        ans = (ans + helper(steps - 1, ind - 1, len, dp))%mod;
        ans = (ans + helper(steps - 1, ind, len, dp))%mod;
        ans = (ans + helper(steps - 1, ind + 1, len, dp))%mod;

        dp.put(base, ans);

        return ans;
    }
}