class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele : nums){
            pq.add(ele);
        }
        int count = 0;
        int ans = 0;
        while(pq.size() != 0){
            int rem = pq.remove();
            if(pq.size() != 0 && pq.peek() == rem){
                continue;
            }
            else if(pq.size() != 0 && pq.peek() == (rem + 1)){
                count++;
            }
            else{
                count++;
                if(count > ans){
                    ans = count;
                }
                count = 0;
            }
        }
        return ans;
    }
}