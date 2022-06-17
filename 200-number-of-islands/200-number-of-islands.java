class Solution {
    public int count;
    
    public void func(char[][] grid, int n, int m, boolean[][] vis){
        vis[n][m] = true;
        int r = grid.length;
        int c = grid[0].length;
        
        if(n-1 >= 0 && !vis[n-1][m] && grid[n-1][m] == '1')
        func(grid, n-1, m, vis);
        
        if(m+1 < c && !vis[n][m+1] && grid[n][m+1] == '1')
        func(grid, n, m+1, vis);
        
        if(n+1 < r && !vis[n+1][m] && grid[n+1][m] == '1')
        func(grid, n+1, m, vis);
        
        if(m-1 >= 0 && !vis[n][m-1] && grid[n][m-1] == '1')
        func(grid, n, m-1, vis);
        
    }
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int n = grid.length;
        int m = grid[0].length;
        count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    func(grid, i, j, vis);
                    count++;
                }
                
            }
        }
        return count;
    }
}