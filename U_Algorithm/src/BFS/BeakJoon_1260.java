package BFS;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BeakJoon_1260 {

	static int[][]check;//간선 연결상태
	static boolean[] checked;//확인여부
	static int n;//정점
	static int m;//간선
	static int start;//시작정점
	
	
	public static void main(String[] args)throws IOException {

		//dfs 와 bfs
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		start = sc.nextInt();
		
		 check = new int[1001][1001]; //좌표를 그대로 받아들이기 위해 +1해서 선언
		  checked = new boolean[1001]; //초기값 False
		
		//간선 연결상태 저장
		for(int i=0;i<m;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			check[x][y] = check[y][x] = 1;
		}
		dfs(start);
		
		checked = new boolean[1001];
		System.out.println();
		
		bfs();
	}
	
	public static void dfs(int starti) {
		checked[starti] = true;
		System.out.print(starti+" ");
		
		for(int j=1;j<=n;j++) {
			if(check[starti][j] == 1 && checked[j] == false) {
				dfs(j);
			}
		}
	}
	
	public static void bfs() {
		
		Queue<Integer>queue = new LinkedList<Integer>();
		queue.offer(start);
		checked[start]=true;
		System.out.print(start + " ");
		
		while(!queue.isEmpty()) {
			int temp = queue.poll(); //큐에서 꺼낸 값을 변수에 대입
			
			for(int j=1;j<=n;j++) {
				if(check[temp][j]==1 && checked[j] == false) {
					queue.offer(j);
					checked[j] = true;
					System.out.print(j+" ");
				} 
			}
		}
	}

}
