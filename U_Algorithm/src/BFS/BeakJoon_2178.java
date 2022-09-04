package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BeakJoon_2178 {

	static int[][]map;
	static int n;
	static int m;
	static boolean[][]visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
	map = new int[n][m];
	for(int i=0 ; i<n;i++) {
		String s =br.readLine();
		for(int j=0;j<m;j++) {
			map[i][j]=s.charAt(j) - '0'; //0을 제외한 숫자가 길임
		}
	}
	visited = new boolean[n][m];
	visited[0][0]=true;//방문 배열 초기화
	bfs(0,0);
	System.out.println(map[n-1][m-1]);
	
	}//main

	private static void bfs(int x, int y) {
		Queue<int[]>q = new LinkedList<>();
		q.add(new int[] {x,y});//큐에 값 삽입
		
		while(!q.isEmpty()) {
			int now[] = q.poll();//큐에서 값을 꺼냄
			int nowX = now[0];
			int nowY = now[1];//현재 좌표
			
			for(int i=0;i<4;i++) { //4=dx.length
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
        		    continue; //미로 범위 빠져나가지 않게 설정
		        if (visited[nextX][nextY] || map[nextX][nextY] == 0)
            		continue;
		        
		        q.add(new int[] {nextX , nextY});
		        map[nextX][nextY] = map[nowX][nowY]+1;//1씩 더해줘서 15까지 가게 함
		        visited[nextX][nextY] =true;
			}
			
		
		}
		
	}

}
