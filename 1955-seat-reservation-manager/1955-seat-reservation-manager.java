class SeatManager {
    TreeMap<Integer, Integer> map;

    public SeatManager(int n) {
        map = new TreeMap<>();
        for(int i=1; i<=n; i++){
            map.put(i, 0);
        }
    }
    
    public int reserve() {
        int rem = map.firstKey();
        map.remove(rem);
        return rem;
    }
    
    public void unreserve(int seatNumber) {
        map.put(seatNumber, 0);
        // map.remove(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */