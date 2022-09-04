package Graph;

	
public class graph_ex {

	public static void main(String[] args) {
		GraphArray ga = new GraphArray(7);
		ga.addCompleteEdge(1, 2);
		ga.addCompleteEdge(1, 3);
		ga.addCompleteEdge(2, 4);
		ga.addCompleteEdge(2, 5);
		ga.addCompleteEdge(3, 5);
		ga.addCompleteEdge(4, 7);
		ga.addCompleteEdge(5, 7);
		ga.addCompleteEdge(6, 7);
		ga.printArray();
	}
}
