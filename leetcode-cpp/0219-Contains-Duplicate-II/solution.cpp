#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;


class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_map<int, int> dic;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            if (dic.find(num) != dic.end()) {
                if (abs(i - dic[num]) <= k) {
                    return true;
                }
            } 
            dic[num] = i;
        }

        return false;

    }
};

int main(void) {

    return 0;
}
