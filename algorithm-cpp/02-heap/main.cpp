
#include <iostream>
#include <algorithm>
#include <cassert>
// #include "../01-sorting/SortTestHelper.h"
#include "MaxHeap.h"


using namespace std;


int main(void) {
    // MaxHeap<int> maxheap = MaxHeap<int>(100);
    
    srand(time(NULL));
    // for (int i = 0; i < 15; i++) {
    //     int num = 0;
    //     while (num == 0) {
    //       num = rand() % 100 + 1;
    //     }
    //     maxheap.insert(num);
    // }

    // maxheap.printData();
    // cout << endl;
    // while (!maxheap.isEmpty()) {
    //     int d = maxheap.pop();
    // }

    int arr[10];
    for (int i = 0; i < 10; i++) {
        arr[i] = rand() % 100 + 1;
    }

    MaxHeap<int> maxheap = MaxHeap<int>(arr, 10);

    // delete [] arr;
    while (!maxheap.isEmpty()) {
        int d = maxheap.pop();
    }

    return 0;
}
