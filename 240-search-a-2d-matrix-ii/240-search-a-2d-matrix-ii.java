class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            for(int j=matrix[0].length - 1; j>=0; j--){
                if(matrix[i][j] == target){
                    return true;
                }
                if(matrix[i][j] < target){
                    break;
                }
                
            }
        }
        return false;
    }
}