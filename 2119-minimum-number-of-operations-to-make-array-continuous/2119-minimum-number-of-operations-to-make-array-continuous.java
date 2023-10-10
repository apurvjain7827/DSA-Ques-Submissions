class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int min = nums.length;
        int n = nums.length;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while(j < i && nums[i] - nums[j] > n-1){
                map.put(nums[j], map.get(nums[j]) - 1);
                if(map.get(nums[j]) == 0){
                    map.remove(nums[j]);
                }
                j++;
            }
            if(nums[i] - nums[j] <= n-1){
                int len = map.size();
                min = Math.min(min, n - len);
            }
        }

        return min;
    }
}