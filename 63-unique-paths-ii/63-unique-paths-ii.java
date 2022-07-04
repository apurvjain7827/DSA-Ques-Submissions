class Solution {
    public boolean inRange(int i, int j, int r, int c){
        if(i<0 || j<0 || i>r || j>c){
            return false;
        }
        return true;
    }
    
    public int mazePath(int sr, int sc, int dr, int dc, int[][] dir, int[][] dp, int[][] obstacleGrid){
        if(sr == dr && sc == dc){
            return dp[sr][sc] = 1;
        }
        if(dp[sr][sc] != 0){
            return dp[sr][sc];
        }
        int count = 0;
        for(int i=0; i<dir.length; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(inRange(r, c, dr, dc) && obstacleGrid[r][c] == 0){
                count += mazePath(r, c, dr, dc, dir, dp, obstacleGrid);
            }
        }
        return dp[sr][sc] = count;
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)
            return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dir = {{1,0},{0,1}};
        int[][] dp = new int[n][m];
        return mazePath(0, 0, n-1, m-1, dir, dp, obstacleGrid);
    }
}