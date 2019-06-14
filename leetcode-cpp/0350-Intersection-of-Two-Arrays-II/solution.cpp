#include <iostream>
#include <vector>
#include <unordered_map>


using namespace std;

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> dic;
        vector<int> res;
        for (int i = 0; i < nums1.size(); i++) {
            int val = nums1[i];
            if (dic.find(val) == dic.end()) {
                dic[val] = 1;
            } else {
                dic[val] += 1;
            }
        }

        for (int i = 0; i < nums2.size(); i++) {
            int val = nums2[i];
            if (dic.find(val) != dic.end() && dic[val] > 0) {
                res.push_back(val);
                dic[val] -= 1;
            }
        }

        return res;
    }
};


int main(void) {
    /*
    int arr[] = {2, 3, 1, 2, 4, 3};
    vector<int> nums(begin(arr), end(arr));
    */
    int arr1[] = {4, 9, 5};
    int arr2[] = {9, 4, 9, 8, 4};
    vector<int> nums1(begin(arr1), end(arr1));
    vector<int> nums2(begin(arr2), end(arr2));

    Solution obj;
    vector<int> res = obj.intersect(nums1, nums2);

    for (int i = 0; i < res.size(); i++) {
        cout << res[i] << " ";
    }
    cout << endl;
    return 0;
}
