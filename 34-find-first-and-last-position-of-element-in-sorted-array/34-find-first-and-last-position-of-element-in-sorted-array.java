class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int fi = -1;
        while(i <= j){
            int mid = (i + j)/2;
            if(nums[mid] < target){
                i = mid + 1;
            }
            else if(nums[mid] > target){
                j = mid - 1;
            }
            else if(nums[mid] == target){
                fi = mid;
                j = mid-1;
            }
        }
        i = 0;
        j = nums.length - 1;
        int li = -1;
        while(i <= j){
            int mid = (i + j)/2;
            if(nums[mid] < target){
                i = mid + 1;
            }
            else if(nums[mid] > target){
                j = mid - 1;
            }
            else if(nums[mid] == target){
                li = mid;
                i = mid+1;
            }
        }
        int[] ans = {fi, li};
        return ans;
    }
}