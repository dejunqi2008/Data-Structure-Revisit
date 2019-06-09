#ifndef SORTING_ALGORITHM_H
#define SORTING_ALGORITHM_H


// namespace Sorting {


// 使用类模板
template<class T>
class Sorting {
public:
    static void selectionSort(T arr[], int n);
    static void insertionSort(T arr[], int n);
    static void mergeSort(T arr[], int n);
private:
    static void mergeSortHelper(T arr[], int l, int r);
    static void mergeSortHelperIterative(T arr[], int n);
    static void merge(T arr[], int l, int mid, int r);
};



/* *********************** class method implementation ************************* */

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
        T e = arr[i];
        int j;
        for (j = i; j > 0; j--) {
            if (arr[j - 1] > e) {
                arr[j] = arr[j - 1];
            } else {
                break;
            }
        }
        arr[j] = e;
    }
}

// 归并排序
template<class T>
void Sorting<T>::mergeSort(T arr[], int n) {
    // mergeSortHelper(arr, 0, n - 1);
    mergeSortHelperIterative(arr, n);
}


template<class T>
void Sorting<T>::mergeSortHelper(T arr[], int l, int r) {
    if (l >= r)  {
        return;
    }

    int mid = l + (r - l) / 2;
    mergeSortHelper(arr, l, mid);
    mergeSortHelper(arr, mid + 1, r);

    if (arr[mid] <= arr[mid + 1]) {
        return;
    }

    merge(arr, l, mid, r);
}


template<class T>
void Sorting<T>::mergeSortHelperIterative(T arr[], int n) {
    int window = 1;
    while (window <= n) {

        int i = 0;
        while (i + window < n) {
            int l = i;
            int mid = i + window - 1;
            int r = i + 2 * window - 1;
            merge(arr, l, mid, min(r, n - 1));
            
            i += 2 * window;
        }

        window *= 2;
    }
}


template<class T>
void Sorting<T>::merge(T arr[], int l, int mid, int r) {
    // if (l >= r) return;
    T tmp[r - mid];
    for (int k = mid + 1; k <= r; k++) {
        tmp[k - mid - 1] = arr[k];
    }
    int idx = r;
    int i = mid;
    int j = r - mid - 1;

    while (i >= l && j >= 0) {
        if (arr[i] > tmp[j]) {
            arr[idx] = arr[i];
            i--;
        } else {
            arr[idx] = tmp[j];
            j--;
        }
        idx--;
    }

    while (j >= 0) {
        arr[idx] = tmp[j];
        j--;
        idx--;
    }
}



#endif