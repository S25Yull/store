package Stack;

import java.util.Scanner;
import java.util.Stack;

public class BeakJoon_10773 {

	public static void main(String[] args) {
/*
 * 
 * 
 * 스택을 활용한 문제풀이 
 * 
 * 백준 10773
 * 
 * 0이 입력되면 가장 최근에 추가된 값을 삭제
 * 
 * 최종적으로 남아있는 수의 합을 출력
 * 
 */
		
		Scanner input = new Scanner(System.in); 
		Stack<Integer>stack = new Stack<Integer>();
		
		int K = input.nextInt();
		
		for(int i=0;i<K;i++){
			int number=input.nextInt();
			
			if(number==0) {
				stack.pop();
			}else {
				stack.push(number);
			}
			
			
		}
		int sum=0;
		
		for(int o : stack) {
			sum = sum + o;
		}
 
		System.out.println(sum);		
	}
 
}