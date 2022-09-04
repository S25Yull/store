package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_5585 {

	public static void main(String[] args) throws IOException {

		/*
		 * 
		 * 그리디 알고리즘
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cost = Integer.parseInt(br.readLine()); //예외처리 필요함
		int[] coinArr= {500,100,50,10,5,1};
		cost = 1000-cost;
		int num=0; //동전 지불하는 횟수
		for(int i=0;i<6;i++) {
			
			if(cost/coinArr[i]>0) {
				num+=cost/coinArr[i];
				cost=cost%coinArr[i];
				
				
			}
			
		}
		System.out.println(num);
	}

}
