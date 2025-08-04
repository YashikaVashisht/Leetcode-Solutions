#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static bool cmp(pair<int,int> a, pair<int,int> b) {
        return (a.first + a.second) < (b.first + b.second);
    }

    int helper(const vector<pair<int,int>>& vec, int minTime) {
        int res = INT_MAX;
        for (int i = 0; i < vec.size(); i++) {
            int start = max(vec[i].first, minTime);
            int dur = start + vec[i].second;
            res = min(res, dur);
        }
        return res;
    }

    int earliestFinishTime(vector<int>& landStartTime, vector<int>& landDuration,
                           vector<int>& waterStartTime, vector<int>& waterDuration) {
        int n = landStartTime.size();
        int m = waterStartTime.size();

        vector<pair<int,int>> land, water;
        for (int i = 0; i < n; i++) {
            land.push_back({landStartTime[i], landDuration[i]});
        }
        for (int i = 0; i < m; i++) { // ✅ fixed m instead of n
            water.push_back({waterStartTime[i], waterDuration[i]});
        }

        sort(land.begin(), land.end(), cmp);
        sort(water.begin(), water.end(), cmp);

        int min1 = land[0].first + land[0].second;
        int time1 = helper(water, min1);

        int min2 = water[0].first + water[0].second; // ✅ fixed syntax
        int time2 = helper(land, min2);

        return min(time1, time2); // ✅ choose the earliest finish
    }
};
