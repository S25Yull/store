package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BeakJoon_1715 {

	public static void main(String[] args)throws Exception {
/*
 * 
 * 그리디 + 큐
 * 
 * 
 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> cardQueue = new PriorityQueue<Integer>();//카드를 오름차순으로 정리하기 위해
		List<Integer>list = new ArrayList<Integer>();
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i=0;i<count;i++) {
			
			cardQueue.offer(Integer.parseInt(br.readLine()));//들어온값을 큐에 저장
		}
		int sum = Integer.MAX_VALUE; //정수의 최대값 반환하는 메소드 초기화
		if(count == 1) {
			sum=0;
		}
		else {
			while(true) { //넘버 변수가 두개인 이유는 카드 뭉치가 두개이기 때문
				int number1=cardQueue.poll();
				int number2=0;
				if(!cardQueue.isEmpty())  //큐가 비어있지 않을때
					number2=cardQueue.poll();
					
					list.add(number1, number2);
					
				if(cardQueue.isEmpty())
					break;
				
				cardQueue.offer(number1+number2);
				
				
			}
			sum = list.stream().mapToInt(Integer::intValue).sum();
			
		}
		bw.write(sum);
		bw.flush();
		bw.close();
	}

}
