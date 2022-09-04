package Sort;

import java.util.Scanner;

public class Jungol_1146_Select {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int [N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int mn = 2147000000;
		int tmp = 0;
		int d = 0;
		for (int i = 0; i < N - 1; i++) {
			mn = 2147000000;
			for (int j = i; j < N; j++) {
				if(arr[j] < mn) {
					mn = arr[j];
					d = j;
				}
			}
			tmp = arr[i];
			arr[i] = mn;
			arr[d] = tmp;
			
			//출력
			for (int j = 0; j < N; j++){
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
		
	}
}
