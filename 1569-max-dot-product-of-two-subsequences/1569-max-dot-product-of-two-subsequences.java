class Solution {
    public boolean isPos(int[] arr){
        for(int val : arr){
            if(val < 0){
                return false;
            }
        }

        return true;
    }

    public boolean isNeg(int[] arr){
        for(int val : arr){
            if(val > 0){
                return false;
            }
        }

        return true;
    }

    public int calc(int[] arr1, int[] arr2){
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int val : arr1){
            min1 = Math.min(min1, Math.abs(val));
        }

        for(int val : arr2){
            min2 = Math.min(min2, Math.abs(val));
        }

        return -1 * (min1 * min2);
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        if(isPos(nums1) && isNeg(nums2)){
            return calc(nums1, nums2);
        }
        if(isPos(nums2) && isNeg(nums1)){
            return calc(nums1, nums2);
        }

        int[][] dp = new int[nums1.length][nums2.length];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        return helper(0, 0, nums1, nums2, dp);
    }

    public int helper(int i, int j, int[] arr1, int[] arr2, int[][] dp){
        if(i == arr1.length || j == arr2.length){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int max = Integer.MIN_VALUE;

        int res = (arr1[i] * arr2[j]) + helper(i+1, j+1, arr1, arr2, dp);
        max = Math.max(max, res);
        res = helper(i+1, j+1, arr1, arr2, dp);
        max = Math.max(max, res);

        res = helper(i, j+1, arr1, arr2, dp);
        max = Math.max(max, res);

        res = helper(i+1, j, arr1, arr2, dp);
        max = Math.max(max, res);

        return dp[i][j] = max;
    }
}