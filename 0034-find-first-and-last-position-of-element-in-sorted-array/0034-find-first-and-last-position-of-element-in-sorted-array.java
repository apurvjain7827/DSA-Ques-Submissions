class Solution {
    int a1;
    int a2;
    public int[] searchRange(int[] nums, int target) {
        a1 = nums.length;
        a2 = -1;
        
        // int lo = 0;
        // int hi = nums.length - 1;
        // while(lo <= hi){
        //     int mid = (lo + hi)/2;
        //     if(nums[mid] > target){
        //         hi = mid - 1;
        //     }
        //     else if(nums[mid] < target){
        //         lo = mid + 1;
        //     }
        //     else{
        //         a1 = Math.min(a1, mid);
        //         a2 = Math.max(a2, mid);
        //     }
        // }

        helper(nums, target, 0, nums.length - 1);
        if(a2 == -1){
            return new int[]{-1, -1};
        }

        return new int[]{a1, a2};
    }

    public void helper(int[] nums, int target, int lo, int hi){
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(nums[mid] > target){
                hi = mid - 1;
            }
            else if(nums[mid] < target){
                lo = mid + 1;
            }
            else{
                a1 = Math.min(a1, mid);
                a2 = Math.max(a2, mid);
                helper(nums, target, lo, mid - 1);
                helper(nums, target, mid + 1, hi);
                break;
            }
        }
    }
}