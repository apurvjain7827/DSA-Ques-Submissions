class Solution {
    public String longestPalindrome(String s) {
        int max = 1;
        String ans = s.charAt(0) + "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int g=0; g<s.length(); g++){
            for(int i=0, j=g; j<s.length(); i++, j++){
                if(g == 0){
                    dp[i][j] = true;
                }
                else if(g == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                    if(dp[i][j]){
                        if(max < j - i + 1){
                            max = j - i + 1;
                            ans = s.substring(i, j+1);
                        }
                        // max = Math.max(max, i - j + 1);
                    }
                }
                else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
                    if(dp[i][j]){
                        if(max < j - i + 1){
                            max = j - i + 1;
                            ans = s.substring(i, j+1);
                        }
                        // max = Math.max(max, i - j + 1);
                    }
                }
            }
        }

        // for(int i=0; i<dp.length; i++){
        //     for(int j=0; j<dp.length; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // System.out.println(max);
        return ans;
    }
}