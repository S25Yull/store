package Graph;

public class gragh_list_main {

	public static void main(String[] args) {

		gragh_list_main p = new gragh_list_main();
		
		int n=5;
		
		gragh_list aj = new gragh_list(n);
		
		aj.addEdge(1, 2);
		aj.addEdge(1, 3);
		aj.addEdge(3, 4);
		aj.addEdge(3, 5);
		
		aj.printG();
		
	}

}
