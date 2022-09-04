package Sort;

import java.util.Scanner;

public class BeakJoon_2750_Select {

	public static void main(String[] args) {
		
		//입력: 5 5 2 3 4 1
	
		
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int N=in.nextInt();//전체 입력받을 숫자의 수
		int[]arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=in.nextInt();
		}
		
		//선택정렬(오름차순)
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
		}
		for(int val : arr) {//val 에서 arr 까지
			System.out.println(val);
		}
	}

}
