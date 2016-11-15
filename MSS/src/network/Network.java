package network;

import java.util.HashMap;

import edu.uci.ics.jung.graph.SparseGraph;


public class Network {
	public HashMap<Integer, Agent> agentMap = new HashMap<Integer, Agent>();
	public SparseGraph<Agent, MEdge> graph = new SparseGraph<Agent, MEdge>();
	
	public Network() {
		// TODO Auto-generated constructor stub
	}
	
	public void addAgent(Agent agent){
		agentMap.put(agent.id, agent);
		graph.addVertex(agent);
	}
	
	public int addEdge(Agent a, Agent b){
		if(graph.isNeighbor(a, b)){
			return -1;
		}
		if(a == b){
			return -1;
		}
		graph.addEdge(new MEdge(), a, b);
		return 1;
	}
	
	public int addEdgeByIDs(int a, int b){
		Agent aA = this.agentMap.get(a);
		Agent aB = this.agentMap.get(b);
		return this.addEdge(aA, aB);
	}

}
