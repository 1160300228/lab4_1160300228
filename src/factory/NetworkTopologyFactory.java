package factory;

import e.exception2;
import e.exception6;
import e.exception7;
import graph.NetworkTopology;
import helper.ParseCommandHelper;

public class NetworkTopologyFactory {
	public static NetworkTopology createGraph(String filepath) {
		ParseCommandHelper p = new ParseCommandHelper();
		NetworkTopology g = new NetworkTopology(p.getGraohName(filepath));
		for(int i=0;i<p.getVertex(filepath).size();i++) {
			try {
				g.addVertex(p.getVertex(filepath).get(i));
			} catch (exception7 e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		for(int i=0;i<p.getEdge(filepath).size();i++) {
			try {
				try {
					g.addEdge(p.getEdge(filepath).get(i));
				} catch (exception6 e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			} catch (exception2 e) {
				e.printStackTrace();
			}
		}
		return g;	
	}
}
