import java.util.Scanner;
class quicksortnew
{  
   static int partition(int low,int high,int arr[])
   {
      int pivot=arr[low];
      int i=low,j=high,temp;
      while(i<=j)
      {
        while(arr[i]<=pivot)
        {
            i++;
        }
        while(arr[j]>pivot)
        {
            j--;
        }

        if(i<j)
        {
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
        }
      }
      arr[low]=arr[j];
      arr[j]=pivot;
      return j;
   }
   
   
   static void Quick_sort(int low,int high,int arr[])
   {
	   if(low < high){
		int j=partition(low,high,arr);
		Quick_sort(low,j-1,arr);
		Quick_sort(j+1,high,arr);
	   }
   }
   
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int n;
         System.out.println("Enter the number of elements\n");
         n=scan.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements\n");
        for(int i=0;i<n;i++)
        {
            arr[i]=scan.nextInt();
        }

        Quick_sort(0,n-1,arr);

        System.out.println("The array elements in sorted order are");
        for(int x:arr)
        {
            System.out.print(x+" ");
        }
        
    }
}