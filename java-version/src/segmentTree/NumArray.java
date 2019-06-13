package segmentTree;
// LeetCode 307 Range Sum Query - Mutable

public class NumArray {

    private SegmentTree<Integer> segTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public void update(int index, int val) {
        segTree.set(index, val);
    }

    public int sumRange(int i, int j) {
        return segTree.query(i, j);
    }
}
