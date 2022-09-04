package Gragh_Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BeakJoon_2252 {

	public static void main(String[] args)throws CloneNotSupportedException {

		
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();//학생수
		int M =sc.nextInt();//횟수
		List<List<Integer>> list = new ArrayList<List<Integer>>();
	
		int [] indegree = new int[N];//위상정렬에 사용할 진입차수 저장 배열
		
		for(int i=0;i<N;i++) {
			list.add(new ArrayList());
		}
		for(int i=0;i<M;i++) {
			int front =sc.nextInt()-1;
			int back =sc.nextInt()-1;
			list.get(front).add(back);
			indegree[back]++;
		}
		위상정렬(list,indegree);
	}

	private static void 위상정렬(List<List<Integer>> list, int[] indegree) {
		// TODO Auto-generated method stub
		Queue<Integer> queue= new LinkedList<>();
		Queue<Integer> result= new LinkedList<>();
	
		for(int i=0;i<indegree.length;i++) {
			if(indegree[i] ==0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			result.add(node);
			
			for(int i=0;i<list.get(node).size();i++) {
				int n = list.get(node).get(i);
				indegree[n]--;
				
				if(indegree[n] ==0) {
					queue.add(n);
				}
			}
		}
		int size = result.size();
		for(int i=0;i<size;i++) {
			System.out.println(result.poll()+1+" ");
		}
	}

}
