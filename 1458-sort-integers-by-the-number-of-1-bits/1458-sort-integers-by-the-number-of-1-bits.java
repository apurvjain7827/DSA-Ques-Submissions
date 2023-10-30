class Solution {
    public class pair{
        int num;
        int no1;
        pair(){}
        pair(int num, int no1){
            this.num = num;
            this.no1 = no1;
        }
    }
    public int[] sortByBits(int[] arr) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
            if(a.no1 == b.no1){
                return a.num - b.num;
            }
            return a.no1 - b.no1;
        });

        for(int val : arr){
            int cnt = 0;
            for(int i=0; i<32; i++){
                int bit = ((1<<i) & val) == 0 ? 0 : 1;
                if(bit == 1){
                    cnt++;
                }
            }
            pq.add(new pair(val, cnt));
        }

        int[] ans = new int[arr.length];
        int ind = 0;
        while(pq.size() != 0){
            pair rem = pq.remove();
            ans[ind++] = rem.num;
        }

        return ans;
    }
}