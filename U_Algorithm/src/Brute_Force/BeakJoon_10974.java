package Brute_Force;

import java.util.ArrayList;
import java.util.Scanner;

public class BeakJoon_10974 {

	/*
	 * 모든 순열 구하기
	 */
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList picked = new ArrayList<Integer>();
		boolean[] check = new boolean[n+1];
		
		pick(n,picked,check);
		
	}

	//완전탐색_재귀
	private static void pick(int n, ArrayList picked, boolean[] check) {

		if(picked.size()==n) { //배열값이 입력받은 수와 동일하면 출력 여기서는 크기가 3이되면 출력함
			printAnswer(picked);
			return;
		}
		for(int i=1;i<=n;i++) { //1,2,3
			
			if(check[i]==true) {
				continue; //이미 선택한적이 있으면 다음으로
			}//if
				check[i]=true;
				picked.add(i); //숫자 순서대로 넣음
				pick(n,picked,check);
				picked.remove(picked.size()-1);//배열에 0인자부터 값을 넣었기때문에 수를 맞춰주기위해 -1

				check[i] = false;
		}//for
		
	}//pick

	//출력메소드
	private static void printAnswer(ArrayList picked) {

		for(int i=0;i<picked.size();i++) {
			System.out.print(picked.get(i)+" ");
		}
		System.out.println();//한번 턴 돌때마다 줄바꿈
		
	}
	

}//class
