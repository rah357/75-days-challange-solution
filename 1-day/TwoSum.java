import java.util.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 2, 7, 11, 15 };
        TwoSum solution = new TwoSum();
        int result[] = solution.twoSum(arr, 26);
        System.out.println(result[0] + "  " + result[1]);

    }
}