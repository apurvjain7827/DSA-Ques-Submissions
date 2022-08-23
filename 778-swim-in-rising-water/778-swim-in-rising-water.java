class Solution {
    public class pair{
        int r; 
        int c;
        int height;
        pair(){}
        pair(int r, int c, int height){
            this.r = r;
            this.c = c;
            this.height = height;
        }
    }
    
    public boolean inRange(int i, int j, boolean[][] grid){
        if(i < 0 || j<0 || i >= grid.length || j >= grid[0].length || grid[i][j])
            return false;
        return true;
    }
    
    public int swimInWater(int[][] grid) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> {
            return a.height - b.height;
        });
        pq.add(new pair(0, 0, grid[0][0]));
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        while(pq.size() != 0){
            pair rem = pq.remove();
            if(vis[rem.r][rem.c])
                continue;
            vis[rem.r][rem.c] = true;
            
            if(rem.r == grid.length-1 && rem.c == grid[0].length - 1){
                return Math.max(rem.height, grid[rem.r][rem.c]);
            }
            int i = rem.r;
            int j = rem.c;
            
            if(inRange(i+1, j, vis))
                pq.add(new pair(i+1, j, Math.max(rem.height, grid[i+1][j])));
            if(inRange(i-1, j, vis))
                pq.add(new pair(i-1, j, Math.max(rem.height, grid[i-1][j])));
            if(inRange(i, j+1, vis))
                pq.add(new pair(i, j+1, Math.max(rem.height, grid[i][j+1])));
            if(inRange(i, j-1, vis))
                pq.add(new pair(i, j-1, Math.max(rem.height, grid[i][j-1])));
            
        }
        return -1;
    }
}