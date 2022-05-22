import java.util.*;

public class ThreeSum1 {
    public static void main(String[] args) {

        int intervals[] = new int[] { -1, 0, 1, 2, -1, -4 };
        Arrays.sort(intervals);
        Solution solution = new Solution();

        List<List<Integer>> list;
        list = solution.threeSum(intervals);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        if (nums.length < 3) {
            return list;
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            System.out.println(" index = " + i + ",   values = " + nums[i]);
            int numA = nums[i];
            int twoSum = -numA;
            int j = 0;
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
                    if (map.containsKey(key) == false) {
                        List<Integer> triplets = new ArrayList<>();
                        triplets.add(numA);
                        triplets.add(numB);
                        triplets.add(numC);
                        list.add(triplets);
                        map.put(key, 0);
                        System.out.println(map);
                    }

                    j++;
                } else if (nums[j] + nums[k] > twoSum) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return list;

    }

}