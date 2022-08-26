class Solution {
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public boolean inRange(int i, int j, int[][] grid, boolean[][] vis){
        if(i<0 || j<0 || i>= grid.length || j>=grid[0].length || vis[i][j]){
            return false;
        }
        return true;
    }
    
    public class pair{
        int i;
        int j;
        pair(){}
        pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int[][] arr = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                arr[i][j] = grid[i][j];
            }
        }
        ArrayList<pair> list = new ArrayList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        dfs(row, col, list, grid, vis, color);
        for(pair p : list){
            func(p.i, p.j, arr, grid, color);
        }
        return arr;
    }
    
    public void dfs(int i, int j, ArrayList<pair> list, int[][] ogrid, boolean[][] vis, int col){
        vis[i][j] = true;
        // func(i, j, mygrid, ogrid,col);
        list.add(new pair(i, j));
        for(int[] arr : dir){
            int r = i + arr[0];
            int c = j + arr[1];
            if(inRange(r, c, ogrid, vis) && ogrid[i][j] == ogrid[r][c])
                dfs(r, c, list, ogrid, vis, col);
        }
    }
    
    
    
    public void func(int i, int j, int[][] mygrid, int[][] ogrid, int col){
        boolean state = true;
        for(int[] arr : dir){
            int r = i + arr[0];
            int c = j + arr[1];
            if(r<0 || c<0 || r>= ogrid.length || c>=ogrid[0].length){
                state = false;
                break;
            }
            else if(ogrid[i][j] != ogrid[r][c]){
                state = false;
                break;
            }
        }
        if(state == false){
            mygrid[i][j] = col;
        }
    }
}