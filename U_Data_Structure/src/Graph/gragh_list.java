package Graph;

import java.util.LinkedList;

public class gragh_list {

	private LinkedList<Integer>[] adj;
	private int v; 

	public gragh_list(int v) { //v는 메인 메소드에서 n을 의미함
		super();
		this.v=v;
		adj = new LinkedList[v+1];//0의 자리는 비워둠
		
		for(int i=0;i<v+1;i++) {
			adj[i] = new LinkedList();
		}
		
	}
	//정점끼리 연결
	public void addEdge(int v1 , int v2) {
		adj[v1].add(v2);
		adj[v2].add(v1);
	}
	
	public void printG() {
		for(int i=1;i<adj.length;i++) {
			System.out.println("node" + i+"와 인접노드 : "+adj[i]);
		}
	}
	
	
	
	
	
    }
    



