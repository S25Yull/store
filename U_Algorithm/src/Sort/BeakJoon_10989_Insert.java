package Sort;

import java.util.Scanner;

public class BeakJoon_10989_Insert {

	  public static void main(String[] args){
	        Scanner s = new Scanner(System.in);
	        int n = s.nextInt();

	        int[] arr = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i] = s.nextInt();
	        }
	        arr = func(arr, arr.length);

	        for(int a : arr){
	            System.out.println(a);
	        }
	    }

	    public static int[] func(int[] arr, int size){
	        for(int i=0;i<size;i++){
	            int target = arr[i];
	            int j = i=1;

	            while(j>= 0 && target < arr[j]){
	                arr[j+1] = arr[j];
	                j--;
	            }
	            arr[j+1] = target;
	        }
	        return arr;
	    }
	}