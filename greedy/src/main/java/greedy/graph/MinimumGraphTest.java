package greedy.graph;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class MinimumGraphTest {

	
	@Test
	public void testMST(){
		InputStream stream = MinimumGraphTest.class.getResourceAsStream("MST.txt");
		Scanner scanner = new Scanner(stream);
		int V = scanner.nextInt();
		int E = scanner.nextInt();
		EdgeWeightedGraph g = new EdgeWeightedGraph(V);
		for(int e=1; e<=E; e++) {
			g.addEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextDouble());
		}
		
		MinimumSpanningTree tree = new MinimumSpanningTree(g);
		tree.kruskal();
		List<Edge> edges = tree.getEdges();
		for(Edge e: edges){
			System.out.println(e);
		}
		System.out.println(tree.weight());
	}
}
