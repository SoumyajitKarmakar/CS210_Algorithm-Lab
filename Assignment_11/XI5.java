import java.util.*;
public class XI5 {
	public static strictfp void main(String... args) { // this is a driver
		ArrayList<Vertex> graph = new ArrayList<>();
		HashMap<Character, Vertex> map = new HashMap<>();
		// add vertices
		for (char c = 'a'; c <= 'i'; c++) {
			Vertex v = new Vertex(c);
			graph.add(v);
			map.put(c, v);
		}
		// add edges
		for (Vertex v: graph) {
			if (v.getNodeId() == 'a') {
				v.getAdjacents().add(map.get('b'));
				v.getAdjacents().add(map.get('h'));
			} else if (v.getNodeId() == 'b') {
				v.getAdjacents().add(map.get('a'));
				v.getAdjacents().add(map.get('c'));
				v.getAdjacents().add(map.get('h'));
			} else if (v.getNodeId() == 'c') {
				v.getAdjacents().add(map.get('b'));
				v.getAdjacents().add(map.get('d'));
				v.getAdjacents().add(map.get('f'));
				v.getAdjacents().add(map.get('i'));
			} else if (v.getNodeId() == 'd') {
				v.getAdjacents().add(map.get('c'));
				v.getAdjacents().add(map.get('e'));
				v.getAdjacents().add(map.get('f'));
			} else if (v.getNodeId() == 'e') {
				v.getAdjacents().add(map.get('d'));
				v.getAdjacents().add(map.get('f'));
			} else if (v.getNodeId() == 'f') {
				v.getAdjacents().add(map.get('c'));
				v.getAdjacents().add(map.get('d'));
				v.getAdjacents().add(map.get('e'));
				v.getAdjacents().add(map.get('g'));
			}  else if (v.getNodeId() == 'g') {
				v.getAdjacents().add(map.get('f'));
				v.getAdjacents().add(map.get('h'));
				v.getAdjacents().add(map.get('i'));
			} else if (v.getNodeId() == 'h') {
				v.getAdjacents().add(map.get('a'));
				v.getAdjacents().add(map.get('b'));
				v.getAdjacents().add(map.get('g'));
				v.getAdjacents().add(map.get('i'));
			} else if (v.getNodeId() == 'i') {
				v.getAdjacents().add(map.get('c'));
				v.getAdjacents().add(map.get('g'));
				v.getAdjacents().add(map.get('h'));
			}	
		}
		// graph created
		// create disjoint sets
		DisjointSet S = null, V_S = null;
		for (Vertex v: graph) {
			char c = v.getNodeId();
			if (c == 'a' || c == 'b' || c == 'd' || c == 'e') {
				if (S == null) {
					S = v.getDisjointSet();
				} else {
					DisjointSet set = DisjointSet.union(S, v.getDisjointSet());
					v.setDisjointSet(set);
				}
			} else {
				if (V_S == null) {
					V_S = v.getDisjointSet();
				} else {
					DisjointSet set = DisjointSet.union(V_S, v.getDisjointSet());
					v.setDisjointSet(set);
				}
			}
		}
		// Disjoint sets created
		for (Vertex u: graph) {
			for (Vertex v: u.getAdjacents()) {
				if (DisjointSet.findSet((DisjointSet) u.getDisjointSet()) == 
				    DisjointSet.findSet((DisjointSet) v.getDisjointSet())) {
					System.out.println("The cut respects (" + u.getNodeId() + ", " + v.getNodeId() + ").");
				}
			}
		}
	}
}


class DisjointSet {
	DisjointSetNode head = null;
	DisjointSetNode tail = null;
	
	private DisjointSet(Object object) { 
		DisjointSetNode node = new DisjointSetNode(this, object, null);
		this.head = node;
		this.tail = node;
	}
	
	public static DisjointSet makeSet(Object object) {
		return new DisjointSet(object);
	}
	
	public static DisjointSet union(DisjointSet x, DisjointSet y) {
		for (DisjointSetNode node = y.head; node != null; node = node.getNext()) {
			node.setSet(x);
		}
		x.tail.setNext(y.head);
		x.tail = y. tail;
		return x;
	}
	
	public static Object findSet(DisjointSet x) {
		return x.head.getObject();
	}
	
}

class DisjointSetNode {
	private DisjointSet set = null;
	private Object object = null;
	private DisjointSetNode next = null;
	
	DisjointSetNode(DisjointSet set, Object object, DisjointSetNode next) {
		this.set = set;
		this.object = object;
		this.next = next;
	}
	
	public DisjointSet getSet() {
		return this.set;
	}
	
	public void setSet(DisjointSet set) {
		this.set = set;
	}
	
	public Object getObject() {
		return this.object;
	}
	
	public DisjointSetNode getNext() {
		return this.next;
	}
	
	public void setNext(DisjointSetNode next) {
		this.next = next;
	}
	
}


class Vertex {
	private char nodeId = 0;
	private ArrayList<Vertex> adjacents = new ArrayList<>();
	private DisjointSet set = DisjointSet.makeSet(this);
	Vertex(char nodeId) {
		this.nodeId = nodeId;
	}
	
	public char getNodeId(){
		return this.nodeId;
	}
	
	public ArrayList<Vertex> getAdjacents() {
		return this.adjacents;
	}
	
	public DisjointSet getDisjointSet() {
		return this.set;
	}
	
	public void setDisjointSet(DisjointSet set) {
		this.set = set;
	}
}