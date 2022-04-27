public class MoveZeroes {
    public static void main(String[] args) {
        int arr[] = new int[] { 0, 0, 0, 0, 0, 1 };
        Solution solution = new Solution();
        solution.moveZeroes(arr);
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

}

class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length;) {
            if (nums[i] == 0) {
                int j = i + 1;
                for (; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                nums[j - 1] = 0;

            }
            if (nums[i] != 0) {
                i++;
            }
            count++;
            if (count == nums.length) {
                return;
            }
        }
    }
}
