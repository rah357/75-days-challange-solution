import java.util.*;

public class LC {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.garbageCollection(new String[] { "G", "P", "GP", "GG" }, new int[] { 2, 4, 3 }));
    }
}

class Solution {

    public int garbageCollection(String[] garbage, int[] travel) {
        int totalMetal = 0;
        int totalPaper = 0;
        int totalGlass = 0;

        int totalTravled = 0;

        for (int i = 0; i < garbage.length; i++) {
            int travleTime = 0;
            if (i == 0) {
                travleTime = 0;
            } else {
                travleTime = travel[i - 1];
                totalTravled += travel[i - 1];
            }
            String assortment = garbage[i];

            int freq[] = new int[3];
            for (int j = 0; j < assortment.length(); j++) {
                char c = assortment.charAt(j);
                if (c == 'G') {
                    freq[0]++;
                } else if (c == 'M') {
                    freq[1]++;
                } else if (c == 'P') {
                    freq[2]++;
                }
            }

            if (freq[0] > 0) {
                if (totalGlass == 0) {
                    totalGlass += totalTravled;
                } else {
                    totalGlass += travleTime;
                }

                totalGlass += freq[0];
            }
            if (freq[1] > 0) {
                if (totalMetal == 0) {
                    totalMetal += totalTravled;
                } else {
                    totalMetal += travleTime;
                }
                totalMetal += freq[1];
            }

            if (freq[2] > 0) {
                if (totalPaper == 0) {
                    totalPaper += totalTravled;
                } else {
                    totalPaper += travleTime;
                }
                totalPaper += freq[2];
            }

        }
        return totalPaper + totalGlass + totalMetal;
    }
}