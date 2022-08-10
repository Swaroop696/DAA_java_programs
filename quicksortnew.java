import java.util.Scanner;

public class QuickSort{
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low], i = low, j = high, temp;
        while(i < j){
            while(arr[i] <= pivot && i < high){
                i++;
            }
            while(arr[j] >= pivot && j > low){
                j--;
            }
            if(i < j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[low] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void quicksort(int[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            quicksort(arr, low, p-1);
            quicksort(arr, p+1, high);
        }
    }

    public static void display(int[] arr, int n){
        System.out.print("Sorted order: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = in.nextInt();
        int[] arr = new int[n];

        System.out.print("Enter the elements: ");
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        quicksort(arr, 0, n-1);
        display(arr, n);
    }
}
