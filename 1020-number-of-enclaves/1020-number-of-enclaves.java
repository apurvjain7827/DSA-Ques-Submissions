class Solution {
    public int count = 0;
    public int numEnclaves(int[][] grid) {
        // int count = 0;
        for(int i=0; i<grid.length; i++){
            if(grid[i][0] == 1){
                traverse(i, 0, grid);
            }
        }
        for(int i=0; i<grid.length; i++){
            if(grid[i][grid[0].length - 1] == 1){
                traverse(i, grid[0].length - 1, grid);
            }
        }
        for(int j=0; j<grid[0].length; j++){
            if(grid[0][j] == 1){
                traverse(0, j, grid);
            }
        }
        for(int j=0; j<grid[0].length; j++){
            if(grid[grid.length - 1][j] == 1){
                traverse(grid.length - 1, j, grid);
            }
        }
        
        count = 0;
        
        for(int i=1; i<grid.length - 1; i++){
            for(int j=1; j < grid[0].length - 1; j++){
                if(grid[i][j] == 1){
                    count++;
                    // traverse(i, j, grid);
                }
            }
        }
        return count;
    }
    
    public void traverse(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }
        if(grid[i][j] == 0){
            return;
        }
        
        grid[i][j] = 0;
        
        count++;
        
        traverse(i+1, j, grid);
        traverse(i-1, j, grid);
        traverse(i, j+1, grid);
        traverse(i, j-1, grid);
    }
}