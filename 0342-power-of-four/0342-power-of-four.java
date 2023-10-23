class Solution {
    public boolean isPowerOfFour(int n) {
        if(n < 0){
            return false;
        }
        if(n == 0){
            return false;
        }
        // int prod = 1;
        // while(prod <= n){
        //     if(prod == n){
        //         return true;
        //     }

        //     prod *= 4;
        // }
        for(int i=0; Math.pow(4, i) <= n; i++){
            if(Math.pow(4, i) == n){
                return true;
            }

            // prod *= 4;
        }

        return false;
    }
}