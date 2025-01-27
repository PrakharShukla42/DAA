import java.util.*;
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {6, 4, 2, 1, 9, 8, 3, 5};

        System.out.println("Original Array: " + Arrays.toString(array));

        int n = array.length;

        for (int step = 1; step < n; step *= 2) {
            for (int left = 0; left < n - step; left += 2 * step) {
                int mid = left + step - 1;
                int right = Math.min(left + 2 * step - 1, n - 1);
                int[] temp = new int[right - left + 1];
                int i = left, j = mid + 1, k = 0;

                while (i <= mid && j <= right) {
                    if (array[i] <= array[j]) {
                        temp[k++] = array[i++];
                    } else {
                        temp[k++] = array[j++];
                    }
                }

                while (i <= mid) {
                    temp[k++] = array[i++];
                }

                while (j <= right) {
                    temp[k++] = array[j++];
                }

                for (int t = 0; t < temp.length; t++) {
                    array[left + t] = temp[t];
                }
            }
        }

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}

/*
       Divide and Conquer Approach.
       [6,4,2,1,9,8,3,5]
       n=8
i)-    divide array repeatedly in two equal parts.
ii)-   [6,4,2,1]                 [9,8,3,5]
iii)-  then divide once again.
iv)-   [6,4] [2,1]  [9,8]   [3,5]
v)-    [6] [4] [2] [1] [9] [8] [3] [5]
vi)-   divide big problem into smaller sub problems.
vii)-  Conquer = Merge
viii)- [4,6] [1,2] [8,9] [3,5]
ix)-   [1,2,4,6]    [3,5,8,9]-
x)-    [1,2,3,4,5,6,8,9]
xi)-   Merge in sorted order

 */