package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BeakJoon_1238 {

	//가장 오래걸리는 학생의 소요시간을 출력
	//파티에 참석하러 가는 경우 (다른 모든 노드들에 대해서 2번 노드로 가는 최단거리)  X를 말함
	//파티가 끝나고 다시 집으로 돌아오는 경우 (2번 노드에 대해서 다른 모든 노드들에 대한 최단거리) X를 말함
	
	private static final int INF = 1000000000;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N , M, X;
	private static List <List<Node>> list, reverseList;
	private static int[] dist,reverseDist;
	
	static class Node implements Comparable<Node>{
		int index;
		int distance;
		
		public Node (int index , int distance) {
			this.index = index;
			this.distance = distance;
		}
		public int compareTo(Node n) {
			return this.distance-n.distance;
		}
	}//node
	
	
	public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//사람 수
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()); //파티장소 _ 이 문제에서는 2번임
		
       list = new ArrayList<>();
       reverseList = new ArrayList<>();
       
       for(int i=0;i<=N;i++) { //사람 수 만큼
    	   list.add(new ArrayList<>());
    	   reverseList.add(new ArrayList<>());//각각의 어레이리스트에 넣어줌
       }
       
       
        dist = new int[N+1];
        reverseDist = new int [N+1];
        Arrays.fill(dist, INF);
        Arrays.fill(reverseDist, INF);
        
        for(int i=1;i<=M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int  u = Integer.parseInt(st.nextToken());
        	int  v = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());//시작점 ,끝점 , 소요시간을 입력받음
        	
        	list.get(u).add(new Node(v,weight)); //끝점과 소요시간을 삽입
        	reverseList.get(v).add(new Node(u,weight)); //시작점과 소요시간을 삽입
        	
        }//for
        
        
        
        dijkstra(list,dist,X);
        dijkstra(reverseList,reverseDist,X);
        
        print();
        br.close();
        
	}//main

	//다익스트라
	private static void dijkstra(List<List<Node>> list, int[] distance, int start) {
		boolean[]visited = new boolean[N+1];
		PriorityQueue <Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		
		distance[start] = 0;
		
		while(!pq.isEmpty()) {//비어있지 않을 경우
			int idx = pq.poll().index;
			
			if(visited[idx]) continue;
			visited[idx]=true;
			
			for(Node node : list.get(idx)) {
				if(distance[node.index] > distance[idx] + node.distance) {
					distance[node.index] =distance[idx] + node.distance;
					pq.add(new Node(node.index,distance[node.index]));
					
				}
			}//for
		
		}//while
		
	}//dijkstra
	

	//출력
	private static void print() {
		int ans = -1;
		for(int i=1;i<=N;i++) {
			ans = Math.max(ans, dist[i] + reverseDist[i]);
		}
		System.out.println(ans);
	}//print

}
