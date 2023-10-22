class Solution {
    public int maximumScore(int[] nums, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b)->{
            return a.get(0) - b.get(0);
        });

        for(int i=0; i<nums.length; i++){
            List<Integer> li = new ArrayList<>();
            li.add(nums[i]);
            li.add(i);
            pq.add(li);
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int ans = 0;

        while(pq.size() != 0){
            List<Integer> rem = pq.remove();
            int ind = rem.get(1);
            int min = rem.get(0);
            Integer prev = map.floorKey(ind);
            Integer next = map.ceilingKey(ind);

            if(prev == null){
                prev = -1;
            }
            if(next == null){
                next = nums.length;
            }

            // System.out.println(prev + " " + next + " " + ind);

            int cnt = (ind - prev) + (next - ind) - 1;

            if(prev < k && k < next){
                ans = Math.max(ans, min * cnt);
            }

            

            map.put(ind, 1);
        }

        return ans;
    }
}