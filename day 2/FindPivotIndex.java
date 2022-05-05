public class FindPivotIndex {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 3, 3 };
        Solution solution = new Solution();

        int result = solution.pivotIndex(arr);

        System.out.println("pivot index is = " + result);

    }

}

class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int previous = 0;
        int right = 0;
        int total = 0;
        int pivotIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            left = left + previous;
            right = total - nums[i];
            total = total - nums[i];
            if (left == right) {
                pivotIndex = i;
                break;
            }
            previous = nums[i];
        }
        if (pivotIndex == -1) {
            return -1;
        }
        return pivotIndex;
    }
}