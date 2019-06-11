#include <iostream>
#include "Student.h"
#include "SortTestHelper.h"
#include "SortingAlgorithm.h"


using namespace std;



void test01() {
    int n = 50000;
    Sorting<int> sort;
    int * arr1 = SortTestHelper::generateRandomArray(n, 0, n);
    int * arr2 = SortTestHelper::copyIntArray(arr1, n);
    int * arr3 = SortTestHelper::copyIntArray(arr1, n);
    SortTestHelper::testSort("Selection Sort", &sort.selectionSort, arr1, n);
    SortTestHelper::testSort("Insertion Sort", &sort.insertionSort, arr2, n);
    SortTestHelper::testSort("Merge Sort", &sort.mergeSort, arr3, n);
    
    delete[] arr1;
    delete[] arr2;
    delete[] arr3;

}

void test02() {
    Student d[4] = {
        {"D", 90}, {"C", 100}, {"B", 95}, {"A", 95}
    };
    Sorting<Student> sort;
    sort.selectionSort(d, 4);
    for (int i = 0; i < 4; i++) {
        cout << d[i];
    }
    cout << endl;
}



int main(void) {
    test01();
    // test02();
    return 0;
}
