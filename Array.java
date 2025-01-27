import java.util.Arrays;
public class Array {
    public static void main(String[] args) {
        // Array declaration (fixed size)
        int[] arr = {1, 2, 3, 4, 5};
        // Traversal
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // Access (O(1)) - Access the element at index 2
        System.out.println(arr[2]);
        // Insertion at the end (O(1)) - Arrays are fixed size, so you need to create a new array
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = 6;
        // Deletion at the end (O(1)) - You can resize the array after removing the element
        arr = Arrays.copyOf(arr, arr.length - 1);
        // Insertion at the beginning (O(n)) - Shifting elements manually
        arr = insertAtBeginning(arr, 0);
        // Deletion from the beginning (O(n)) - Shifting elements manually
        arr = removeFromBeginning(arr);
        // Traversal after modifications
        System.out.println("Array after modifications:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    // Method to insert an element at the beginning (O(n))
    public static int[] insertAtBeginning(int[] arr, int element) {
        int[] newArr = new int[arr.length + 1];
        newArr[0] = element;
        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }
    // Method to remove an element from the beginning (O(n))
    public static int[] removeFromBeginning(int[] arr) {
        int[] newArr = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }
        return newArr;
    }
}
