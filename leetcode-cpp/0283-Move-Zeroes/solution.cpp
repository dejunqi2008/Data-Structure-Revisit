#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int idx = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != 0) {
                swap(nums[i], nums[idx]);
                idx++;
            }
        }
    }
};

int main(void) {
    int arr[] = {0, 1, 0, 3, 9}; 

    // cout << sizeof(arr) / sizeof(int);
    // vector<int> res(begin(arr), end(arr));
    vector<int> res(arr, arr + sizeof(arr) / sizeof(int));

    Solution so;
    so.moveZeroes(res);

    for (int i = 0; i < res.size(); i++) {
        cout << res[i] << " ";
    }
    cout << endl;

    return 0;
}