import java.util.*;

public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        Solution solution = new Solution();

        List<List<Integer>> pascalTriangle = solution.generate(numRows);

        for (int i = 0; i < pascalTriangle.size(); i++) {
            System.out.println(pascalTriangle.get(i));
        }
    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangleList = new LinkedList<List<Integer>>();

        int triangle[][] = new int[numRows][0];

        for (int i = 0; i < numRows; i++) {
            int rows[] = new int[i + 1];
            rows[0] = 1;
            rows[rows.length - 1] = 1;
            triangle[i] = rows;
            if (i >= 2) {
                for (int j = 1; j < triangle[i].length - 1; j++) {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }
        for (int i = 0; i < triangle.length; i++) {
            List<Integer> rowsList = new LinkedList<Integer>();
            for (int j = 0; j < triangle[i].length; j++) {
                rowsList.add(triangle[i][j]);
            }
            triangleList.add(rowsList);
        }
        return triangleList;
    }
}