class Solution {
    int num = 0;
    public int romanToInt(String s) {
        int i = 0;
        num = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(i == s.length() - 1){
                helper(ch);
                i++;
                continue;
            }
            char nch = s.charAt(i + 1);
            if(nch == 'M' && ch == 'C'){
                num -= 100;
                helper(nch);
                i = i+2;
                continue;
            }
            if(nch == 'D' && ch == 'C'){
                num -= 100;
                helper(nch);
                i = i+2;
                continue;
            }
            if(nch == 'L' && ch == 'X'){
                num -= 10;
                helper(nch);
                i = i+2;
                continue;
            }
            if(nch == 'C' && ch == 'X'){
                num -= 10;
                helper(nch);
                i = i+2;
                continue;
            }
            if(nch == 'V' && ch == 'I'){
                num -= 1;
                helper(nch);
                i = i+2;
                continue;
            }
            if(nch == 'X' && ch == 'I'){
                num -= 1;
                helper(nch);
                i = i+2;
                continue;
            }
            helper(ch);
            i++;
        }
        return num;
    }
    public void helper(char sym){
        if(sym == 'I'){
            num += 1;
        }
        else if(sym == 'V'){
            num += 5;
        }
        else if(sym == 'X'){
            num += 10;
        }
        else if(sym == 'L'){
            num += 50;
        }
        else if(sym == 'C'){
            num += 100;
        }
        else if(sym == 'D'){
            num += 500;
        }
        else if(sym == 'M'){
            num += 1000;
        }
    }
}