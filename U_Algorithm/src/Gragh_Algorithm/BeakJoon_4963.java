package Gragh_Algorithm;

import java.util.Scanner;

public class BeakJoon_4963 {

	static int count;
	static int[] dx= {-1,-1,0,1,1,1,0,-1};
	static int[] dy= {0,1,1,1,0,-1,-1,-1};
	static int[][] map = new int[50][50];
	 static int height;
	 static int weight;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuffer sb =new StringBuffer();
		while(true) {
			weight = sc.nextInt();
			height = sc.nextInt();
			if(weight ==0 && height==0)break;//종료조건
				
			for(int i=0;i<50;i++) {
				for(int j=0;j<50;j++) {
					map[i][j]=0;
				}
			}
			
		for(int i=0;i<height;i++) {
			for(int j=0;j<weight;j++) {
				map[i][j]=sc.nextInt();//섬 입력
			}
		}
			for(int i=0;i<height;i++) {//섬 갯수 계산
				for(int j=0;j<weight;j++) {
					if(map[i][j]==1) {
						countIsland(i,j);
						count++;
					}
				}
			}
			sb.append(count+"\n");
			count=0;
		}
		System.out.println(sb);
	}

	private static void countIsland(int h, int w) {
		int nx=0;
		int ny=0;
		map[h][w]=2;
		for(int i=0;i<8;i++) {
			nx=w+dx[i];
			ny=h+dy[i];
			
			if(nx>=weight || nx<0 || ny>=height || ny<0) {
				continue;
			}
			if(map[ny][nx]==1) {
				countIsland(ny,nx);
			}
		}
	}

}
