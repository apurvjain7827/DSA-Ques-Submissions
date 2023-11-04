class Solution {
    public class pair{
        int pos;
        int dir;
        int tsf;
        pair(){}
        pair(int pos, int dir, int tsf){
            this.pos = pos;
            this.dir = dir;
            this.tsf = tsf;
        }
    }
    public int getLastMoment(int n, int[] left, int[] right) {
        // Stack<pair> st = new Stack<>();
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        for(int val : left){
            arr[val] = 0;
        }

        for(int val : right){
            arr[val] = 1;
        }

        // int ans = 0;

        // for(int i=0; i<arr.length; i++){
        //     if(arr[i] == 1){
        //         st.push(new pair(i, 1, 0));
        //     }
        //     else if(arr[i] == 0){
        //         System.out.println(i);
        //         Stack<pair> st2 = new Stack<>();
        //         pair pres = new pair(i, 0, 0);
        //         while(st.size() != 0){
        //             pair rem = st.pop();
        //             System.out.println("pres 1 " + pres.pos + " " + pres.dir + " " + pres.tsf);
        //             System.out.println("rem 1 " + rem.pos + " " + rem.dir + " " + rem.tsf);
        //             int at = pres.pos - rem.pos;
        //             pres.tsf += at;
        //             pres.dir = 1 - pres.dir;
        //             st2.push(new pair(pres.pos, pres.dir, pres.tsf));
        //             rem.tsf += at;
        //             rem.dir = 1 - rem.dir;
        //             System.out.println("pres 2 " + pres.pos + " " + pres.dir + " " + pres.tsf);
        //             System.out.println("rem 2 " + rem.pos + " " + rem.dir + " " + rem.tsf);
        //             pres = rem;
        //         }

        //         while(st2.size() != 0){
        //             st.push(st2.pop());
        //         }

        //         int time = pres.pos + pres.tsf;
        //         ans = Math.max(ans, time);
        //     }
        // }

        // while(st.size() != 0){
        //     pair rem = st.pop();
        //     int max = n - rem.pos + rem.tsf;
        //     ans = Math.max(max, ans);
        // }

        // return ans;
        // ans = 0;


        return helper(0, n, arr);
    }

    int ans;
    public int helper(int i, int j, int[] arr){
        if(i > j){
            return 0;
        }
        else if(i == j){
            int n = arr.length - 1;
            if(arr[i] == 0){
                return i;
            }
            else if(arr[i] == 1){
                return n - i;
            }
            else{
                return 0;
            }
        }
        else if(arr[i] == -1){
            return helper(i+1, j, arr);
        }
        else if(arr[j] == -1){
            return helper(i, j-1, arr);
        }
        else if(arr[i] == 0){
            int ra = helper(i+1, j, arr);
            return Math.max(ra, i);
        }
        else if(arr[j] == 1){
            int ra = helper(i, j-1, arr);
            int n = arr.length - 1;
            return Math.max(ra, n - j);
        }
        else{
            int ra = helper(i+1, j-1, arr);
            int tsf = j - i;
            int n = arr.length - 1;
            int at = Math.max(n - j, i);
            return Math.max(tsf + at, ra);
        }
    }
}