package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class bfs_ex {

	public static void main(String[] args) {
		
		int[][]gragh = {{},{2,3,8},{1,6,8},{1,5},{5,7},{3,4,7},{2},{4,5},{1,2}};
		
		boolean[]visited = new boolean[9];
		
		System.out.println(bfs(1,gragh,visited));
		//출력 내용 : 1 -> 2 -> 3 -> 8 -> 6 -> 5 -> 4 -> 7 ->


	}//main

	static String bfs(int start, int [][]gragh, boolean[]visited) {
		
		StringBuilder sb = new StringBuilder(); //문자열을 연결하기 위한 클래스 생성
		Queue<Integer>q = new LinkedList<Integer>();
		
		q.offer(start); //큐 안에 값 입력
		
		visited[start]=true;
		
		//큐가 빌 때까지 반복
		
		while(!q.isEmpty()) {//큐가 비어있지 않을 때 까지
			
			int nodeIndex = q.poll(); //큐에서 뺀 값을 변수에 대입
			sb.append(nodeIndex + "->"); //append는 문자열 결합 + 변수 출력
			
			for(int i=0;i<gragh[nodeIndex].length;i++) {
				int temp = gragh[nodeIndex][i];
				
				if(!visited[temp]) {
					visited[temp] = true;
					q.offer(temp);
				}
			}
		}
		
		return sb.toString();
	}
	
}
