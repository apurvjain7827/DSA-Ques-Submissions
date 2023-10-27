class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int g=0; g < s.length(); g++){
            for(int i=0,j=g; j<s.length(); i++, j++){
                if(g == 0){
                    dp[i][j] = true;
                }
                else if(g == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                }

                if(dp[i][j]){
                    if(j - i + 1 > ans.length()){
                        ans = s.substring(i, j+1);
                    }
                }
            }
        }

        return ans;
    }
}