package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BeakJoon_10451 {

	private static ArrayList<Integer>[] map;
	private static boolean[] visit;
	private static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 12345678
		// 주어진 순열
		
		Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//int t = Integer.parseInt(reader.readLine());
		int t = sc.nextInt();//전체 카운트 수

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {//케이스별 크기
			// t번
			//int n = Integer.parseInt(reader.readLine());
			int n = sc.nextInt();

			//인접리스트
			map = (ArrayList<Integer>[]) new ArrayList[n+1];
			visit = new boolean[n+1]; //방문확인 배열은 논리값으로 지정
			cnt = 0;
			
			//초기화
			for (int j=0; j<=n; j++) {
				map[j] = new ArrayList<Integer>();
			}
			
			//값 입력
			for (int j=1; j<=n; j++) {//노드
				//int v = Integer.parseInt(reader.readLine());
				int v = sc.nextInt();//값
				
				map[j].add(v);//노드에 값을 삽입
			}
			
			//방문 안되어 있는 리스트 탐색
			for (int j=1; j<=n; j++) {
				if (!visit[j]) { //방문이 안되어있을 경우 , 값이 visit에 안들어왔을 경우
					dfs(j);
					cnt++;
				}
			}
			sb.append(cnt + "\n"); //스트링 변수값 업데이트해서 출력
		}
		
		System.out.print(sb);

	}//main

	private static void dfs(int start) {
			
		//방문전적 있으면 종료
		if (visit[start]) {
			return;
		}
		
		//방문처리
		visit[start] = true;
		
		//해당 리스트에서 방문한적 없으면 탐색
		for (int i : map[start]) {
			if (!visit[i]) {
				dfs(i);
			}
		}
		
	}
}