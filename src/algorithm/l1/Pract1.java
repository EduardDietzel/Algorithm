package algorithm.l1;

public class Pract1 {

    public static void main(String[] args) {
        System.out.println(gcdNaive(48, 6));
    }
        // algorithm
        // max = if a >= b then a else b
        // res = 1
        // for each number 0 until max
        // if a % gcd is 0 and b % gcd is zero then res = number
        // return res

    public static int gcdNaive(int a, int b) {
            int res = 1;
            for (int i = 1; i < Math.max(a, b); i++) {
                if (a % i == 0 && b % i == 0) {
                    res = i;
                }
            }
            return res;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }


    // n - length of array
    // time complexity - O(n) ~ no ore then n operations (y = x)
    public static int findMax(int[] arr) {
        if (arr.length == 0) return -1;  // one operation of comparison
        int max = arr[0];                // new variable, one operation of assignment,
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}
