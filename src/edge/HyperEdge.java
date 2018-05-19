package edge;

import java.util.ArrayList;
import java.util.List;

import vertex.Vertex;

public class HyperEdge extends Edge{
	private List<Vertex> vertices =  new ArrayList<>();
	public HyperEdge(){
		
	}
	public List<Vertex> getVertices() {
		return vertices;
	}
	public void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}
	public boolean f() {
		if(vertices.size()==1) {
			return false;
		}else {
			return true;
		}
	}
}
