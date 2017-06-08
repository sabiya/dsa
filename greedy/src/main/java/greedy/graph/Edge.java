package greedy.graph;

/**
 * @author sabiya
 *
 */
/**
 * @author sabiya
 *
 */
class Edge implements Comparable<Edge>{
	
	/**
	 * 
	 */
	int u;
	/**
	 * 
	 */
	int v;
	/**
	 * 
	 */
	double weight;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + u;
		result = prime * result + v;
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (u != other.u)
			return false;
		if (v != other.v)
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		if(u != other.v && v != other.u && weight != other.weight )
			return  false;
		return true;
	}

	public Edge(int u, int v, double weight) {
		super();
		this.u = u;
		this.v = v;
		this.weight = weight;
	}

	int either(){
		return u;
	}
	int other(int vertex){
		if(u == vertex)
			return v;
		else if(v == vertex)
			return u;
		else throw new RuntimeException("Invalid argument"); 
	}


	@Override
	public int compareTo(Edge o) {
		if(this.weight < o.weight) return -1;
		if(this.weight > o.weight) return 1;
		return 0;
	}
	@Override
	public String toString(){
		return " " + this.u + "->" + this.v + " :" + this.weight;
	}
	
}