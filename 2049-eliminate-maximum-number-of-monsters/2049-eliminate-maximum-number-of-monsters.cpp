class Solution {
public:
    int eliminateMaximum(vector<int>& dist, vector<int>& speed) {
        priority_queue<double, vector<double>, greater<double>> pq;
        
        for (int i = 0; i < dist.size(); i++) {
            pq.push(static_cast<double>(dist[i]) / speed[i]);
        }

        double ct = 0;
        int cnt = 0;

        while (!pq.empty()) {
            double rem = pq.top();
            pq.pop();
            
            if (rem <= ct) {
                break;
            }
            
            ct++;
            cnt++;
        }

        return cnt;
    }
};