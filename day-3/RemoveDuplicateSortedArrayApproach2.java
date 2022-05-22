public class RemoveDuplicateSortedArrayApproach2 {
    public static void main(String[] args) {
        int arr[] = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        Solution solution = new Solution();

        int uniqueElementLength = solution.removeDuplicates(arr);
        System.out.println("Length of sorted array = " + uniqueElementLength);

    }
}

class Solution {
    public int removeDuplicates(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int store = 0;
        int length = arr.length;
        for (int i = 1; i < length;) {
            if (arr[i] != arr[store]) {
                store++;
                arr[store] = arr[i];
            }
            i++;
        }

        return store + 1;
    }
}