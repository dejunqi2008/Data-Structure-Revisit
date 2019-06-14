#include <iostream>
#include <vector>
#include <set>

using namespace std;


class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        set<int> record(nums1.begin(), nums1.end());
        vector<int> res;
        // for (int i = 0; i < nums1.size(); i++) {
        //     record.insert(nums1[i]);
        // }

        for (int i = 0; i < nums2.size(); i++) {
            int val = nums2[i];
            if (record.find(val) != record.end()) {
                res.push_back(val);
                record.erase(val);
            }
        }

        return res;
    }
};

int main(void) {

    return 0;
}
