class Solution {
    int mod;
    public int countVowelPermutation(int n) {
        int[][] dp = new int[n+1][5];
        int ans = 0;
        mod = 1000000007;
        for(int i=0; i<5; i++){
            ans = (ans + helper(n, i, dp)) % mod;
            // System.out.println(i + " " + ans);
        }
        return ans;
    }

    char[] arr = {'a', 'e', 'i', 'o', 'u'};

    public int helper(int len, int vow, int[][] dp){
        if(len == 1){
            return 1;
        }
        if(dp[len][vow] != 0){
            return dp[len][vow];
        }

        if(vow == 0){
            return dp[len][vow] = ((helper(len - 1, 1, dp) + helper(len - 1, 4, dp))%mod + helper(len - 1, 2, dp))%mod;
        }
        else if(vow == 1){
            return dp[len][vow] = (helper(len - 1, 0, dp) + helper(len - 1, 2, dp))%mod;
        }
        else if(vow == 2){
            return dp[len][vow] = (helper(len - 1, 1, dp) + helper(len - 1, 3, dp))%mod;
        }
        else if(vow == 3){
            return dp[len][vow] = helper(len - 1, 2, dp);
        }
        else{
            return dp[len][vow] = (helper(len - 1, 2, dp) + helper(len - 1, 3, dp))%mod;
        }
    }
}