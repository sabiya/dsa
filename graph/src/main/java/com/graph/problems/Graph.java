package com.graph.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sabiya
 *
 */
public class Graph {

	Node[] adj;
	int vcount;
	Edge [] edges = new Edge[100];
	int ecount = 0;
	class Node {
		int dest;
		int weight;
		Node next;
		public Node(int dest){
			this.dest = dest;
		}
		public Node(int dest, int weight){
			this(dest);
			this.weight = weight;
		}
	}
	class Edge {
		int u;
		int v;
		double weight;
		
		public Edge(int u, int v){
			this.u = u;
			this.v = v;
		}
	}
	
	Graph(int vcount) {
		this.vcount = vcount;
		this.adj = new Node[vcount];
	}
	
	public void addEdge(int src, int dest) {
	addEdge(src, dest, 0);
	}
	
	public void addEdge(int src, int dest, int weight)
	{
		Node edgeNode = new Node(dest, weight);
		edgeNode.next = adj[src];
		adj[src] = edgeNode;
		
		//It's undirected graph, so add edge for destination, source
		Node edgeNodeDest = new Node(src, weight);
		edgeNodeDest.next = adj[dest];
		adj[dest] = edgeNodeDest;
		edges[ecount++] = new Edge(src,dest);
	}
	
	public void bfs(int v) {
		
		boolean [] visited = new boolean[vcount];
		for(int i=0;i<vcount; i++) {
			visited[i] = false;
		}
		List<Integer> queue = new ArrayList<Integer> ();
		queue.add(v);
		visited[v] = true;
		while(!queue.isEmpty()){
			
			int vertex = queue.remove(0);
			System.out.println(vertex);
			Node p = adj[vertex];
			while(p!=null) {
				if(!visited[p.dest]) {
					visited[p.dest] = true;
					queue.add(p.dest);
				}
				p = p.next;
			}
			
		}
		
		
	}
	boolean detectCycle() {
		int parent[] = new int[vcount];
		for(int i=0; i<vcount; i++) {
			parent[i] = -1;
		}
		for (int e=0; e<ecount; e++) {
			Edge edge = edges[e];
			int s = edge.u;
			int d = edge.v;
			int ps = parent(parent, s);
			int pd = parent(parent, d);
			if(ps == pd)
				return true;
			else
				union(parent, s, pd);
		}
		return false;

	}
	private void union(int[] parent, int u, int pd) {
		// TODO Auto-generated method stub
		if(parent[u] == -1)
		{
			parent[u] = pd;
		}
		else{
			union(parent, parent[u], pd);
		}
	}
		

	/**
	 * @param parent
	 * @param s
	 * @return
	 */
	private int parent(int[] parent, int s) {
		if(parent[s] == -1)
			return s;
		else
			return(parent(parent, parent[s]));
	}

	public void prims() {
		boolean visited[] = new boolean[vcount];
		int keys [] = new int[vcount];
		int parent[] = new int[vcount];
		for(int i=0;i<vcount; i++){
			keys[i] = Integer.MAX_VALUE;
			visited[i] = false;
			parent[i] = -1;
		}
		keys[0] = 0;
		for(int count = 1; count<=vcount; count++){

			int  v = findMin(keys, visited, vcount);
//			if(v != -1) {
				visited[v] = true;
				Node p = adj[v];
				while(p!=null) {

					if(!visited[p.dest] && p.weight < keys[p.dest])
					{
						parent[p.dest] = v;
						keys[p.dest] = p.weight;

					}
					p = p.next;

				}
//			}
			
		}
		
		print(parent, keys);
		
	}
	private void print(int[] parent, int keys[]) {
		for(int i=0;i<vcount; i++){
			if(parent [i] == -1)
				continue;
			 System.out.println("Edge : (" + parent[i] + ", " + i + " ) :" + keys[i]);
			
		}
		
	}

	private int findMin(int[] keys, boolean[] visited, int vcount2) {
		
		int min = Integer.MAX_VALUE;
		int v =-1;
		for(int i=0;i<vcount; i++) {
			if(!visited[i] && min>keys[i]){
				min = keys[i];
				v= i;
			} 
				
		}
		return v;
	}

	public void printGraph() {
		
		for (int v = 0; v<vcount; v++) {
			Node ptr = adj[v];
			System.out.println("\nAdj List for :" + v);
			while(ptr!=null) {
				System.out.print(ptr.dest + "->" );
				ptr = ptr.next;
			}
		}
	}
}

