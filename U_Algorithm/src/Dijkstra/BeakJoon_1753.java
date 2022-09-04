package Dijkstra;

import java.io.*;
import java.util.*;

//다익스트라 알고리즘 구현


      class Node implements Comparable<Node>{
    	  int end, weight;
    	  
    	  public Node(int end, int weight) {
    		  this.end = end;
    		  this.weight = weight;
    		  
    	  }
    	  @Override
    	  public int compareTo(Node o) {
    		  return weight = o.weight;
    	  }
      }
public class BeakJoon_1753 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static  final int INF = 100_000_000;
	static int v ,e ,k;
	static List<Node>[] list;
	static int[] dist;
	
	public static void main(String[] args)throws IOException {

		StringTokenizer st = new StringTokenizer (br.readLine());
		v = Integer.parseInt(st.nextToken()); //정점
        e = Integer.parseInt(st.nextToken()); //간선
        k = Integer.parseInt(br.readLine()); //입력받을 수
        list = new ArrayList[v + 1];
        dist = new int[v+1];
        
        Arrays.fill(dist, INF);
        for(int i =1 ;i<=v; i++) {
        	list[i] = new ArrayList<>();//리스트를 어레이리스트로 설정
        }
        
        //리스트에 그래프 정보를 초기화
        for(int i =1;i<e;i++) {
        	 st = new StringTokenizer(br.readLine());
        	 int start = Integer.parseInt(st.nextToken());
             int end = Integer.parseInt(st.nextToken());
             int weight = Integer.parseInt(st.nextToken());
             list[start].add(new Node(end, weight));
        }
        StringBuilder sb = new StringBuilder();
        
        dijkstra(k);
        
        //출력
        for(int i=1;i<=v;i++) {
        	if(dist[i] == INF)sb.append("INF\n");
        	else sb.append(dist[i] + "\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
	
	}//main

	private static void dijkstra(int start) {

		PriorityQueue<Node> queue = new PriorityQueue<>();//우선순위 큐 생성
		boolean[]check = new boolean [v+1];
		
		queue.add(new Node(start,0));
		dist[start]=0;
		
		while(!queue.isEmpty()) {//큐가 비어있지 않으면
			Node curNode = queue.poll();
			int cur = curNode.end;
			
			if(check[cur] == true) continue;
	           check[cur] = true;

	           for(Node node : list[cur]){
	               if(dist[node.end] > dist[cur] + node.weight){
	                   dist[node.end] = dist[cur] + node.weight;
	                   queue.add(new Node(node.end, dist[node.end]));
	               }
	           }
			
		}
	}

}
