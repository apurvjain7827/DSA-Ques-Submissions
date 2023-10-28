class Solution {
public:
    int minChanges(std::string s) {
        int len = s.length();
        std::vector<std::vector<int>> dp(len, std::vector<int>(2, -1));

        return std::min(helper(s, dp, len - 1, 0), helper(s, dp, len - 1, 1));
    }

    int helper(const std::string& s, std::vector<std::vector<int>>& dp, int ind, int bit) {
        if (ind == 0) {
            if (s[0] - '0' == bit) {
                return dp[ind][bit] = 0;
            } else {
                return dp[ind][bit] = 1;
            }
        }

        if (dp[ind][bit] != -1) {
            return dp[ind][bit];
        }

        if (ind % 2 == 0) {
            int ra = std::min(helper(s, dp, ind - 1, bit), helper(s, dp, ind - 1, 1 - bit));
            if (s[ind] - '0' != bit) {
                ra++;
            }
            return dp[ind][bit] = ra;
        } else {
            if (bit == s[ind] - '0') {
                return dp[ind][bit] = helper(s, dp, ind - 1, bit);
            } else {
                return dp[ind][bit] = helper(s, dp, ind - 1, bit) + 1;
            }
        }
    }
};