package MvnPackage;

public class sorting {

	  public static void main(String[] args) {
	        int[] arr = {5, 3, 8, 1, 9, 2}; // Initialize the array to be sorted.

	        // Bubble Sort Algorithm
	        for (int i = 0; i < arr.length - 1; i++) { // Outer loop for each pass through the array.
	            for (int j = 0; j < arr.length - i - 1; j++) { // Inner loop for comparing elements.
	                if (arr[j] < arr[j + 1]) { // Compare adjacent elements.
	                    // Swap arr[j] and arr[j+1] if they are in the wrong order.
	                    int temp = arr[j]; // Store the larger element temporarily.
	                    arr[j] = arr[j + 1]; // Place the smaller element in arr[j].
	                    arr[j + 1] = temp; // Place the larger element in arr[j+1].
	                }
	            }
	        }

	        // Print the sorted array.
	        System.out.println("Sorted array using Bubble Sort: ");
	        for (int i : arr) { // Enhanced for-loop to print the sorted array.
	            System.out.print(i + " ");
	        }
	    }
	}

