package HashMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BeakJoon_2776 {

	public static void main(String[] args) throws  IOException {
/*
 * 
 * 해시맵 기본예제
 * 
 * 백준 2776번
 * 
 * 
 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int testCase = Integer.parseInt(br.readLine());
		
		//testcase
		for(int i=0;i<testCase;i++) {
			int N=Integer.parseInt(br.readLine());//수첩 1
			StringTokenizer st = new StringTokenizer(br.readLine());//수첩 1 토큰화
			
			HashMap<Integer, Boolean> hm = new HashMap<>();
			for(int j=0;j<N;j++) { 
				hm.put(Integer.parseInt(st.nextToken()), true);//해시맵에 삽입
			}
			
			int M = Integer.parseInt(br.readLine());//수첩 2
			st=new StringTokenizer(br.readLine()); //수첩 2 토큰화
			
			for(int j=0;j<M;j++) { //비교
				if(hm.containsKey(Integer.parseInt(st.nextToken()))) {
					bw.write("1\n");
				}else {
					bw.write("0\n");
				}
				
			}
		}
		bw.flush();
        bw.close();
        br.close();//반드시 닫아줘야 함
	}

}
