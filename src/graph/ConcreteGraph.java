package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import vertex.Vertex;
import edge.Edge;
import e.exception2;
import e.exception6;
import e.exception7;

public class ConcreteGraph implements Graph<Vertex, Edge>{

	private final List<Vertex> vertices = new ArrayList<>();
	private final List<Edge> edges = new ArrayList<>();
	
	@Override
	public boolean addVertex(Vertex vertex) throws exception7 {
		for(Vertex v:vertices) {
			if(v.getname().equals(vertex.getname())) {
				throw new exception7();
			}
		}
		return vertices.add(vertex);
	}

	@Override
	public boolean removeVertex(Vertex vertex) {
		return vertices.remove(vertex);
	}

	@Override
	public Set<Vertex> vertices() {
			Set<Vertex>  set=new HashSet<Vertex>();
		for(int i=0;i<vertices.size();i++) {
			set.add(vertices.get(i));
		}
		return set;
	}

	@Override
	public Map<Vertex, List<Double>> sources(Vertex target) {
		Map<Vertex, List<Double>> sources=new HashMap<Vertex, List<Double>>();
	for(int i=0;i<vertices.size();i++) {
		for(int j=0;j<vertices.get(i).getTargets().size();j++) {
			if(vertices.get(i).getTargets().get(j).getname().equals(target.getname())) {
				sources.put(vertices.get(i), vertices.get(i).getMap().get(target));
				
			}
		}
	}
	return sources;
	}

	@Override
	public Map<Vertex, List<Double>> targets(Vertex source) {
		for(int i=0;i<vertices.size();i++){
		if(vertices.get(i).getname().equals(source.getname())) {
			return vertices.get(i).getMap();
		}
	}
	return null;
	}

	@Override
	public boolean addEdge(Edge edge) throws exception2, exception6{	
		for(Edge e:edges) {
			if(e.getname().equals(edge.getname())) {
				throw new exception6();
			}
		}	
		for(int i=0;i<vertices.size();i++) {
			if(vertices.get(i).getname().equals(edge.getStartVertex().getname())) {
				List<Double> l =new ArrayList<Double>();
				l.add(edge.getWeight());
				vertices.get(i).addedge(edge.getEndVertex(), l);
			}
		}
		if(vertices.indexOf(edge.getStartVertex())==-1 && vertices.indexOf(edge.getEndVertex())==-1) {
			throw new exception2();
		}
		return edges.add(edge);
	}

	@Override
	public boolean removeEdge(Edge edge) {
		return edges.remove(edge);
	}

	@Override
	public Set<Edge> edges() {
		Set<Edge>  set=new HashSet<Edge>();
	for(int i=0;i<edges.size();i++) {
		set.add(edges.get(i));
	}
	return set;
	}

	@Override
	public List<Vertex> vs() {
		return vertices;
	}

	@Override
	public List<Edge> es() {
		return edges;
	}
	
}
