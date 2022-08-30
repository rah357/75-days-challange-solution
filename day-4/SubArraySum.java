import java.util.*;

public class SubArraySum {

    public int subarraySum(int[] nums, int k) {
        int sumOfSubArray = 0;
        int total = 0;
        int startingPoint = 0;

        // -1, 2, -1, -1 }, -2
        for (int i = 0; i < nums.length; i++) {
            sumOfSubArray += nums[i];
            if (k == sumOfSubArray) {
                total += 1;
            }

        }

        // if (k < 0) {
        // for (int i = 0; i < nums.length; i++) {
        // if (sumOfSubArray + nums[i] >= k) {
        // sumOfSubArray += nums[i];
        // } else if (sumOfSubArray + nums[i] < k) {
        // sumOfSubArray += nums[i];
        // while ((sumOfSubArray - nums[startingPoint]) <= k) {
        // sumOfSubArray -= nums[startingPoint];
        // startingPoint++;
        // }
        // }
        // if (sumOfSubArray == k) {
        // total += 1;
        // }
        // }

        // return total;
        // }

        // for (int i = 0; i < nums.length; i++) {
        // if (sumOfSubArray + nums[i] <= k) {
        // sumOfSubArray += nums[i];
        // } else if (sumOfSubArray + nums[i] > k) {
        // sumOfSubArray += nums[i];
        // while ((sumOfSubArray - nums[startingPoint]) >= k) {
        // sumOfSubArray -= nums[startingPoint];
        // startingPoint++;
        // }
        // }
        // if (sumOfSubArray == k) {
        // total += 1;
        // }
        // }
        return total;
    }

    public static void main(String[] args) {
        // 1 1 1 1 1 3 1 1
        // 1 1 1 1 1 1 1 1
        // 10 1 1 1 1 1 1
        // 1 1 1 1 1 1 1 10
        // 1
        SubArraySum rs = new SubArraySum();
        System.out.println(rs.subarraySum(new int[] { -1, 2, -1, -1 }, -2));

    }

}
