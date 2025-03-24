import java.util.*;

public class MergeSortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt(); // Number of arrays
        List<int[]> arrays = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int n = scanner.nextInt(); // Size of the array
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            arrays.add(arr);
        }
        scanner.close();

        List<Integer> mergedList = mergeSortedArrays(arrays);

        // Print the merged array
        for (int num : mergedList) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> mergeSortedArrays(List<int[]> arrays) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        List<Integer> result = new ArrayList<>();

        // Initialize heap with the first element of each array
        for (int i = 0; i < arrays.size(); i++) {
            if (arrays.get(i).length > 0) {
                minHeap.add(new Element(arrays.get(i)[0], i, 0));
            }
        }

        // Process the heap
        while (!minHeap.isEmpty()) {
            Element current = minHeap.poll();
            result.add(current.value);
            int nextIndex = current.index + 1;

            if (nextIndex < arrays.get(current.arrayIndex).length) {
                minHeap.add(new Element(arrays.get(current.arrayIndex)[nextIndex], current.arrayIndex, nextIndex));
            }
        }

        return result;
    }

    static class Element {
        int value, arrayIndex, index;

        Element(int value, int arrayIndex, int index) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.index = index;
        }
    }
}