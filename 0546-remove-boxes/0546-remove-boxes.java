class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return helper(0, n-1, 0, boxes, dp);
    }

    public int helper(int i, int j, int k, int[] arr, int[][][] dp){
        if(i > j){
            return 0;
        }

        if(dp[i][j][k] != 0){
            return dp[i][j][k];
        }

        int ii = i;
        int kk = k;

        while(ii + 1 <= j && arr[ii + 1] == arr[ii]){
            ii++;
            kk++;
        }

        int res = (kk + 1) * (kk + 1) + helper(ii + 1, j, 0, arr, dp);

        for(int m = ii + 1; m<=j; m++){
            if(arr[m] == arr[ii]){
                int fac = helper(ii + 1, m-1, 0, arr, dp) + helper(m, j, kk + 1, arr, dp);
                res = Math.max(res, fac);
            }
        }

        return dp[i][j][k] = res;
    }
}