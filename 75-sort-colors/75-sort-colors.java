class Solution {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void sortColors(int[] nums) {
        int a = 0;
        int b = 0; 
        int c = 0;
        for(int ele : nums){
            if(ele == 0)
                a++;
            else if(ele == 1)
                b++;
            else if(ele == 2)
                c++;
        }
        int curr = 0;
        while(curr < nums.length){
            if(a == 0){
                if(nums[curr] == 1){
                    curr++;
                    b--;
                    continue;
                }
                if(nums[curr] == 2){
                    for(int i=curr+1; i<nums.length; i++){
                        if(nums[i] == 1){
                            swap(nums, i, curr);
                            break;
                        }
                    }
                    curr++;
                    b--;
                    continue;
                }
            }
            else{
                if(nums[curr] == 0){
                    curr++;
                    a--;
                    continue;
                }
                else{
                    for(int i=curr+1; i<nums.length; i++){
                        if(nums[i] == 0){
                            swap(nums, i, curr);
                            break;
                        }
                    }
                    curr++;
                    a--;
                    continue;
                }
                
            }
        }
    }
}