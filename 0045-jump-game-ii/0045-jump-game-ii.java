class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(0, nums, dp);
    }

    public int helper(int ind, int[] nums, int[] dp){
        if(ind == nums.length - 1){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }

        int min = Integer.MAX_VALUE - 1;

        for(int i=1; i<=nums[ind]; i++){
            if(ind + i >= nums.length){
                break;
            }
            min = Math.min(min, helper(ind + i, nums, dp));
        }

        return dp[ind] = min + 1;
    }
}