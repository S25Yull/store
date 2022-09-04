package Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BeakJoon_1431_Comparator {

	public static void main(String[] args) {

		//Comparator 정렬
		
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		
		String [] arr = new String[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.next(); //기타 입력받음
		}
		
		
		//오버라이드
		Arrays.sort(arr, new Comparator <String>() { //첫번째 매개변수는 희망 정렬 배열
			//두번째 매개변수는 새로운 comparator를 생성하여 넣어준 것
			
			@Override
			
			public int compare(String o1, String o2) {

				if(o1.length() == o2.length()) {
					//만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
					int sum1 = 0;
					int sum2 = 0;
					
					for(int i =0; i < o1.length(); i++) {
						if (o1.charAt(i) <= '9' && o1.charAt(i) >= '0') {
							sum1+=Integer.parseInt(String.valueOf(o1.charAt(i)));
							
						}
					}
					
					for(int i =0; i < o2.length(); i++) {
						if (o2.charAt(i) <= '9' && o2.charAt(i) >= '0') {
							sum2+=Integer.parseInt(String.valueOf(o2.charAt(i)));
							
						}
					}
					if(sum1 == sum2) {
						return o1.compareTo(o2);//두개의 값을 비교하여 인트 값으로 반환
					}
					else 
						return sum1 - sum2;
				}//if
				else {
					return o1.length() - o2.length();
				}//else
				
				
			}//override
			

	});//array.sort

		//출력
		for(int i=0;i<N;i++) {
			System.out.println(arr[i]);
		}
		
}// main
}// class
