import java.util.*;
class mergeSort
{
    public static void main(String[] args)
    {
        int[] arr={9,8,7,6,5,4,3,2,1,0};

        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr,int start,int end)
    {
        if(start>=end)
        {
            return;
        }
        int mid=start+(end-start)/2;
        sort(arr,start,mid);
        sort(arr,mid+1,end);

        merge(arr,start,end,mid+1);

    }
    public static void merge(int[] arr,int l,int r,int s2)
    {
        int i=l;
        int j=s2;
        int k=l;
        int[] temp=new int[arr.length];
        while(i<=s2-1&&j<=r)
        {
            if(arr[i]<arr[j])
            {
                temp[k++]=arr[i++];
            }
            else
            {
                temp[k++]=arr[j++];
            }
        }

        while(i<=s2-1)
        {
            temp[k++]=arr[i++];
        }
        while(j<=r)
        {
            temp[k++]=arr[j++];
        }

        for(i=l;i<=r;i++)
        {
            arr[i]=temp[i];
        }
    }



    
}