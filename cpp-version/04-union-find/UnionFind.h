#ifndef UNION_FIND_H
#define UNION_FIND_H

using namespace std;

template <typename T>
class UnionFind {
private:
    int* ids;
    int count;


public:
    UnionFind(int n) {
        count = n;
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    ~UnionFind() {
        delete [] ids;
    }

    int findRoot(int p) {
        while (p != ids[p]) {
            ids[p] = ids[ids[p]];
            p = ids[p];
        }
        return p;
    }

    void quickUnion(int p, int q) {
        int rp = findRoot(p);
        int rq = findRoot(q);
        if (rp == rq) {
            return;
        }

        if (rp < rq) {
            ids[rq] = rp;
        } else {
            ids[rp] = rq;
        }
    }

    bool isConnected(int p, int q) {
        assert(p >= 0 && p < count && q >= 0 && q < count);
        return findRoot(p) == findRoot(q);
    }
};


#endif