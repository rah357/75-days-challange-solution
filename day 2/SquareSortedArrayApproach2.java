import java.util.*;

public class SquareSortedArrayApproach2 {
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

        int posCount = 0;
        int negCount = 0;

        for (int iterator = 0; iterator < nums.length; iterator++) {
            if (nums[iterator] < 0) {
                negCount++;
            } else {
                posCount++;
            }
        }

        int neg[] = new int[negCount];
        int negIndex = negCount - 1;
        int posIndex = 0;
        int pos[] = new int[posCount];

        for (int iterator = 0; iterator < nums.length; iterator++) {
            if (nums[iterator] < 0) {
                neg[negIndex--] = nums[iterator] * nums[iterator];
            } else {
                pos[posIndex++] = nums[iterator] * nums[iterator];
            }
        }

        int i = 0;
        int j = 0;
        int k = 0;

        int result[] = new int[nums.length];
        while (i < pos.length && j < neg.length) {
            if (pos[i] < neg[j]) {
                result[k++] = pos[i++];
            } else {
                result[k++] = neg[j++];
            }
        }

        while (i < pos.length) {
            result[k++] = pos[i++];
        }

        while (j < neg.length) {
            result[k++] = neg[j++];
        }
        return result;

    }
}