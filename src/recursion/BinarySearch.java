package recursion;

import java.util.Scanner;

public class BinarySearch {
    public static int binarySearchHelper(int n,int[]data,int start,int end){
        if(start<=end){
            int mid=start+(end-start)/2;
            if(data[mid]==n){
                return mid;
            }
            if(data[mid]<n){
                return binarySearchHelper(n,data,mid+1,end);
            }
            if(data[mid]>n){
                return binarySearchHelper(n,data,start,mid-1);
            }
        }
        return -1;
    }

    public static int binarySearch(int n,int []data){
        int start=0;
        int end= data.length-1;
        return binarySearchHelper(n,data,start,end);

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number to be searched");
        int n=sc.nextInt();
        System.out.println("Enter the sorted array");
        int data[]=new int[6];
        for(int i=0;i< data.length;i++){
            data[i]=sc.nextInt();
        }
        System.out.println(binarySearch(n,data));
    }
}
