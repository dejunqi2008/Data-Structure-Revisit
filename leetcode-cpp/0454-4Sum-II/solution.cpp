#include <iostream>
#include <vector>
#include <unordered_map>


using namespace std;

class Solution {
public:
    int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
        unordered_map<int, int> dic;
        int target = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                int sum = A[i] + B[j];
                if (dic.find(sum) == dic.end()) { // sum not in dic
                    dic[sum] = 1;
                } else {
                    dic[sum] += 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < C.size(); i++) {
            for (int j = 0; j < D.size(); j++) {
                int sum = C[i] + D[j];
                if (dic.find(target - sum) != dic.end()) { // target - sum in dic
                    res += dic[target - sum];
                }
            }
        }

        return res;
    }
};

int main(void) {


    return 0;
}
