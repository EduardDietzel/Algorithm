package algorithm.l7;

public class Main {

    public static void main(String[] args) {

    }


    //quick sort
    // 1. choose pivot
    // 2. divide to two sub arrays
    // 3. recursively sort them

    // [7,5,7,3,1,8,9,2]
    // 2 - O(n)
    // 3 - how many recursive call will we have?
    // if array is divided by half, then O (n log n) (as in merge) - the best case and the average
    // if array is reduced by one element, then O(n * n), n recursive calls - the worst case


    private static int[] quickSort(int[] arr, int startIdx, int endIdx) {
        // if array has only one element - return array
        // else
        // choose checkPoint
        // make partition around it
        // recursive calls for left and right

        if (startIdx >= endIdx) {
            return arr;
        } else {
            int idx = partition(arr, startIdx, endIdx);
            quickSort(arr, startIdx, idx);
            quickSort(arr, idx + 1, endIdx);
            return arr;
        }
    }

    // returns the indes of pivot
    // O(n) m n - endIndex - startIndex
    private static int partition(int[] arr, int startIdx, int endIdx) {
        int pivot = arr[endIdx];
        int indexPivot =  startIdx;

        for (int i = startIdx; i < endIdx ; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[indexPivot];
                arr[indexPivot] = temp;
                indexPivot++;
            }
        }

        int temp = arr[endIdx];
        arr[endIdx] = arr[indexPivot];
        arr[indexPivot] = temp;

        return indexPivot;
    }
    // partition example
    // arr =  [7, -2, 4, 1, 6, 5, 0, -4, 2], start = 0, endIndex = 8
    // pivot = 2
    // i = 0, indexPivot = 0
    // arr[0] < 2 ~ 7 < 2 false
    // i = 1, indexPivot = 0
    // arr[1] < 2 ~ -2 < 2 true
    // change arr = [-2, 7, 4, 1, 6, 5, 0, -4, 2]
    // i = 2, indexPivot = 1
    // 4 < 2 false
    // i = 3, indexPivot = 1
    // 1 < 2 true
    // change arr = [-2, 1, 4, 7, 6, 5, 0, -4, 2]
    // i = 4, indexPivot = 2
    // 6 < 2 false
    // i = 5, indexPivot = 2
    // 5 < 2, false
    // i = 6, indexPivot = 2
    // 0 < 2 true
    // change arr = [-2, 1, 0, 7, 6, 5, 4, -4, 2]
    // i = 7, indexPivot = 3
    // -4 < 2
    // change arr = [-2, 1, 0, -4, 6, 5, 4, 7, 2]
    // indexPivot = 4
    // after for cycle is ended
    // arr = [-2, 1, 0, -4, 2, 5, 4, 7, 6]






    // quick sort example
    // arr =  [7, -2, 4, 1, 6, 5, 0, -4, 2]
    // arr =  [-2, 1, 0,-4, 2, 7, 4, 6, 5] (partition does it and returns 4)]
    // arr =  [-4, -2, 1 ,0, 2, 7, 4, 6, 5] ( after recursive call of left arrays
    // arr =  [-4, -2, 1 ,0, 2, 4, 5, 7, 6] ( after recursive call of right arrays_
    // elements -4, 2, 5


}
