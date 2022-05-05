public class FindPivotIndexApproach1 {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, -1, 2 };
        Solution solution = new Solution();

        int result = solution.pivotIndex(arr);

        System.out.println("pivot index is = " + result);

    }

}

class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        int pivotIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            float leftPart = (float) ((float) total - (float) nums[i]) / 2;
            System.out.println(leftPart + "=====" + left);

            if (leftPart == left) {
                pivotIndex = i;
                break;
            }
            left += nums[i];
        }
        return pivotIndex;
    }
}