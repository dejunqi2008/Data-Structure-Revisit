#include <iostream>
#include <vector>

using namespace std;

int average(const vector<int> &arr) {
    int sum = 0;
    for (int i = 0; i < arr.size(); i++) {
        sum += arr[i];
    }

    return sum / arr.size();
}


int main() {
    // int n = 20;

    vector<int> arr;
    for (int i = 1; i <= 20; i++) {
        arr.push_back(i);
    }

    for (int i = 0; i < arr.size(); i++) {
        cout << arr[i] << " ";
    }
    cout << endl;

    cout << average(arr) << endl;

    return 0;
}
