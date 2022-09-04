package HashMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BeakJoon_1302 {

	//형변환 메소드
		private static int stoi(String readLine) {

			
			return Integer.parseInt(readLine);
		}
	
	
	public static void main(String[] args)throws Exception {
/*
 * 해시맵 백준 1302
 * 
 * 
 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String,Integer>map=new HashMap<String,Integer>();
		String maxBook=""; //가장 많이 팔린 책의 제목
		int max = 0;
		int n=stoi(br.readLine());//BufferedReader 로 받은 값을 int 로 형변환
		
		for(int i=0;i<n;i++) {
			String book = br.readLine();
			if(!map.containsKey(book)) { //처음 나오는 값이면 삽입
				map.put(book, 1);
			}
			else {
				map.put(book, map.get(book)+1);
			}
		}//for
		
		for(String key : map.keySet()) {
			int value = map.get(key);
			
			if(max == value && maxBook.compareTo(key)>0) {
				maxBook=key;
				max=value;
			}
			else if(max<value){
				maxBook=key;
				max=value;
			}
		}
		
		System.out.println(maxBook);
		
	}//main

	
	
	

}
