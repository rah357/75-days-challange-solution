import java.util.*;

public class MajorityElementApproach2 {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 3, 1, 1, 4, 1, 1, 5, 1, 1, 6, 2, 2 };
        Solution solution = new Solution();

        int result = solution.majorityElement(arr);

        System.out.println("pivot index is = " + result);

    }

}

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            System.out.println(counter);
            if (nums[i] == candidate) {
                counter++;
            } else {
                counter--;
            }
            if (counter <= 0) {
                candidate = nums[i];
                counter = 1;
            }
        }
        return candidate;
    }
}