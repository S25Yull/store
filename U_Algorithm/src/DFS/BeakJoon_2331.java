package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BeakJoon_2331 {

	//입력: 57 , 2
	//출력: 4
	
	static int base;
	static int power;
	static int count;
	static HashMap<Integer , Integer > mem;
	static ArrayList<Integer>a; //전체 배열 (값을 담는 역할)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		base=sc.nextInt(); //57
		power=sc.nextInt();
		mem = new HashMap<>();
		a= new ArrayList<>();
		count = 0;
		a.add(base);
		mem.put(base, 1);
		cal();
		
		System.out.println(a.indexOf(base));//특정 문자 찾기 , 
		//만약 찾지 못했을 경우 -1을 반환 , 시작할 위치를 지정하는것도 가능 , 
		//생략할시 0부터 탐색 시작
	}

	private static void cal() {

		int tmp = base;
		int sum=0;
		
		while(true) {
			sum+=(int)Math.pow(tmp%10, power);//숫자를 분리 후 power의 숫자만큼 제곱해서 누적
			tmp=tmp/10; 
			if(tmp/10==0) {
				sum+=(int)Math.pow(tmp, power);
				break;
			}
	   	}
	   	base = sum;
	       while(!mem.containsKey(base)){

	           mem.put(base,1);
	           a.add(base);
	       
	       cal();

	       }
	   }
	}
