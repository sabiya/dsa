package greedy.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class EdgeWeightedGraph {

	int V;
	int E;
	Vertex [] vertices;
	
	public EdgeWeightedGraph(int v) {
		super();
		this.V = v;
		vertices = new Vertex[v];
		for(int j=0; j<v;j++){
			vertices[j] = new Vertex();
		}
	}

	public void addEdge(int u, int v, double weight) {
		Edge edge = new Edge(u,v, weight);
		vertices[u].addEdge(edge);
		vertices[v].addEdge(edge);
		
	}
	public Iterator<Edge> getEdges(int u) {
		return vertices[u].iterator();
	}
	
	public List<Edge> getEdges() {
		Set<Edge> edges = new LinkedHashSet<Edge>();
		List<Edge> e = new ArrayList<Edge>(edges.size());
	
		for (int v=0; v< V; v++){
			Vertex vertex = vertices[v];
			edges.addAll(vertex.edges);
		}
		e.addAll(edges);
		Collections.sort(e);
		return e;
		
	}
	class Vertex {
		Set<Edge> edges;
		public Vertex() {
			edges = new LinkedHashSet<Edge>();
		}
		public Iterator<Edge> iterator() {
			return edges.iterator();
		}
		public void addEdge(Edge edge) {
			edges.add(edge);
		}

	}
	
	
	
	
}
