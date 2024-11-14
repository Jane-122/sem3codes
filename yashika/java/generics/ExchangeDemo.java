class Gen {
    // Generic method to swap two elements in an array
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

public class ExchangeDemo {
    public static void main(String[] args) {
        // Creating an array of Integer
        Integer[] arr = {1, 2, 3, 4, 5};
        
        // Printing the initial array
        System.out.println("Initial array: ");
        for (Integer i : arr) {
            System.out.print(i + " "); // Print each element
        }

        // Swapping elements at index 1 and 3
        Gen.swap(arr, 1, 3);
        
        // Printing the array after the swap
        System.out.println("\nAfter swap: ");
        for (Integer i : arr) {
            System.out.print(i + " "); // Print each element
        }
    }
}
