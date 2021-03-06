package helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edge.Edge;
import edge.NetworkConnection;
import edge.WordEdge;
import vertex.Computer;
import vertex.Router;
import vertex.Server;
import vertex.Vertex;
import vertex.Word;
import e.exception1;
import e.exception3;
import e.exception5;;

public class ParseCommandHelper {
	
	public List<Edge> getEdge(String fileName){
		List<Edge> E =new ArrayList<Edge>();
		File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
            	if(Pattern.matches(".*Edge.*", tempString) && !Pattern.matches(".*EdgeT.*", tempString)) {
            		try {
								E.add(makee(getst(tempString)));
						}
					catch (exception5 e) {
								e.printStackTrace();
							}
					catch (exception3 e) {
							e.printStackTrace();
						}
					catch (exception1 e) {
						e.printStackTrace();
					}
            		try {
						if(getst(tempString).get(5).equals("NO")) {
							E.add(makene(getst(tempString)));
						}
					} catch (exception1 e) {
						e.printStackTrace();
					}
            	}
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
		return E;
	}
	
	private Edge makene(List<String> l) {
		if(l.get(1).equals("WordEdge")) {
			WordEdge w = new WordEdge(l.get(0)+"*");
			double d = Double.parseDouble(l.get(2));
			w.setWeight(d);
			w.setStartVertex(new Word(l.get(4)));
			w.setEndVertex(new Word(l.get(3)));
			return w;
		}
		return null;
	}

	private Edge makee(List<String> l) throws exception3, exception5{
		if(l.get(1).equals("NetworkConnection")) {
			NetworkConnection n = new NetworkConnection(l.get(0));
			double d = Double.parseDouble(l.get(2));
			if(d<=0||d>1) {
				throw new exception5();
			}
			n.setWeight(d);
			n.getStartVertex().setname(l.get(3));
			n.getEndVertex().setname(l.get(4));
			if(l.size()>5) {
				throw new exception3();
			}
			return n;
		}else if(l.get(1).equals("WordEdge")) {
			WordEdge w = new WordEdge(l.get(0));
			double d = Double.parseDouble(l.get(2));
			if(d<=0) {
				throw new exception5();
			}
			w.setWeight(d);
			w.setStartVertex(new Word(l.get(3)));
			w.setEndVertex(new Word(l.get(4)));
			if(l.size()>5) {
				throw new exception3();
			}
			return w;
		}
		return null;
	}

	public List<Vertex> getVertex(String fileName){
		List<Vertex> v =new ArrayList<Vertex>();
		File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
            	if(Pattern.matches(".*Vertex.*", tempString) && !Pattern.matches(".*VertexT.*", tempString)) {
            		try {
						v.add(makev(getst(tempString)));
					} catch (exception1 e) {
						e.printStackTrace();
					}
            	}
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
		return v;
	}
	private Vertex makev(List<String> list) {
		if(list.get(1).equals("Computer")) {
			Computer c = new Computer(list.get(0));
			c.setIP(list.get(3));
			return c;
		}else if(list.get(1).equals("Router")) {
			Router r = new Router(list.get(0));
			r.setIP(list.get(3));
			return r;
		}else if(list.get(1).equals("Server")) {
			Server sr = new Server(list.get(0));
			sr.setIP(list.get(3));
			return sr;
		}else if(list.get(1).equals("Word")) {
			Word w = new Word(list.get(0));
			return w;
		}
		return null;
	}
	public List<String> getEdgeType(String fileName){
		File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
            	if(Pattern.matches(".*EdgeType.*", tempString)) {
            		try {
						return getst(tempString);
					} catch (exception1 e) {
						e.printStackTrace();
					}
            	}
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
		return null;
	}
	public List<String> getVertexType(String fileName){
		File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
            	if(Pattern.matches(".*VertexType.*", tempString)) {
            		try {
						return getst(tempString);
					} catch (exception1 e) {
						e.printStackTrace();
					}
            	}
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
		return null;
	}
	public String getGraohName(String fileName){
		File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
            	if(Pattern.matches(".*GraphName.*", tempString)) {
            		try {
						return getst(tempString).get(0);
					} catch (exception1 e) {
						e.printStackTrace();
					}
            	}
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
		return null;
	}
	
	public String getGraphType(String fileName) {
		File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
            	if(Pattern.matches(".*GraphType.*", tempString)) {
            		try {
						return getst(tempString).get(0);
					} catch (exception1 e) {
						e.printStackTrace();
					}
            	}
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
		return null;
	}
	public List<String> getst(String t) throws exception1{
		List<String> st = new ArrayList<String>();
		Pattern p = Pattern.compile("\"");
	    Matcher m = p.matcher(t);
	    int count=0;
	    int x=0;
	    int y=0;
	    while(m.find()) {
	    	count++;
	    	if(count%2==1) {
	    		x=m.start()+1;
	    	}
	    	if(count%2==0) {
	    		y=m.start();
				char[] c=new char[y-x];
	    		for(int i=x;i<y;i++) {
	    			c[i-x]=t.toCharArray()[i];
	    		}
	    		String s;
	    		s=String.valueOf(c);
	    		st.add(s);
	    	}
	    }
	    if(!st.get(st.size()-1).equals("N") || st.get(st.size()-1).equals("Y")) {
	    	throw new exception1();
	    }
		return st; 
	}
}
