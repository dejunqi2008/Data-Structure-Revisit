package segmentTree;

public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Operator<E> operator;

    public SegmentTree(E[] arr, Operator<E> operator) {
        this.operator = operator;
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    public E get(int i) {
        if (i < 0 || i >= data.length) {
            throw new IllegalArgumentException("Index out of list");
        }
        return data[i];
    }

    public int getSize() {return data.length;}

    /**
     * Search segment [left, right]
     * @param left
     * @param right
     * @return
     */
    public E query(int left, int right) {
        if (left < 0 || left >= data.length || right < 0 || right >= data.length || left > right) {
            throw new IllegalArgumentException("Index out of list.");
        }
        return queryHelper(0, 0, data.length - 1, left, right);
    }


    /**
     *  Update the segment tree
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index out of list");
        }
        data[index] = e;
        setHelper(0, 0, data.length - 1, index, e);
    }


    /************************************************************/
    private void  setHelper(int treeIdx, int l, int r, int pos, E e) {
        if (l == r) {
            tree[treeIdx] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftChild = leftChild(treeIdx);
        int rightChild = rightChild(treeIdx);
        if (pos >= mid + 1) {
            setHelper(leftChild, mid + 1, r, pos, e);
        } else {
            setHelper(rightChild, l, mid, pos, e);
        }

        tree[treeIdx] = operator.operate(tree[leftChild], tree[rightChild]);
    }

    private E queryHelper(int index, int l, int r, int segLeft, int segRight) {
        if (l == segLeft && r == segRight) { // we find the segment
            return tree[index];
        }

        int mid = l + (r - l) / 2;
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);
        if (segLeft >= mid + 1) {

            return queryHelper(rightIndex, mid + 1, r, segLeft, segRight);
        } else if (segRight <= mid) {

            return queryHelper(leftIndex, l, mid, segLeft, segRight);
        } else {

            E leftRes = queryHelper(leftIndex, l, mid, segLeft, mid);
            E rightRes = queryHelper(rightIndex, mid + 1, r, mid + 1, segRight);

            return operator.operate(leftRes, rightRes);
        }
    }


    private int leftChild(int idx) {
        return 2 * idx + 1;
    }

    private int rightChild(int idx) {
        return 2 * idx + 2;
    }

    private void buildSegmentTree(int index, int l, int r) {
        if (l == r) {
            tree[index] = data[l];
            return;
        }
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);
        int mid = l + (r - l) / 2;

        buildSegmentTree(leftIndex, l, mid);
        buildSegmentTree(rightIndex, mid + 1, r);

        tree[index] = operator.operate(tree[leftIndex], tree[rightIndex]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (i < tree.length - 1) {
                sb.append(tree[i] + ", ");
            } else {
                sb.append(tree[i] + "]");
            }
        }
        return sb.toString();
    }
}
