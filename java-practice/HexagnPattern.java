public class HexagnPattern {
    public static void main(String[] args) {
        int n = 12;
        String str = "cdefghij";
        int startPos = 2;

        char arr[] = new char[n];
        int strIndex = 0;

        for (int i = startPos; strIndex < str.length(); i--) {
            if (i - 1 < 0) {
                i = n;
            }
            arr[i - 1] = str.charAt(strIndex);
            strIndex++;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = '*';
            }
        }
        char topChar = arr[0];
        char bottomChar = arr[n / 2];

        int leftChar = n - 1;
        int rightChar = 1;

        int iteration = n / 2 + 1;
        int startSquare = iteration / 2;

        // ----------------printing the first end point---------------
        for (int spaceIterator = 1; spaceIterator < startSquare; spaceIterator++) {
            System.out.print(" ");
        }
        System.out.println(topChar);

        // ----------------printing the up cone-section---------------
        for (int i = 2; i <= startSquare - 1; i++) {
            for (int spaceIterator = 1; spaceIterator <= startSquare - i; spaceIterator++) {
                System.out.print(" ");
            }
            System.out.print(arr[leftChar--]);

            for (int spaceIterator = 1; spaceIterator <= 2 * (i - 2) + 1; spaceIterator++) {
                System.out.print(" ");
            }
            System.out.print(arr[rightChar++]);
            System.out.println();
        }

        // ----------------printing the square-section---------------
        for (int i = startSquare; i <= startSquare + (iteration / 2) - 1; i++) {
            System.out.print(arr[leftChar--]);
            for (int spaceIterator = 1; spaceIterator <= 2 * (startSquare - 1 - 2) + 3; spaceIterator++) {
                System.out.print(" ");
            }
            System.out.print(arr[rightChar++]);
            System.out.println();
        }

        // ----------------printing the down cone-section---------------
        for (int i = 2; i <= startSquare - 1; i++) {
            for (int spaceIterator = 1; spaceIterator <= i - 1; spaceIterator++) {
                System.out.print(" ");
            }
            System.out.print(arr[leftChar--]);

            for (int spaceIterator = 1; spaceIterator <= 2 * ((startSquare - 1) - i) + 1; spaceIterator++) {

                System.out.print(" ");
            }
            System.out.print(arr[rightChar++]);
            System.out.println();
        }

        // ----------------printing the last end point---------------
        for (int spaceIterator = 1; spaceIterator < startSquare; spaceIterator++) {
            System.out.print(" ");
        }
        System.out.println(bottomChar);

    }

}
