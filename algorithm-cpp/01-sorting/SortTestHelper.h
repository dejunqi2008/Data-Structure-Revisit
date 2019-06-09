#ifndef SORT_TEST_HELPER_H
#define SORT_TEST_HELPER_H

#include <iostream>
#include <ctime>
#include <cassert>
#include <string>

using namespace std;

namespace SortTestHelper {

    // 生成n各元素的随机数组, 每个随机范围在 [rangeL, rangeR]内
    int *generateRandomArray(int n, int rangeL, int rangeR) {
        assert(rangeL <= rangeR);
        int *arr = new int[n];
        // 随机种子设置
        srand(time(NULL));
        for (int i = 0; i < n; i++) {
            arr[i] = rand() % (rangeR - rangeL + 1) + rangeL;
        }

        return arr;
    }

    int *generateNearlyOrderedArray(int n, int swapTimes) {
        int *arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < swapTimes; i++) {
            int px = rand() % n;
            int py = rand() % n;
            swap(arr[px], arr[py]);
        }
        return arr;
    }

    template<typename T>
    void printArray(T arr[], int n) {
        int k = 0;
        if (n >= 100) {
            k = 20;
        }
        for (int i = 0; i < n; i++) {
            cout << arr[i] << " ";
            if (k > 0 && i % k == 0) {
                cout << endl;
            } 
        }
        cout << endl;
    }

    template<typename T>
    bool isSorted(T arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // void(*sort)(T[], int) -- void 是返回值, *sort 是函数指针, (T[], int)是指针所指向的函数的参数
    template<typename T>
    void testSort(string algorithmName, void(*sort)(T[], int), T arr[], int n) {
        clock_t startTime = clock();
        sort(arr, n);
        clock_t endTime = clock();
        assert(isSorted(arr, n));
        cout << algorithmName << " : " << double(endTime - startTime) / CLOCKS_PER_SEC << " s" << endl;
        return;
    }


    int* copyIntArray(int a[], int n) {
        int *arr = new int[n];
        copy(a, a + n, arr);
        return arr;
    }
}



#endif