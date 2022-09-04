package BFS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BeakJoon_1303 {

	//전투
	
	static int N; // 가로
	static int M; // 세로
	static int count;
	static int white_count = 0;
	static int black_count = 0;

	static Queue<Node> que = new LinkedList<>();
	static int dy[] = {-1, 1, 0, 0}; // 상 하 좌 우
	static int dx[] = {0, 0, -1, 1}; // 상 하 좌 우
	static boolean Visited_arr[][];
	static char map[][];

	// Queue에 x, y좌표를 담기위해 만든 생성자 
	static class Node {
		int x;
		int y;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	} // End Node

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로
		M = Integer.parseInt(st.nextToken()); // 새로

		// 방문 여부를 체크하는 배열
		Visited_arr = new boolean[M][N];

		// 흰색과 파란색을 넣을 만들 지도 (배열)
		map = new char[M][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();

			for(int j=0; j<N; j++) {
				char ch = temp.charAt(j);
				map[i][j] = ch;
			}
		}

		// 2차원 배열 순환
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {

				// false -> 방문한적이없는 곳일 경우
				if( Visited_arr[i][j] == false) {
		
					if(map[i][j] == 'W') {
						int num = BFS(i, j, 'W');
						white_count += num * num;
					}
					else {
						int num = BFS(i, j, 'B');
						black_count += num * num;
					}

				}
			}
		}

		System.out.println(white_count + " " + black_count);
	} // End main
	
	static int BFS(int y, int x, char ch) {
		que.offer(new Node(y, x));
		count = 1;
		Visited_arr[y][x] = true;

		// BFS특성 Queue가 빌때 까지 계속해서 반복
		while( !que.isEmpty() ) {
			// 들어온 값을 que에서 하나 빼냄
			Range_check(ch); 
		}

		return count;
	} // End Function BFS
	

	static void Range_check(char ch) {
		// x y 좌표 두가지를 담기위해 Node형으로 Queue를 만들음
		Node now = que.poll();

		for(int i=0; i<4; i++) {

			int now_y = now.y + dy[i];
			int now_x = now.x + dx[i];

			if(now_y >= 0 && now_y<M && now_x>=0 && now_x<N) {

				if(Visited_arr[now_y][now_x] == false && ch == map[now_y][now_x] ) {

					que.offer(new Node(now_y, now_x));
					Visited_arr[now_y][now_x] = true;
					count++;
				}

			}	
		} //End for
	} // End Range_check

} // End Class