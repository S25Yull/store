package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BeakJoon_12100 {

	
	static int N;
	static int[][]map;
	static Deque<Integer> dq;
	static int max = 0;
	
	
	
	///메인
	public static void main(String[] args)throws IOException {
/*
 * 
 * 2048  left right up down
 * 
 * 
 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		map= new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine(), " " );
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}//for
		dq = new ArrayDeque<Integer>();
		dfs(0,map);
		System.out.println(max);
	}//main



	static void dfs(int cnt, int[][] arr) {

		if(cnt==5) { //5회
			int temp = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					temp = Math.max(temp, arr[i][j]);
				}
			}
			max = Math.max(temp,max); //둘중 더 큰값 반환
			return;
		}
		for(int i=0;i<4;i++) { //1~4 회
			dfs(cnt+1,move(i,arr));
		}
		
	}



	private static int[][] move(int x, int[][] arr) {
		if(x==0) return moveUp(arr);
		else if(x==1) return moveDown(arr);
		else if(x==2) return moveLeft(arr);
		else return moveRight(arr);
		
	}



	private static int[][] moveRight(int[][] arr) {
		int[][] temp = new int[N][N];
		for (int i=0;i<N;i++) {
			dq.clear();
			for (int j=N-1;j>=0;j--) {
				if (arr[i][j]==0) continue;
				if (!dq.isEmpty() && dq.getLast().intValue()==arr[i][j]) {
					dq.pollLast();
					dq.offer(arr[i][j]*(-2));	// 연속해서 합쳐지면 안 됨
				}else {
					dq.offer(arr[i][j]);
				}
			}
			int idx = N-1;
			while (!dq.isEmpty()) {
				temp[i][idx--] = Math.abs(dq.pollFirst());
			}
			for (int j=idx;j>=0;j--) {
				temp[i][j] = 0;
			}
			
		}
//		print();
		return temp;

	}



	private static int[][] moveLeft(int[][] arr) {
		int[][] temp = new int[N][N];
		for (int i=0;i<N;i++) {
			dq.clear();
			for (int j=0;j<N;j++) {
				if (arr[i][j]==0) continue;
				if (!dq.isEmpty() && dq.getLast().intValue()==arr[i][j]) {
					dq.pollLast();
					dq.offer(arr[i][j]*(-2));	// 연속해서 합쳐지면 안 됨
				}else {
					dq.offer(arr[i][j]);
				}
			}
			int idx = 0;
			while (!dq.isEmpty()) {
				temp[i][idx++] = Math.abs(dq.pollFirst());
			}
			for (int j=idx;j<N;j++) {
				temp[i][j] = 0;
			}
			
		}
//		print();
		return temp;
	}



	private static int[][] moveDown(int[][] arr) {

		int[][] temp = new int[N][N];
		for (int j=0;j<N;j++) {
			dq.clear();
			for (int i=N-1;i>=0;i--) {
				if (arr[i][j]==0) continue;
				if (!dq.isEmpty() && dq.getLast().intValue()==arr[i][j]) {
					dq.pollLast();
					dq.offer(arr[i][j]*(-2));	// 연속해서 합쳐지면 안 됨
				}else {
					dq.offer(arr[i][j]);
				}
			}
			
			int idx = N-1;
			while (!dq.isEmpty()) {
				temp[idx--][j] = Math.abs(dq.pollFirst());
			}
			for (int i=idx;i>=0;i--) {
				temp[i][j] = 0;
			}
			
		}
//		print();
		return temp;
		

	}



	private static int[][] moveUp(int[][] arr) {

		int [][]temp = new int[N][N];
		for(int j=0;j<N;j++) {
			dq.clear();
			for(int i=0;i<N;i++) {
				if(arr[i][j]==0) continue;
				if(!dq.isEmpty()&&dq.getLast().intValue()==arr[i][j]) {//값이 똑같을때만 더함
					dq.pollLast();
					dq.offer(arr[i][j]*(-2));
				}else {
					dq.offer(arr[i][j]);
				}
			}
			int idx=0;
			while(!dq.isEmpty()) {
				temp[idx++][j] = Math.abs(dq.pollFirst());
				
			}
			for(int i=idx;i<N;i++) {
				temp[i][j]=0;
			}
		}
		return temp;
	}

}//class
