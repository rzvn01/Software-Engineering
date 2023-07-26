package lab3;

import java.util.Arrays;
import java.util.Scanner;

/*Cacu Razvan GR-2023
Implement the already known sorting algorithms (bubble sort, insertion sort, quick sort, etc.) and apply them
upon an array of integer variables read from the keyboard.
  */
public class Lab3Ex5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array;

        System.out.print("Please enter the size of the array : ");
        size = scanner.nextInt();

        array = new int[size];

        System.out.print("Enter the values of the array : ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("The sorted array using bubbleSort : ");
        bubbleSort(array);

        System.out.print("The sorted array using insertionSort : ");
        insertionSort(array);

    }

    public static void bubbleSort(int[] array) {
        int[] arr = new int[array.length];
        System.arraycopy(array,0,arr,0,array.length );
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }

}
