class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        mod = 1000000007;
        HashSet<Integer> set = new HashSet<>();
        for(int ele : arr){
            set.add(ele);
        }

        HashMap<Integer, Long> dp = new HashMap<>();

        long ans = 0;
        for(int ele : arr){
            ans = (ans + helper(ele, set, dp));
        }

        return (int)(ans%mod);
    }

    int mod;

    public long helper(int req, HashSet<Integer> set, HashMap<Integer, Long> dp){
        if(set.contains(req) == false){
            return 0;
        }

        if(dp.containsKey(req)){
            return dp.get(req);
        }

        long ans = 0;

        for(int ele : set){
            if(ele >= req){
                continue;
            }

            int e2 = req / ele;
            if((ele * e2)%mod != req){
                continue;
            }

            long c1 = helper(ele, set, dp);
            long c2 = helper(e2, set, dp);

            ans = ans + (c1 * c2);
            // if(ele != e2){
            //     ans = (ans + (c1 * c2)) % mod;
            // }
        }

        ans = (ans + 1);

        dp.put(req, ans);
        return ans;
    }
}