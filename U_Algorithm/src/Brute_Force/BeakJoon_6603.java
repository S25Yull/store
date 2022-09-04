package Brute_Force;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BeakJoon_6603 {

	static int k;
	static int[]s;
	static boolean [] chk;
	
	
	public static void main(String[] args)throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String testCase = br.readLine();//인풋
			if(testCase.equals("0"))break;
			String[]input = testCase.split(" ");//문자열 분리
			
					k=Integer.parseInt(input[0]);//배열의 갯수 ,즉 입력받을때 각 줄의 첫번째 자리	
					
					s=new int[k];
					chk=new boolean[k];
					for(int i=0;i<k;i++) {
						s[i]=Integer.parseInt(input[i+1]);//인풋을 에스에다가 옮겨줌
					}//초기값 세팅
					dfs(0,0);
					System.out.println();
		}
	
	}


	private static void dfs(int depth, int start) {

		if(depth==6) {
			for(int i=0;i<k;i++) {
				if(chk[i]) {//트루면 실행
					System.out.print(s[i]+" ");//공백을 기준으로 문자열 분리
				}
			}
			System.out.println();
		}//if
		
		//완전탐색_백트래킹
		for(int i=start;i<k;i++) {
			chk[i]=true;
			dfs(depth+1,i+1);
			chk[i]=false;
		}
	}

}
