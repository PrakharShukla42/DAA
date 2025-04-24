public class InsertionSort {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] arr = {29, 10, 14, 37, 13};
        is.printArray(arr);
        is.sort(arr);
        is.printArray(arr);
    }
}
