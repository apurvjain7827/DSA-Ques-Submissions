class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        ArrayList<Integer> al = new ArrayList<>();
        Arrays.sort(tokens);
        for(int ele : tokens){
            al.add(ele);
        }
        
        int score = 0;
        int max = 0;
        
        while(al.size() != 0){
            if(al.get(0) <= power){
                power = power - al.get(0);
                al.remove(0);
                score++;
                max = Math.max(max, score);
            }
            else if(score > 0){
                score--;
                power = power + al.get(al.size() - 1);
                al.remove(al.size() - 1);
            }
            else{
                break;
            }
        }
        if(max < 0){
            return 0;
        }
        return max;
    }
}