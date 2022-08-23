class Solution {
    public class pair{
        int r;
        int c; 
        int dis;
        pair(){}
        pair(int r, int c, int dis){
            this.r = r;
            this.c = c;
            this. dis = dis;
        }
    }
    
    public boolean inRange(int i, int j, boolean[][] vis){
        if(i<0 || j<0 || i>= vis.length || j >= vis[0].length || vis[i][j])
            return false;
        return true;
    }
    
    public int maxDistance(int[][] grid) {
        
        Queue<pair> qu = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    qu.add(new pair(i, j, 0));
                    // vis[i][j] = true;
                }
            }
        }
        if(qu.size() == grid.length * grid[0].length)
            return -1;
        
        int max = -1;
        while(qu.size() != 0){
            pair rem = qu.remove();
            if(vis[rem.r][rem.c])
                continue;
            vis[rem.r][rem.c] = true;
            max = Math.max(max, rem.dis);
            if(inRange(rem.r-1, rem.c, vis))
                qu.add(new pair(rem.r-1, rem.c, rem.dis+1));
            if(inRange(rem.r+1, rem.c, vis))
                qu.add(new pair(rem.r+1, rem.c, rem.dis+1));
            if(inRange(rem.r, rem.c-1, vis))
                qu.add(new pair(rem.r, rem.c-1, rem.dis+1));
            if(inRange(rem.r, rem.c+1, vis))
                qu.add(new pair(rem.r, rem.c+1, rem.dis+1));
        }
        return max;
    }
}