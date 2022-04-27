public class AddOneIntoArray {
    public static void main(String[] args) {
        int arr[] = new int[] { 9, 9, 9 };
        Solution solution = new Solution();

        int result[] = solution.plusOne(arr);

        int length = result.length;
        for (int i = 0; i < length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

    }

}

class Solution {
    public int[] plusOne(int[] digits) {

        int length = digits.length - 1;
        int carry = 0;

        for (int i = length; i >= 0; i--) {
            int sum = 0;
            if (i == length) {
                sum = digits[i] + 1;
            } else {
                sum = digits[i] + carry;
            }

            carry = sum / 10;
            digits[i] = sum % 10;
        }
        int result[] = new int[length + 1];
        result = digits;
        if (carry > 0) {
            result = new int[length + 2];
            for (int i = 0; i < length; i++) {
                result[i + 1] = digits[i];
            }
            result[0] = carry;

        }
        return result;
    }
}