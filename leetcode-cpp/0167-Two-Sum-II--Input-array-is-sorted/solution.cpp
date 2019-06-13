#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int len = nums.size();
        int l = 0;
        int r = len - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < target) {
                l += 1;
            } else if (sum > target) {
                r -= 1;
            }
            else {
                return {l + 1, r + 1};
            }
        }

        return {};
    }
};


int main(void) {

    return 0;
}
