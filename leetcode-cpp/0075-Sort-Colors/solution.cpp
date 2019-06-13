#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    // 计数排序
    void sortColors(vector<int>& nums) {
        int count[3] = {0, 0, 0}; 

        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            count[num]++;
        }

        int p = 0;
        for (int i = 0; i < 3; i++) {
            int ci = count[i];
            int val = i;
            for (int j = 0; j < ci; j++) {
                nums[p] = val;
                p++;
            }
        }
    }

    // 三路快排
    void sortColorsV2(vector<int>& nums) {
        int p0 = -1;
        int idx = 0;
        int p2 = nums.size() - 1;

        while (idx <= p2) {
            if (nums[idx] == 2) {
                swap(nums[idx], nums[p2]);
                p2 -= 1;
            } else if (nums[idx] == 0) {
                swap(nums[idx], nums[p0 + 1]);
                idx += 1;
                p0 += 1;
            } else {
                idx += 1;
            }
        }
    }
};


int main(void) {

    int arr[6] = {2, 0, 2, 1, 1, 0};
    // vector<int> res(begin(arr), end(arr));
    vector<int> nums(begin(arr), end(arr));

    Solution obj;
    obj.sortColorsV2(nums);

    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i] << " ";
    }
    cout << endl;

    return 0;
}