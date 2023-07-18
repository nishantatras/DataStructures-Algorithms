package Sorting;
import java.util.Arrays;

public class SortingRec {

    public static void BubbleSort(int[] arr,int si,int li){
    if(li==0){
    return ;
    }

    if(si<li){
    if(arr[si]>arr[si+1]){
    int temp=arr[si];
    arr[si]=arr[si+1];
    arr[si+1]=temp;
    }
    BubbleSort(arr, si+1, li);
    }
    else{
    BubbleSort(arr, 0, li-1);
    }
    }

    public static void SelectionSort(int[] arr, int si, int li,int max) {
        if (li == 0) {
            return;
        }

        if (si < li) {
            if (arr[si] > arr[max]) {
            SelectionSort(arr, si + 1, li,si);
            }
            else{
            SelectionSort(arr, si + 1, li,max);
            }
        } else {
            int temp=arr[li];
            arr[li]=arr[max];
            arr[max]=temp;
            SelectionSort(arr, 0, li - 1,0);
        }
    }

    public static int[] MergeSort(int[] arr){
    if(arr.length==1){
    return arr;
    }
    int mid=(arr.length)/2;

    int l[]=MergeSort(Arrays.copyOfRange(arr, 0, mid));
    int r[]=MergeSort(Arrays.copyOfRange(arr, mid, arr.length));
    return merge(l,r);
    } 

    public static int[] merge(int l[],int r[]){
    int arr[]=new int[l.length+r.length];
    int i=0,j=0,k=0;
    while(i<l.length&&j<r.length){
        if(l[i]<r[j]){
        arr[k]=l[i];
        i++;
        k++;
        }
        else{
        arr[k] = r[j];
        j++;
        k++;
        }
    }

    while(i<l.length){
    arr[k]=l[i];
    i++;
    k++;
    }
    while (j< r.length) {
        arr[k] = r[j];
        j++;
        k++;
    }
    return arr;
    }
   
    public static void MergeSortinplace(int[] arr,int si,int ei){
    if (si<ei) {
        int mid = (si+ei) / 2;
       MergeSortinplace(arr, si, mid);
       MergeSortinplace(arr, mid+1,ei);
       mergeinplace(arr,si,mid,ei);
    }
}

    public static void mergeinplace(int arr[],int si,int mid,int ei) {
        int res[] = new int[ei-si];
        int i = si, j = mid, k = 0;
        while (i < mid && j < ei) {
            if (arr[i] < arr[j]) {
                res[k] = arr[i];
                i++;
                k++;
            } else {
                res[k] = arr[j];
                j++;
                k++;
            }
        }

        while (i < mid) {
            res[k] = arr[i];
            i++;
            k++;
        }
        while (j < ei) {
            res[k] = arr[j];
            j++;
            k++;
        }
        for(int l=0; l<res.length; i++){
        arr[si+l]=res[l];
        }
        // int n1 = m - l + 1;
        // int n2 = r - m;

        // /* Create temp arrays */
        // int L[] = new int[n1];
        // int R[] = new int[n2];

        // /* Copy data to temp arrays */
        // for (int i = 0; i < n1; ++i)
        //     L[i] = arr[l + i];
        // for (int j = 0; j < n2; ++j)
        //     R[j] = arr[m + 1 + j];

        // /* Merge the temp arrays */

        // // Initial indexes of first and second subarrays
        // int i = 0, j = 0;
        // int k = l;
        // while (i < n1 && j < n2) {
        //     if (L[i] <= R[j]) {
        //         arr[k] = L[i];
        //         i++;
        //     } else {
        //         arr[k] = R[j];
        //         j++;
        //     }
        //     k++;
        // }

        // /* Copy remaining elements of L[] if any */
        // while (i < n1) {
        //     arr[k] = L[i];
        //     i++;
        //     k++;
        // }

        // /* Copy remaining elements of R[] if any */
        // while (j < n2) {
        //     arr[k] = R[j];
        //     j++;
        //     k++;
        // }
    }

    public static void Quicksort(int arr[],int l,int h){
    if(l>=h){
    return ;
    }
    int s=l;
    int e=h;
    int m=(s+e)/2;
    int p=arr[m];

    while(s<=e){

    while(arr[s]<p){
    s++;
    }
    while(arr[e]>p){
    e--;
    }
    if(s<=e){
     int temp=arr[s];
     arr[s]=arr[e];
     arr[e]=temp;
     s++;
     e--;
    }
    }
    Quicksort(arr, l, e);
    Quicksort(arr, s, h);
    }

    public static void main(String[] args) {
    int arr[]={10,5,11,3,90,2};
    // BubbleSort(arr, 0, arr.length-1);
    // SelectionSort(arr, 0, arr.length-1,0);
    // arr=MergeSort(arr);
    // MergeSortinplace(arr, 0, arr.length-1);
    // Quicksort(arr, 0, arr.length-1);
    System.out.println(Arrays.toString(arr));
    }
}