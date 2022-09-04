package Stack;

import java.util.Scanner;
import java.util.Stack;

public class BeakJoon_1874 {

	public static void main(String[] args) {

		/*
		 * push순서는 오름차순
		 * 
		 * 
		 * 
		 */
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		int N=input.nextInt(); //8
		int start=0;//0에서 value 까지를 나타낼 출발점
		while(N-->0) {
			
			int value=input.nextInt();
			
			if(value > start) {
				for(int i=start+1;i<=value;i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				start=value;  //오름차순을 유지하기 위한 변수 초기화
			}//if
			else if(stack.peek()!=value) {
				System.out.println("NO");
				return;
			}
			//조건에 속하지 않은 경우는 -
			stack.pop();
			sb.append('-').append('\n');
		}//while
		
		System.out.println(sb);
	}

}
