import java.util.Scanner;

public class Heap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize the heap
    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity + 1]; // 1-based indexing
    }

    private int parent(int i) { return i / 2; }
    private int leftChild(int i) { return 2 * i; }
    private int rightChild(int i) { return 2 * i + 1; }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Heapify a subtree with root at index i
    private void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left <= size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right <= size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // Insert a new element
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }
        size++;
        heap[size] = value;
        int i = size;
        while (i > 1 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Extract minimum element
    public int extractMin() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;
        }
        int min = heap[1];
        heap[1] = heap[size];
        size--;
        heapify(1);
        return min;
    }

    // Build heap from array
    public void buildHeap(int[] arr, int n) {
        for (int i = 1; i <= n; i++) {
            heap[i] = arr[i - 1]; // copy array elements
        }
        size = n;
        for (int i = size / 2; i >= 1; i--) {
            heapify(i);
        }
    }

    // Display heap
    public void displayHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Heap heap = new Heap(20);

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Insert");
            System.out.println("2. Extract Min");
            System.out.println("3. Build Heap from array");
            System.out.println("4. Display Heap");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter value to insert:");
                    int value = sc.nextInt();
                    heap.insert(value);
                    break;
                case 2:
                    int min = heap.extractMin();
                    if (min != -1) {
                        System.out.println("Extracted Min: " + min);
                    }
                    break;
                case 3:
                    System.out.println("Enter the number of elements in the array:");
                    int n = sc.nextInt();
                    int[] arr = new int[n];
                    System.out.println("Enter the elements:");
                    for (int i = 0; i < n; i++) {
                        arr[i] = sc.nextInt();
                    }
                    heap.buildHeap(arr, n);
                    System.out.println("Heap built.");
                    break;
                case 4:
                    System.out.println("Heap elements:");
                    heap.displayHeap();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}