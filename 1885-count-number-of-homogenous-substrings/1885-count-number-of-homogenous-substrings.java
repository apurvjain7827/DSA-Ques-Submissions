class Solution {
    public int helper(int n, int[] dp){
        if(n == 1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = (n + helper(n-1, dp)) % mod;
    }

    int mod;

    public int countHomogenous(String s) {
        mod = 1000000007;
        int i = 0;
        int ans = 0;
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        while(i < s.length()){
            int j = i;
            while(j < s.length() && s.charAt(i) == s.charAt(j)){
                j++;
            }

            int len = j - i;
            // int ta = ((len * (len + 1)) % mod)/2;
            int ta = helper(len, dp);
            ans = (ans + ta) % mod;
            i = j;
        }

        return ans % mod;
    }
}