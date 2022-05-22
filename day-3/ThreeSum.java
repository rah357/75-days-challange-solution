import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {

        int intervals[] = new int[] { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 };
        Solution solution = new Solution();

        List<List<Integer>> list = solution.threeSum(intervals);
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

            int numA = nums[i];
            int twoSum = -numA;
            HashMap<Integer, Integer> twoSumMap = new HashMap<>();
            for (int j = 0; j < nums.length; j++) {
                int first = nums[j];
                int second = twoSum - first;
                if (twoSumMap.containsKey(second)) {

                    if (i != j) {
                        int numB = first;
                        int numC = second;

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
                        }
                    }
                } else {
                    if (j != i) {
                        twoSumMap.put(first, 1);
                    }

                }
            }
        }
        return list;

    }
}