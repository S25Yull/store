package Stack;

import java.util.Scanner;

public class BeakJoon_10828 {

	public static int[] stack;
	public static int size = 0;

	public static void main(String[] args) {
		/*
		 * 
		 * 백준 10828번 스택
		 * 
		 * push pop size empty top
		 * 
		 * 
		 */

		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = input.nextInt();
		stack = new int[N]; // N개의 명령문 생성

		for (int i = 0; i < N; i++) {
			String str = input.next();// 각각의 명령문
			switch (str) {

			case "push":
				push(input.nextInt());
				break;

			case "pop":
				sb.append(pop()).append('\n');
				break;

			case "size":
				sb.append(size()).append('\n');
				break;

			case "empty":
				sb.append(empty()).append('\n');
				break;

			case "top":
				sb.append(top()).append('\n');
				break;

			}
		} // for
		System.out.println(sb);
	}

	public static void push(int item) { // 삽입
		stack[size] = item;
		size++;
	}

	public static int pop() { // 제거
		if (size == 0) { // 값이 하나도 없을때
			return -1;
		} else { // 값이 하나라도 있을때
			int res = stack[size - 1]; // 스택의 인덱스(사이즈)를 저장할 변수선언
			size--;
			return res;
		}

	}

	public static int size() { //갯수
			
			return size;
		}

	public static int empty() {
		if(size==0) {
			return 1;
		}else {
			return 0;
		}
		
	}

	public static int top() {
		if(size==0) {
			return -1;
		}
		else {
			return stack[size-1];
		}
	}

}// class
