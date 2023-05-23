package algorithm.l3;

public class Main {

    public static void main(String[] args) {
        int[] arr= new int[]{4,98,15,324,43,23,47,86,3,42};
        int max1 = findMaxIterative(arr);
        System.out.println("max from iterative = " + max1);
        int max2 = findMaxDivideAndConquer(arr, 0);
        System.out.println("max from divide and conquer" + max2);

        int[] sortedArr = new int[]{4, 8, 15, 32, 43, 5, 67, 86, 101,114};

        int targetIdx = binarySearch(sortedArr, 32, 0, sortedArr.length);
        System.out.println("TargetIdx = " + targetIdx);


        String prefixRet = findTheLongestCommonPrefix("retrieve", "return");
        String prefixA = findTheLongestCommonPrefix("attractive", "adorable");

        String noPrefix = findTheLongestCommonPrefix("light", "night");
        System.out.println("Prefix: " + prefixRet);

        System.out.println("Prefix: " + prefixA);
        System.out.println("Prefix: " + noPrefix);


    }

    // Головоломка имее след. два правила:
    // 1. Вы не можете поместить большой диск на меньший диск.
    // 2. За один раз можно перемещать только один диск.

    // given: firstPol = [4, 3, 2, 1], secondPol = [], thirdPol = []

    // n = 4
    //1. firstPol = [4], secondPol = [3, 2, 1], thirdPol = []
    //2. firstPol = [] , secondPol = [3, 2, 1], thirdPol = [4]
    //3. firstPol = [], secondPol = [], thirdPol = [3, 2, 1]

    // n = 3
    //1. firstPol = [3], secondPol = [2, 1], thirdPol = []
    //2. firstPol = [] , secondPol = [2, 1], thirdPol = [3]
    //3. firstPol = [], secondPol = [], thirdPol = [4, 3, 2, 1]

    // move a ring from firstPol to thirdPol
    // int ring = firstPol.pop()
    // thirdPol.push(ing)

    // moveRings(firstPol, secondPol, thirdPol, numOfRins)
    // base recursion case: numOfRins == 1
    // else
    // move n-1 rings from first to second
    // move one ring from first to third
    // move n-1 from second to third


    // Iteration solution inspiration
    // if n is even (четное)
    // if n is odd (нечетное)

    // for n = 4 and n = 3
    // write a solution as sequense moves
    // poles 1, 2, 3
    // one move of ring
    // n = 3
    // before: firstPol = [3, 2, 1], secondPol = [], thirdPol = []
    // i=0 1 -> 3 firstPol = [3, 2,], secondPol = [], thirdPol = [1]
    // i=1 1 -> 2 firstPol = [3], secondPol = [2], thirdPol = [1]
    // i=2 3 -> 2 firstPol = [3], secondPol = [2, 1], thirdPol = []
    // i=3 1 -> 3 firstPol = [], secondPol = [2, 1], thirdPol = [3]
    // ...

    // find a pattern of moves
    // calculate how many values has i

    // operator % (division remainder)

    // moveRings(firstPol, secondPol, thirdPol)
    // for(i = 0; i < ?; i ++) {
    // ???
    // }

    // solution via "for"
    // time complexity O(n), n - array of length
    // space complexity O(1)

    // solution via "sort"
    // time complexity O(n log n), n - array of length
    // space complexity O(1)

    static int findMaxIterative(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }


    // {4,98,15,324,43,23,47,86,3,42}
    static int findMaxDivideAndConquer(int[] arr, int index) {
        int max;
        int length = arr.length;

        if (length > index) {
            max = findMaxDivideAndConquer(arr, index + 1);
            if (arr[index] > max) {
                return arr[index];
            } else {
                return max;
            }

        } else {
            return arr[length -1];
        }

    }

    // arr = [4,98,15,324,43,23,47,86,3,42]
    // call findMaxDivideAndConquer(arr, 0);
    // length = 10, index = 0
    // 10 > 0 => true
    // max = ??
    //      call findMaxDivideAndConquer(arr, 1);
    //      length = 10, index = 1
    //      10 > 1 => true
    //      max = ??
    //          call findMaxDivideAndConquer(arr, 2);
    //          length = 10, index = 2
    //          10 > 2 => true
    //          max = ??
    //              call findMaxDivideAndConquer(arr, 3);
    //              length = 10, index = 3
    //              10 > 3 => true
    //              max = ??
    //              ...
    //                  call findMaxDivideAndConquer(arr, 8);
    //                  length = 10, index = 8
    //                  10 > 8 => true
    //                  max = ??
    //                      call findMaxDivideAndConquer(arr, 9);
    //                      length = 10, index = 9
    //                      10 > 9 => true
    //                      max = ??
    //                          call findMaxDivideAndConquer(arr, 10);
    //                          length = 10, index = 10
    //                          10 > 10 => false
    //                          return arr[9] (arr[10-1])
    //                      max = 42 (arr[9])
    //                      arr[9] = 24
    //                      arr[index] > max => false
    //                      return 42
    //                  max = 42
    //                  arr[8] = 3
    //                  3 > 42 => false
    //                  return 42

    public static int binarySearch(int[] sortedArr, int target, int startIdx, int endIdx) {
        System.out.println("Search between indexes" + startIdx + " and " + endIdx);
        if (endIdx < startIdx) {
            return -1;
        }

        int middleIdx = sortedArr.length / 2;
        int middleElement = sortedArr[middleIdx];

        if (middleElement == target) {
            return middleIdx;
        }
        else if (target < middleElement) {
            // search in the left half
            return binarySearch(sortedArr, target, startIdx, middleIdx);

        }
        else if (target > middleElement) {
            // search in the right half
            return binarySearch(sortedArr, target, middleIdx, endIdx);
        }

        return -1;
    }


    // using divide and counter
    // arr ["retrieve", "return", "record"]
    // prefix = "re"
    // arr ["attractive", "account", "accord"]
    // prefix = "a"
    //

    public String findTheLongestCommonPrefix(String[] arr) {

        return null;
    }


    /// s1, s2
    // maximum length of common prefix = minimal from lengths of s1 and s2
    public static String findTheLongestCommonPrefix(String s1, String s2) {
        // for number of characters in shorter string (either s1, s2)
        // count while characters by same index are same
        // .charArt(idx)
        // .substring(startIdx, endIdx)
        // return substring of length of count

        int minimalLength = Math.min(s1.length(), s2.length());
        int count = 0;
        for (int i = 0; i < minimalLength; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            } else {
                break;
            }
        }
        return s1;

    }

}

