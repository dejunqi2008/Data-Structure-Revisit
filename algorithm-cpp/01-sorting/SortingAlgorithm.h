#ifndef SORTING_ALGORITHM_H
#define SORTING_ALGORITHM_H


// namespace Sorting {


// 使用类模板
template<class T>
class Sorting {
public:
    static void selectionSort(T arr[], int n);
    static void insertionSort(T arr[], int n);
};


// 选择排序
template<class T>
void Sorting<T>::selectionSort(T arr[], int n) {
    for (int i = 0; i < n; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }

        swap(arr[i], arr[minIdx]);
    }
}


// 插入排序
template<class T>
void Sorting<T>::insertionSort(T arr[], int n) {

    for (int i = 1; i < n; i++) {
        for (int j = i; i > 0; j--) {
            if (arr[j] < arr[j - 1]) {
                swap( arr[j], arr[j] );
            } else {
                break;
            }
        }
    }
}

#endif