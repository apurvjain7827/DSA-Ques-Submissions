class Solution {
public:
    int lengthOfLongestSubsequence(std::vector<int>& nums, int target) {
        int n = nums.size();
        std::vector<std::vector<int>> dp(n + 1, std::vector<int>(target + 1, 0));

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = INT_MIN;
                } else {
                    int a = dp[i - 1][j];
                    int b = INT_MIN;
                    if (j - nums[i - 1] >= 0) {
                        b = dp[i - 1][j - nums[i - 1]] + 1;
                    }
                    dp[i][j] = std::max(a, b);
                }
            }
        }

        return dp[n][target] <= 0 ? -1 : dp[n][target];
    }
};