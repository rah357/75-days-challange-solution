public class RemoveDuplicateSortedArrayApproach1 {

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
        } else if (arr.length == 1) {
            return 1;
        }
        int currentVisited = arr[0];
        int resultLength = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == currentVisited) {
                arr[i] = -101;
            } else if (arr[i] != currentVisited && arr[i] != -101) {
                resultLength++;
                currentVisited = arr[i];
            }

        }

        for (int i = 1; i < arr.length;) {
            if (arr[i] == -101) {
                if (i + 1 < arr.length) {
                    int j = i + 1;
                    for (j = i + 1; j < arr.length; j++) {
                        arr[j - 1] = arr[j];
                    }
                    arr[j - 1] = 101;
                } else {
                    arr[i] = 101;
                }
            } else {
                i++;
            }
        }
        return resultLength;
    }
}