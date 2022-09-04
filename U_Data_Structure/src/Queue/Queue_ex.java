package Queue;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class Queue_ex {

	public static void main(String[] args) {
/*
 * 
 * 큐의 정의
 * 
 * poll은 하나씩 지움
 */
		
		Queue<String>queue = new LinkedList<>();
		
		
		queue.add("data1");
		queue.add("data2");
		queue.add("data3");

	
		System.out.println(queue.poll());//첫번째 값을 반환하고 큐에서 제거
		
		
		
		
		
		//ystem.out.println(queue.remove());
		//queue.clear();
	}

}
