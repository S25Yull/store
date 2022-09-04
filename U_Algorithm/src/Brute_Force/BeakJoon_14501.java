package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_14501 {

	private static int[][]arr;
	private static int N;
	private static int max; //최대수익
	
	public static void main(String[] args)throws NullPointerException,IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][2];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); //시간
			arr[i][1] = Integer.parseInt(st.nextToken()); //수익		
		}
		
		go(1,0);//첫날부터 시작
		System.out.println(max);
		
	}//main

	//brute Force
	private static void go(int index, int sum) {

		if(max < sum) {
			max = sum;
		}
		if(index > N) { //퇴사가 N임
			return;
		}
		
		//상담 할수 있는지 검사
		int tmp = index + arr[index][0]; //tmp는 상담일수
		if(tmp <= N + 1) {
			go(tmp , sum + arr[index][1]);
		}
		go(index + 1,sum);
	}

}
