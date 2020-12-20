package leetcode.editor;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/1 0:30
 */
public class Code34 {

    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int[] ints = {-1, -1};
        if (nums.length == 0) {
            return ints;
        }
        int left = 0;
        int right = nums.length;
        while (left != right) {
            int mid = (right + left) >> 1;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return ints;
    }
}
