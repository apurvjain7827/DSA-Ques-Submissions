class Solution {
    public class pair{
        int r;
        int c;
        pair(){}
        pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public boolean isValid(int i, int j, int[][] grid){
        if(i < 0 || j<0 || i>=grid.length || j>=grid[0].length){
            return false;
        }
        if(grid[i][j] == 1)
            return true;
        return false;
    }
    
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int orangesRotting(int[][] grid) {
        Queue<pair> qu = new LinkedList<>();
        
        int freshOranges = 0;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    qu.add(new pair(i, j));
                }
                if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges == 0){
            return 0;
        }
            
        
        int time = 0;
        while(qu.size() != 0){
            if(freshOranges == 0){
                return time;
            }
            int size = qu.size();
            while(size-- > 0){
                pair rem = qu.remove();
                for(int i=0; i<dir.length; i++){
                    int r = rem.r + dir[i][0];
                    int c = rem.c + dir[i][1];
                    if(isValid(r, c, grid)){
                        grid[r][c] = 2;
                        freshOranges--;
                        qu.add(new pair(r, c));
                    }
                }
            }
            time++;
        }
        
        
        return freshOranges != 0 ? -1 : time;
    }
}