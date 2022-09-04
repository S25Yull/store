package Queue;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class Queue_Scanner {

	static Queue q = new LinkedList(); // 큐는 LinkedList로 생성
	static final int Max_size = 3;

	public static void main(String[] args) {
		
		
		/*
		 * 
		 * Queue ex
		 * 
		 * help //도움말 목록
		 * q //삭제
		 * history//모든 요소 출력
		 * peek
		 * clear
		 * 
		 */
		Scanner input= new Scanner(System.in);
		
		
		while(true) {
			String item = input.nextLine().trim();
			if(item.equalsIgnoreCase("q")) {
				System.exit(0);
			}
			
			else if(item.equalsIgnoreCase("help")) {
				System.out.print("help\tQ\thistory\tP\tC\t");
			}
			//큐의 모든 값 보여주기
			else if(item.equalsIgnoreCase("history")) {
				int i=0;
				LinkedList tmp = (LinkedList)q;
				ListIterator it = tmp.listIterator(); //반복
				final int SIZE = q.size();
				
				while(it.hasNext()) {
					System.out.println(++i+"."+it.next());
				}
			}
			
			else if(item.equalsIgnoreCase("c")) {
				q.clear();
			}
			else {
				q.offer(item);
				if(q.size()>Max_size) {
					System.out.println(q.poll());
				}
			}
		}
		
		
	}

}
