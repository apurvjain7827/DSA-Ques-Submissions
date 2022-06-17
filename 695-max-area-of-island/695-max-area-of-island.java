class Solution {
    public static int area;
    public static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    public void getArea(int[][] grid, int i, int j){
        grid[i][j] = 0;
        area++;
        int n = grid.length;
        int m = grid[0].length;
        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            if(r>=0 && r<n && c>=0 && c<m && grid[r][c] == 1){
                getArea(grid, r, c);
            }
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    area = 0;
                    getArea(grid, i, j);
                    if(area>ans){
                        ans = area;
                    }
                }
            }
        }
        return ans;
    }
}