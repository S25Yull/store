package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_1743 {

	//전역변수 선언
	static int N,M,K,ans,temp;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static boolean[][] map;//논리형 배열
	static boolean[][] visited;
	
	
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1]=true;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j]) {
					temp=0; //방문배열과 전체맵이 맞지 않으면 0을 줌
					dfs(i,j);
					ans = Math.max(ans, temp);//둘중의 더 큰값을 ans에 대입
				}
			}
		}
		System.out.println(ans); //결과값
		
	}
	
	//깊이우선탐색
	private static void dfs(int x, int y) {
		temp++;
		visited[x][y]=true;
		for (int k = 0; k < 4; k++) {
			int xx = x+dx[k];
			int yy = y+dy[k];
			
			if(xx<0 || yy<0 || xx>=N || yy>=M)continue;
			if(!visited[xx][yy]&& map[xx][yy]) {
				dfs(xx,yy);
			}
		}
	}

}
