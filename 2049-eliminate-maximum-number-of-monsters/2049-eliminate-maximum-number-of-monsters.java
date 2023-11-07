class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for(int i=0; i<dist.length; i++){
            pq.add(dist[i] * 1.0 / speed[i]);
        }

        double ct = 0;
        int cnt = 0;
        while(pq.size() != 0){
            double rem = pq.remove();
            if(rem <= ct){
                break;
            }
            ct++;
            cnt++;
        }

        return cnt;
    }
}