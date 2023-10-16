class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0){
            List<Integer> base = new ArrayList<>();
            base.add(1);
            return base;
        }

        // List<Integer> ra = getRow(rowIndex - 1);

        // List<Integer> base = new ArrayList<>();
        // base.add(1);
        // int i=0;
        // while(i+1<ra.size()){
        //     int sum = ra.get(i) + ra.get(i + 1);
        //     base.add(sum);
        // }

        // base.add(1);

        // return base;
        

        List<Integer> base = new ArrayList<>();
        base.add(1);
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        // int[][] dp = new int[10][10];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        // for(int i=0; i<5; i++){
        //     for(int j=0; j<=i; j++){
        //         System.out.print(val(i, j, dp) + " ");
        //     }
        //     System.out.println();
        // }

        for(int j=1; j<rowIndex; j++){
            base.add(val(rowIndex-1, j-1, dp) + val(rowIndex-1, j, dp));
        }

        base.add(1);
        return base;
    }

    public int val(int row, int col, int[][] dp){
        if(col == 0 || col == row){
            return 1;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        return dp[row][col] = val(row-1, col-1, dp) + val(row-1, col, dp);

        // return dp[row][col] = dp[row-1][col-1] + dp[row-1][col];
    }
}