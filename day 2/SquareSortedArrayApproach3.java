public class SquareSortedArrayApproach3 {
    public static void main(String[] args) {
        int arr[] = new int[] { -4, -3, -1, 0, 1, 9, 10 };
        Solution solution = new Solution();

        int result[] = solution.sortedSquares(arr);

        int length = result.length;
        for (int i = 0; i < length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

    }

}

class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;
        int result[] = new int[nums.length];

        while (i <= j) {
            int numi = nums[i] * nums[i];
            int numj = nums[j] * nums[j];

            if (numi > numj) {
                result[k--] = numi;
                i++;
            } else {
                result[k--] = numj;
                j--;
            }
        }

        return result;
    }
}