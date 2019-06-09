#ifndef MAX_HEAP_H
#define MAX_HEAP_H

using namespace std;

template<typename Item>
class MaxHeap {
public:
    MaxHeap(int capacity) {
        data = new Item[capacity];
        cnt = 0;
        this->capacity = capacity;
    }

    // 利用 heapify 初始化的堆 (使用构造函数重载)
    MaxHeap(Item arr[], int n) {
        this->cnt = n;
        this->capacity = n;
        data = new Item[cnt];
        for (int i = 0; i < n; i++) {
            data[i] = arr[i];
        }
        heapify();
    }

    ~MaxHeap() {
        delete [] data;
    }

    int size() {
        return cnt;
    }

    bool isEmpty() {
        return cnt == 0;
    }

    void insert(Item e) {
        assert(size() < capacity);
        data[cnt] = e;
        siftUp(cnt);
        cnt++;
        printData();
    }

    Item pop() {
        assert(size() > 0);
        swap(data[0], data[cnt - 1]);
        Item res = data[cnt - 1];
        cnt--;
        siftDown(0);
        printData();
        return res;
    }

    void heapify() {
        int idx = cnt / 2 - 1;
        for (int i = idx; i >= 0; i--) {
            siftDown(i);
        }
        printData();
    }

    void printData() {
        int k = 0;
        if (cnt >= 100) {
            k = 20;
        }
        for (int i = 0; i < cnt; i++) {
            cout << data[i] << " ";
            if (k > 0 && i % k == 0) {
                cout << endl;
            } 
        }
        cout << endl;
    }

private:
    Item* data;
    int cnt;
    int capacity;

    void siftUp(int k) {
        while (k > 0 && data[parent(k)] < data[k]) {
            int p = parent(k);
            swap(data[p], data[k]);
            k = p;
        }
    }

    void siftDown(int k) {

        while (2 * k + 1 <= cnt - 1) {
            int child = 2 * k + 1;
            if (child < cnt - 1 && data[child] < data[child + 1]) {
                child += 1;
            }
            if (data[k] >= data[child]) break;
            swap(data[k], data[child]);
            k = child;
        }
    }

    int parent(int k) {
        assert(k > 0);
        return (k - 1) / 2;
    }
};

#endif // MAX_HEAP_H