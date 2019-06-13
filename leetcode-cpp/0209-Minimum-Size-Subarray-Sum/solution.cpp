#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int len = nums.size();
        int res = len + 1;
        while (j < len) {
            while (j < len && sum < s) {
                sum += nums[j];
                j += 1;
            }

            while (i < len && sum >= s) {
                res = min(res, j - i);
                sum -= nums[i];
                i += 1;
            }

        }

        return res < len + 1 ? res : 0;
    }
};


int main(void) {

    int arr[] = {2, 3, 1, 2, 4, 3};
    vector<int> nums(begin(arr), end(arr));

    Solution obj;
    int res = obj.minSubArrayLen(7, nums);

    cout << res << endl;
    return 0;
}
