class Solution {
    //public int count;
    
    public boolean inRange(int i, int j, int dr, int dc){
        if(i<0 || j<0 || i>dr || j>dc)
            return false;
        return true;
    }
    
    public int mazePath(int sr, int sc, int dr, int dc, int[][] dir, int[][] dp){
        if(sr == dr && sc == dc){
            //count ++;
            return dp[sr][sc] = 1;
        }
        if(dp[sr][sc] != 0){
            //count ++;
            return dp[sr][sc];
        }
        int count = 0;
        for(int i = 0; i<dir.length; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(inRange(r,c,dr,dc)){
                count += mazePath(r, c, dr, dc, dir, dp);
            }
        }
        return dp[sr][sc] = count;
    }
        
    public int uniquePaths(int m, int n) {
        //count = 0;
        int[][] dir = {{1,0},{0,1}};
        int[][] dp = new int[m][n];
        
        return mazePath(0,0,m-1,n-1,dir, dp);
    }
}