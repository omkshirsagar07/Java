import java.util.*;
class mergeSortandbinarySearch
{
    public static void main(String[] args)
    {
        int[] arr={9,8,7,6,5,4,3,2,1};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        int target=8;
        System.out.println("target at :"+binarySearch(arr,target));

    }

    public static void sort(int[] arr,int start,int end)
    {
        //System.out.println(start+":"+end);
        if(start>=end)
        {
            return;
        }
        int mid=start+(end-start)/2;
        

        sort(arr,start,mid);
        sort(arr,mid+1,end);

        merge(arr,start,end,mid+1);
    } 

    public static void merge(int[] arr,int start,int end,int s2)
    {
        int i=start;
        int j=s2;
        int k=start;
        int[] temp=new int[arr.length];
        while(i<s2&&j<=end)
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
        while(j<=end)
        {
            temp[k++]=arr[j++];
        }

        for(i=start;i<=end;i++)
        {
            //System.out.println(Arrays.toString(temp));

            arr[i]=temp[i];
        }

    }

    public static int binarySearch(int[] arr,int target)
    {
        int start=0;
        int end=arr.length;
        int mid=start+(end-start)/2;
        System.out.println(Arrays.toString(arr));
        while(start<=end)
        {
          if(target==arr[mid])
           {
               System.out.println(arr[mid]);
             return mid;
            }
            
          if(target<arr[mid])
          {
              end=mid;
              mid=start+(end-start)/2;
          }
          if(target>arr[mid])
          {
              start=mid;
              mid=start+(end-start)/2;
          }
        }
        return -1;


    }
}