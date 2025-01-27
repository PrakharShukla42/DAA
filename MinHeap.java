import java.util.Arrays;

public class MinHeap {

    private int[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MinHeap() {
        heap = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    // Insert element into the heap (Push operation)
    public void insert(int value) {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, size * 2); // Resize heap array if full
        }
        heap[size] = value;
        size++;
        heapifyUp();
    }

    // Heapify Up operation to maintain heap property
    private void heapifyUp() {
        int index = size - 1;
        while (index > 0 && heap[index] < heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Extract minimum (Pop operation)
    public int extractMin() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return min;
    }

    // Heapify Down operation to maintain heap property after extraction
    private void heapifyDown() {
        int index = 0;
        while (leftChild(index) < size) {
            int smallerChild = leftChild(index);
            if (rightChild(index) < size && heap[rightChild(index)] < heap[smallerChild]) {
                smallerChild = rightChild(index);
            }
            if (heap[index] <= heap[smallerChild]) {
                break;
            }
            swap(index, smallerChild);
            index = smallerChild;
        }
    }

    // Helper methods for parent, left and right children indices
    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Utility method to display the heap
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        minHeap.insert(4);
        minHeap.insert(15);
        minHeap.insert(6);
        minHeap.insert(2);

        System.out.println("Min Heap after inserts:");
        minHeap.display();

        System.out.println("Extract Min: " + minHeap.extractMin());

        System.out.println("Min Heap after extracting min:");
        minHeap.display();
    }
}
