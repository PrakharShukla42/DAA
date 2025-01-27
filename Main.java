public class Main
{
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                for (int num : arr) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            if (!swapped) {
                break;
            }
        }

        System.out.println("\nSorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
