package HashMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BeakJoon_10816 {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	
	public static void main(String[] args)throws IOException {
/*
 * 
 * 해시맵 연습하기 백준 10816
 * 
 */
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Integer,Integer> map = new HashMap<>();
		tokens = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(tokens.nextToken());
			if(!map.containsKey(num)) { //처음 들어가는 값일 경우
				map.put(num, 1);
			}else {
				int newValue=map.get(num)+1;
				map.put(num, newValue);
			}
		}//for
		
		//비교 , 결과
		int M=Integer.parseInt(br.readLine());
		tokens= new StringTokenizer(br.readLine());
		
		for(int i=0;i<M;i++) {
			int num=Integer.parseInt(tokens.nextToken());
			if(map.containsKey(num)) { //값이 존재할 경우
				bw.write(map.get(num) + " ");
			}else {
				bw.write("0 ");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
