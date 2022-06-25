class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean state = true;
        for(int i=1; i<nums.length; i++){
            if(nums[i] < nums[i-1]){
                state = false;
                break;
            }
        }
        if(state)
            return true;
        state = true;
        for(int i=2; i<nums.length; i++){
            if(nums[i] < nums[i-1]){
                state = false;
                break;
            }
        }
        if(state)
            return true;
        state = true;
        for(int i=1; i<nums.length; i++){
            int prev = nums[0]; 
            for(int j=1; j<nums.length; j++){
                if(j == i)
                    continue;
                if(nums[j] < prev){
                    state = false;
                    break;
                }
                prev = nums[j];
            }
            if(state)
                return true;
            state = true;
        }
        return false;
    }
}