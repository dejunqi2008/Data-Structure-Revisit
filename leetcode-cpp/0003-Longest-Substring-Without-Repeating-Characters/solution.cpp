#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        unordered_map<char, int> dic;
        int n = s.size();
        if (n == 0) return 0;
        int i = 0, j = 0, res = 0;
        while (j < n) {
            char c = s[j];
            if (dic.count(c) && i <= dic[c]) {
                res = max(res, j - i);
                i = dic[c] + 1;
            }
            dic[c] = j;
            j += 1;
        }
        return max(res, j - i);
    }
};

int main(void) {
    string s = "abcabcbb";
    // cout << s.size() << endl;
    Solution obj;
    cout << obj.lengthOfLongestSubstring(s) << endl;
    return 0;
}
