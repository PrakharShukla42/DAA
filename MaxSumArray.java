public class MaxSumArray {

    public static int maxSumSubarray(int[] arr, int k) {
        int maxSum = 0, currentSum = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];

            if (right >= k - 1) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= arr[left];
                left++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 5, 8, 1};
        int k = 3;

        int result = maxSumSubarray(arr, k);
        System.out.println("Maximum Sum of Subarray of Size " + k + ": " + result);
    }
}
