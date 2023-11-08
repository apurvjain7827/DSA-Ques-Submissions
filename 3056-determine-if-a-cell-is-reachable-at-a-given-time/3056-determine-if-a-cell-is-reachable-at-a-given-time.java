class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx == fx && sy == fy){
            return t != 1;
        }
        // int diff = Math.abs(sx - fx) + Math.abs(sy - fy) - 1;
        int a = Math.abs(sx - fx) + 1;
        int b = Math.abs(sy - fy) + 1;

        int dis = Math.min(a, b);
        dis += Math.max(a, b) - Math.min(a, b);
        dis--;
        return t >= dis;
    }
}