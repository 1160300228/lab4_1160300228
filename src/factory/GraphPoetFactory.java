package factory;

import e.exception2;
import e.exception6;
import e.exception7;
import graph.GraphPoet;
import helper.ParseCommandHelper;

public class GraphPoetFactory {
	public static GraphPoet createGraph(String filepath) {
		ParseCommandHelper p = new ParseCommandHelper();
		GraphPoet g = new GraphPoet(p.getGraohName(filepath));
		for(int i=0;i<p.getVertex(filepath).size();i++) {
			try {
				g.addVertex(p.getVertex(filepath).get(i));
			} catch (exception7 e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		for(int i=0;i<p.getEdge(filepath).size();i++) {
			try {
				try {
					g.addEdge(p.getEdge(filepath).get(i));
				} catch (exception6 e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			} catch (exception2 e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		return g;		
	}
}
