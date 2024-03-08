class Solution {

    public static int partition(int arr[],int low,int high)
    {
        int pivot=arr[high];

        int i=low-1;

        for(int j=low;j<high;j++)
        {
            if(arr[j] < pivot)
            {
                i++;

                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int temp=arr[i];
        arr[i]=arr[high];
        arr[high]=temp;

        return i;
    }

    public static void quickSort(int arr[],int low,int high)
    {
        if(low < high)
        {
            int pidx=partition(arr,low,high);

             quickSort(arr,low,pidx-1);
             quickSort(arr,pidx+1,high);
        }
    }
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }
}