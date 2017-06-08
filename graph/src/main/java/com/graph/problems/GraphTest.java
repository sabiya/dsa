package com.graph.problems;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author sabiya
 *
 */
public class GraphTest {

	@Ignore
	public void testGraphCreation(){
		
		Graph g = new Graph(5);
		g.addEdge(0,  1);
		g.addEdge(0, 4);
		g.addEdge(1, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		
		g.bfs(0);
		System.out.println("Cycle: " + g.detectCycle());
	    Graph g1 = new Graph(3);
		g1.addEdge(0,  1);
		g1.addEdge(0, 2);
		System.out.println("Cycle: " + g1.detectCycle());
	}
	
	
	
	@Test
	public void creatMST() {
		Graph g = new Graph(5);
		g.addEdge(0, 1, 2);
		g.addEdge(0, 3, 6);
		g.addEdge(1, 2, 3);
		g.addEdge(1, 3, 8);
		g.addEdge(1, 4, 5);
		g.addEdge(2, 4, 7);
		g.addEdge(3, 4, 9);
		g.prims();
		
		
	}
}
