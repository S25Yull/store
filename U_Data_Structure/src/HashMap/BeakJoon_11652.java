package HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BeakJoon_11652 {
/*
 * 
 * 가장 많이 입력된 수 출력
 * 
 */
	public static void main(String[] args)throws java.lang.Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//형변환
		
		HashMap<Long , Integer> cards = new HashMap<>();
		
		int max = 0;
		long x = 0;
		for(int i=0;i<N;i++) {
			long card=Long.parseLong(br.readLine());//입력
			
			cards.put(card,cards.getOrDefault(card, 0) + 1 );//해시맵 삽입
			//입력받은 수가 해시맵의 키 값이 되는것
			if(cards.get(card)>max) {
				max=cards.get(card);
				x=card; //맥스 임시저장
			}else if(cards.get(card)==max) {
				x=Math.min(x, card);
			}
		}
		System.out.println(x);
	}

}
