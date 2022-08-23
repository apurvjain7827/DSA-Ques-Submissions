class Solution {
    public class pair{
        int r;
        int c;
        int d;
        pair(){}
        pair(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    
    public boolean inRange(int i, int j, int[][] mat, boolean[][] vis){
        if(i<0 || j<0 || i>= mat.length || j >= mat[0].length || vis[i][j]){
            return false;
        }
        return true;
    }
    
    public int[][] updateMatrix(int[][] mat) {
        Queue<pair> qu = new LinkedList<>();
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 0){
                    qu.add(new pair(i, j, 0));
                }
            }
        }
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        int[][] ret = new int[mat.length][mat[0].length];
        while(qu.size() != 0){
            pair rem = qu.remove();
            if(mat[rem.r][rem.c] == 1 && ret[rem.r][rem.c] == 0){
                ret[rem.r][rem.c] = rem.d;
            }
            vis[rem.r][rem.c] = true;
            if(inRange(rem.r-1, rem.c, mat, vis))
                qu.add(new pair(rem.r-1, rem.c, rem.d+1));
            if(inRange(rem.r, rem.c+1, mat, vis))
                qu.add(new pair(rem.r, rem.c+1, rem.d+1));
            if(inRange(rem.r+1, rem.c, mat, vis))
                qu.add(new pair(rem.r+1, rem.c, rem.d+1));
            if(inRange(rem.r, rem.c-1, mat, vis))
                qu.add(new pair(rem.r, rem.c-1, rem.d+1));
        }
        return ret;
    }
}