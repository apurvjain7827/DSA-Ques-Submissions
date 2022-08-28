class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for(int i = mat.length-1; i>=0; i--){
            int r = i;
            int c = 0;
            ArrayList<Integer> al = new ArrayList<>();
            while(r < mat.length && c < mat[0].length){
                al.add(mat[r][c]);
                r++;
                c++;
            }
            int[] arr = helper(al);
            
            r = i;
            c = 0;
            int idx = 0;
            while(r < mat.length && c < mat[0].length && idx < arr.length){
                mat[r][c] = arr[idx];
                idx++;
                r++;
                c++;
            }
        }
        
        
        for(int j = 1; j<mat[0].length; j++){
            int r = 0;
            int c = j;
            ArrayList<Integer> al = new ArrayList<>();
            while(r < mat.length && c < mat[0].length){
                al.add(mat[r][c]);
                r++;
                c++;
            }
            int[] arr = helper(al);
            
            r = 0;
            c = j;
            int idx = 0;
            while(r < mat.length && c < mat[0].length && idx < arr.length){
                mat[r][c] = arr[idx];
                idx++;
                r++;
                c++;
            }
        }
        return mat;
    }
    
    public int[] helper(ArrayList<Integer> al){
        // Collections.reverse(al);
        int[] arr = new int[al.size()];
        
        for(int i=0; i<arr.length; i++){
            arr[i] = al.get(i);
        }
        Arrays.sort(arr);
        return arr;
    }
}