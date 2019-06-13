#include <unordered_map>
#include <iostream>
#include <vector>
using namespace std;


class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        // vector<int> res;
        unordered_map<int, int> hashmap;
        
        for (int i = 0; i < nums.size(); i++) {
            if (hashmap.count(target - nums[i])) {
                return {hashmap[target - nums[i]], i};
            }
            hashmap[nums[i]] = i;
        }

        return {};
    }
};

int main(void) {

    return 0;
}

