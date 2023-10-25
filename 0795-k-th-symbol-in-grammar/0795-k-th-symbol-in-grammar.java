class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1){
            return 0;
        }

        // k--;

        int bit = -1;
        if(k % 2 != 0){
            bit = kthGrammar(n-1, (k+1)/2);
            return bit;
        }
        else{
            bit = kthGrammar(n-1, k/2);
            return 1 - bit;
        }

    }
}