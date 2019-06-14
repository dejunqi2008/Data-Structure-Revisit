#include <iostream>
#include <vector>
#include <unordered_map>


using namespace std;

class Solution {
public:
    int numberOfBoomerangs(vector<vector<int>>& points) {
        int res = 0;
        for (int i = 0; i < points.size(); i++) {
            unordered_map<int, int> dic;
            vector<int> pi = points[i];

            for (int j = 0; j < points.size(); j++) {
                if (i == j) {
                    continue;
                }
                vector<int> pj = points[j];
                int a = pi[0] - pj[0];
                int b = pi[1] - pj[1];
                dic[a * a + b * b] += 1;
            }

            for (unordered_map<int, int>::iterator iter = dic.begin(); iter != dic.end(); iter++) {
                int num = iter->second;
                res += num * (num - 1);
            }
        }
        return res;

    }
};

int main(void) {

    vector<vector<int>> points;
    int v1[] = {0, 0};
    int v2[] = {1, 0};
    int v3[] = {2, 0};
    vector<int> ve1(begin(v1), end(v1));
    vector<int> ve2(begin(v2), end(v2));
    vector<int> ve3(begin(v3), end(v3));
    points.push_back(ve1);
    points.push_back(ve2);
    points.push_back(ve3);
    Solution obj;
    int res = obj.numberOfBoomerangs(points);
    cout << res << endl;
    return 0;
}
