import java.util.*;
import java.util.stream.Stream;

public class ThreeSum1 {
    public static void main(String[] args) {

        int intervals[] = new int[] { -2, 0, 1, 1, 2 };
        Solution solution = new Solution();
        // [-2,0,1,1,2]
        // -4, -3, -2, -1, -1, 0, 0, 1, 2, 3, 4,
        List<List<Integer>> list;
        list = solution.threeSum(intervals);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }

        // Stream.of(nums).map(z -> System.out.println(z));

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        if (nums.length < 3) {
            return list;
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            System.out.println(" index = " + i + ",   values = " + nums[i]);
            int numA = nums[i];
            int twoSum = -numA;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {

                System.out.println(
                        "  -----{" + i + ":" + nums[i] + "," + j + ":" + nums[j] + "," + k + ":" + nums[k] + "}");
                if (nums[j] + nums[k] == twoSum && i != k && i != j) {
                    System.out.println(i + "," + j + "," + k);
                    int numB = nums[j];
                    int numC = nums[k];
                    int tripletsArr[] = new int[] { numA, numB, numC };
                    Arrays.sort(tripletsArr);
                    String key = ("" + tripletsArr[0] + tripletsArr[1] + tripletsArr[2]);
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(numA);
                    triplets.add(numB);
                    triplets.add(numC);
                    list.add(triplets);
                    map.put(key, 0);
                    System.out.println(map);
                    j++;
                    // k--;

                } else if (nums[j] + nums[k] > twoSum) {
                    k--;
                } else {
                    j++;
                }

                while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    j++;
                }

                while (k < nums.length - 1 && nums[k] == nums[k - 1]) {
                    k--;
                }

            }
        }
        return list;

    }

}