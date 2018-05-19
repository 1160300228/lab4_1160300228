
package graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

import e.exception2;
import e.exception6;
import e.exception7;

public interface Graph<L,E> {
    
    public static <L,E> Graph<L,E> empty() {
    	@SuppressWarnings("unchecked")
		Graph<L,E> c = (Graph<L,E>) new ConcreteGraph();
    	return c;
    }
    
    public boolean addVertex(L vertex) throws exception7;
    
    public boolean removeVertex(L vertex);

    public Set<L> vertices();
    
    public Map<L, List<Double>> sources(L target);

    public Map<L, List<Double>> targets(L source);
    
    public boolean addEdge(E edge) throws exception2,exception6;
    
    public boolean removeEdge(E edge);
    
    public Set<E> edges(); 
    
    public List<L> vs();
    
    public List<E> es();
}