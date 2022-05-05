import java.util.*;

public class MajorityElementApproach1 {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 1, 2 };
        Solution solution = new Solution();

        int result = solution.majorityElement(arr);

        System.out.println("pivot index is = " + result);

    }

}

public int majorityElement(int[] nums) {
    int time = (int)Math.floor(nums.length / 2);
    HashMap<Integer, Integer> map = new HashMap<>();
    int i = 0;
    while(i < nums.length) {
        if(map.containsKey(nums[i])) {
            map.put(nums[i], map.get(nums[i]) + 1);
            if(map.get(nums[i]) > time) {
                return nums[i];
                
            }
        } else {
            map.put(nums[i], 1);                
        }
        i++;
    }
    
    return 1;
}