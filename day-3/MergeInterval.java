import java.util.*;

public class MergeInterval {
    public static void main(String[] args) {

        // [[2,3],[4,6],[5,7],[3,4]]

        int intervals[][] = new int[][] { { 1, 4 }, { 2, 4 }, { 6, 8 }, { 1, 10 } };
        Solution solution = new Solution();

        int mergedIntervals[][] = solution.merge(intervals);

        for (int i = 0; i < mergedIntervals.length; i++) {
            System.out.println(mergedIntervals[i][0] + ", " + mergedIntervals[i][1]);
        }
    }

}

// class Solution {
// public int[][] merge(int[][] intervals) {

// HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

// List<List<Integer>> list = new LinkedList<List<Integer>>();
// for (int i = 0; i < intervals.length; i++) {
// if (intervals[i] != null) {
// int start = intervals[i][0];
// int end = intervals[i][1];
// for (int j = i + 1; j < intervals.length; j++) {
// if (intervals[j] != null) {
// int currentStart = intervals[j][0];
// int currentEnd = intervals[j][1];

// if ((end >= currentStart && currentStart >= start)
// || (currentEnd >= start && start >= currentStart)) {
// end = Math.max(end, currentEnd);
// start = Math.min(start, currentStart);
// intervals[j] = new int[] { start, end };
// }

// }
// }
// intervals[i] = null;

// List<Integer> tempList = new LinkedList<Integer>();
// if (!(map.containsKey(start) && map.containsKey(end))) {
// tempList.add(start);
// tempList.add(end);
// list.add(tempList);
// map.put(start, start);
// map.put(end, end);
// }
// }
// }

// int result[][] = new int[list.size()][2];
// int index = 0;
// while (!list.isEmpty()) {

// result[index][0] = list.get(0).get(0);
// result[index++][1] = list.get(0).get(1);
// list.remove(0);
// }

// return result;
// }

// public int[][] merge(int[][] intervals) {
// List<List<Integer>> listIntervals = new ArrayList<List<Integer>>();

// int length = intervals.length;
// for (int i = 0; i < length; i++) {
// List<Integer> singleInterval = new ArrayList<Integer>();
// singleInterval.add(intervals[i][0]);
// singleInterval.add(intervals[i][1]);
// listIntervals.add(singleInterval);
// }

// for (int i = 0; i < listIntervals.size();) {
// int start = listIntervals.get(i).get(0);
// int end = listIntervals.get(i).get(1);
// int j = i + 1;

// boolean isRemoved = false;
// for (; j < listIntervals.size();) {

// int currentStart = listIntervals.get(j).get(0);
// int currentEnd = listIntervals.get(j).get(1);

// if ((end >= currentStart && currentStart >= start)
// || (currentEnd >= start && start >= currentStart)) {

// end = Math.max(end, currentEnd);
// start = Math.min(start, currentStart);

// listIntervals.remove(i);
// listIntervals.remove(j - 1);

// List<Integer> singleInterval = new ArrayList<Integer>();
// singleInterval.add(start);
// singleInterval.add(end);
// listIntervals.add(singleInterval);
// isRemoved = true;
// break;
// } else {
// j++;
// }
// }
// if (isRemoved == true) {
// } else {
// i++;
// }
// }

// int result[][] = new int[listIntervals.size()][2];
// int index = 0;
// while (!listIntervals.isEmpty()) {
// List<Integer> singleInterval = listIntervals.get(0);
// result[index][0] = singleInterval.get(0);
// result[index++][1] = singleInterval.get(1);
// listIntervals.remove(0);
// }
// return result;
// }

// public int[][] merge(int[][] intervals) {
// Arrays.sort(intervals, new Comparator<Integer>() {
// @Override
// public int compare(Integer a, Integer b) {
// return Integer.compare(a, b);
// }
// });

// for (int i = 0; i < listIntervals.size();) {
// int start = listIntervals.get(i).get(0);
// int end = listIntervals.get(i).get(1);
// int j = i + 1;

// boolean isRemoved = false;
// for (; j < listIntervals.size();) {

// int currentStart = listIntervals.get(j).get(0);
// int currentEnd = listIntervals.get(j).get(1);

// if ((end >= currentStart && currentStart >= start)
// || (currentEnd >= start && start >= currentStart)) {

// end = Math.max(end, currentEnd);
// start = Math.min(start, currentStart);

// listIntervals.remove(i);
// listIntervals.remove(j - 1);

// List<Integer> singleInterval = new ArrayList<Integer>();
// singleInterval.add(start);
// singleInterval.add(end);
// listIntervals.add(singleInterval);
// isRemoved = true;
// break;
// } else {
// j++;
// }
// }
// if (isRemoved == true) {
// } else {
// i++;
// }
// }

// int result[][] = new int[listIntervals.size()][2];
// int index = 0;
// while (!listIntervals.isEmpty()) {
// List<Integer> singleInterval = listIntervals.get(0);
// result[index][0] = singleInterval.get(0);
// result[index++][1] = singleInterval.get(1);
// listIntervals.remove(0);
// }
// return result;
// }

// }

class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> mergedList = new ArrayList<int[]>();
        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if ((start <= currentStart && currentStart <= end) || (currentStart <= start && start <= currentEnd)) {
                start = Math.min(start, currentStart);
                end = Math.max(currentEnd, end);
            } else {
                mergedList.add(new int[] { start, end });
                start = currentStart;
                end = currentEnd;
            }
        }
        mergedList.add(new int[] { start, end });

        int result[][] = mergedList.toArray(new int[mergedList.size()][]);
        System.out.println(mergedList);

        return result;
    }

}