package HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class BeakJoon_7785 {

	public static void main(String[] args) {
/*
 * 
 * 회사에 있는 사람 사전 역순으로 출력
 * 
 * 키 값에 이름들을 넣고 키 값이 한번 더 나오면 해시맵에서 삭제
 * 
 * 해시맵에는 아직 회사에 있는 사람들만 넣음
 * 
 */
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		HashMap <String , String> map = new HashMap<>();
		
		for(int i=0;i<n;i++) {
			String name=sc.next();
			String state=sc.next();
			
			if(map.containsKey(name)) map.remove(name);
			else map.put(name, state);
			
		}//for
		
		
			//사전 역순으로 출력
			//keySet은 key를 다 가져오는 메소드
		ArrayList<String>list = new ArrayList<String>(map.keySet());
			Collections.sort(list,Collections.reverseOrder()); //내림차순 정렬 메소드
			
			for(String li : list) {
				System.out.println(li + " ");
			}
		
		
	}

}
