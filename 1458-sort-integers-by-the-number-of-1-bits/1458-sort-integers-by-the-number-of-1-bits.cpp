class Solution {
public:
    struct Pair {
        int num;
        int no1;

        Pair(int num, int no1) : num(num), no1(no1) {}
        
        bool operator>(const Pair& other) const {
            if (no1 == other.no1) {
                return num > other.num;
            }
            return no1 > other.no1;
        }
    };

    std::vector<int> sortByBits(std::vector<int>& arr) {
        std::priority_queue<Pair, std::vector<Pair>, std::greater<Pair>> pq;

        for (int val : arr) {
            int cnt = 0;
            for (int i = 0; i < 32; ++i) {
                int bit = ((1 << i) & val) == 0 ? 0 : 1;
                if (bit == 1) {
                    cnt++;
                }
            }
            pq.push(Pair(val, cnt));
        }

        std::vector<int> ans(arr.size());
        int ind = 0;
        while (!pq.empty()) {
            Pair rem = pq.top();
            pq.pop();
            ans[ind++] = rem.num;
        }

        return ans;
    }
};
