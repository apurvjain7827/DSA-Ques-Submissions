class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int ci = 0;
        int cj = 0;

        while(i >= 0 && j >= 0){
            while((i >= 0 && s.charAt(i) == '#') || (j >= 0 && t.charAt(j) == '#')){
                // int cnt = 0;
                while(i >= 0 && s.charAt(i) == '#'){
                    ci++;
                    i--;
                }

                while(i >= 0 && s.charAt(i) != '#' && ci > 0){
                    ci--;
                    i--;
                }

                // cnt = 0;

                while(j >= 0 && t.charAt(j) == '#'){
                    cj++;
                    j--;
                }

                while(j >= 0 && t.charAt(j) != '#' && cj > 0){
                    cj--;
                    j--;
                }
            }

            if(i < 0 || j < 0){
                break;
            }

            if(s.charAt(i) != t.charAt(j)){
                return false;
            }
            i--;
            j--;
        }

        while(i >= 0){
            while(i >= 0 && s.charAt(i) == '#'){
                ci++;
                i--;
            }

            while(i >= 0 && s.charAt(i) != '#' && ci > 0){
                ci--;
                i--;
            }

            if(i >= 0 && s.charAt(i) != '#'){
                break;
            }
        }

        while(j >= 0){
            while(j >= 0 && t.charAt(j) == '#'){
                cj++;
                j--;
            }

            while(j >= 0 && t.charAt(j) != '#' && cj > 0){
                cj--;
                j--;
            }

            if(j >= 0 && t.charAt(j) != '#'){
                break;
            }
        }

        // System.out.println(i + " " + j + " " + ci + " " + cj);

        return i == -1 && j == -1;
    }
}