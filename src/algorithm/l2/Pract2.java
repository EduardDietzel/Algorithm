package algorithm.l2;

public class Pract2 {
    public static void main(String[] args) {

    }

    public static int getSize(int[] arr) {
        return arr.length;
    }

    //* O(n) - n length of number, one + operation needs to read both numbers
    public static int sumNums(int a, int b) {
        return a + b;
    }

    // O(n) n - length of array
    public static int getSum(int[] arr) {
        int sum = 0; // O(1)
        int mult = 0; // O(1)
        for (int i = 0; i < arr.length; i++) { // O(n)
            sum += arr[i]; // O(1)
            mult *= arr[i]; // O(1)
        }
        return sum; // O(1)
    }
    // detailed calculation
    // O(1) + O(1) + O(n)*( O(1) + O(1) )+ O(1) ~ O(2) + O(n)* O(2) + O(1) ~ O(1) + O(n)*O(1) + O(1) ~
    // ~ O(1) + O(n) + O(1) ~ O(1 + n + 1) ~ O(n+2) ~ O(n)

    // short calculation
    // O(1) + O(1) + O(n)*( O(1) + O(1) )+ O(1) ~ O(n)*( O(1) + O(1) ) ~ O(n)

    // input [1, 4, 5]
    // output [5, 4, 1]
    // time complexity O(n)
    // space complexity O(n)
    public static int[] reverseArr(int[] arr) {
        int n = arr.length;
        int[] reversed = new int[n];   // O(n) space complexity
        for (int i = 0; i < n; i++) {  // O(n) - time complexity
            reversed[n - 1 - i] = arr[i];
            // i = 0, reversed[n - 1] = arr[0];
            // i = 1, reversed[n - 2] = arr[1];
        }
        return reversed;
    }

    // time complexity O(n/2) ~ O(n)
    // space complexity O(1)
    public static int[] reverseArrBetterVersion(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {   // O(n/2)
            // swap arr[i] arr[n-1-i]
            int tmp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = tmp;
        }
        return arr;
    }

    // input [1, 4, 5, 6, 8, 7]
    // i = 0 1st iteration [7,4,5,6,8,1]
    // i = 1 2nd iteration [7,8,5,6,4,1]
    // i = 2 3rd iteration [7,8,6,5,4,1]

    public static void printMultiples(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int elem = arr[i];
            for (int j = 0; j < n; j++) {
                int otherElem = arr[j];
                int result = elem * otherElem;
                System.out.println("i * j = " + result);
            }
        }
    }

    // n - array of length
    // i = 0, j = 0 1 2 ... n - 1  - n operations
    // i = 1, j = 0 1 2 ... n - 1 - n operations
    // ...
    // i = n - 1, j = 0 1 2 ... n - 1 - n operations

    // n + n + .. + n = n * n = n ^ 2

    // for each i from 0 to n-1 we do n-1 operations

    // O(log n )
    // 2 ^ 3 = 8 ~ log_2(8) = 3 ;
    // log_2(64) = 6
    // log_2(1024) = 10

    // n -> n/2 -> n/4 -> n/8 -> ... -> 1
    // log(n) steps from n to 1

    // n -> n/5 -> n / 25 -> ... -> 1
    // log(n) steps from n to 1 (log_5(n))


    // arr - sorted
    // returns inde[ of key in array or -1 otherwise
    // arr = [5,8,13,17,19,24,29]
    // key = 19, returns 4
    // key = 22, returns -1
    
    // time complexity O(log(n))

//    public static int binarySearch(int[] arr, int key) {
//        int n = arr.length;
//        int middleIdx = n / 2;
//        int middleElem = arr[middleIdx];
//
//        if (middleElem == key) {
//            return middleIdx;
//        }
//        else if (key < middleElem) {
//            // drop left and compare only right part
//            // return
//        }
//        else {
//            // drop right and compare only right part
//            // return
//        }
//    }
    
    public static void printStars(int[] stars, int[] numbers) {
        for (int i = 0; i < stars.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                System.out.println("*");
            }
            System.out.println();
        }
    }


    // time complexity O(n^2)
    public static void bubleFor(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 4; i++) { // O(n/4) ~ O(n)
            for (int j = 0; j < n * 2; j += 5) { // O(n*2/5) ~ O(n)
                System.out.print("bubble");
            }
        }
    }
    // i = 0, j = 0, 5, 10, 15 ... n * 2
    // i = 1, j = 0, 5, 10, 15 ... n * 2
    // ...
    // i = n/4 - 1, j = 0, 5, 10, 15 ... n * 2

    // n =20
    // i = 0, j = 1,5,15,20,25,30,35
    // i = 1, j = 1,5,15,20,25,30,35

    // n/4 * (n*2/5)


}


