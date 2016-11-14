package network;

import java.util.HashMap;


public class AgentList {
	public HashMap<Integer, Agent> map = new HashMap<Integer, Agent>();
	
	public AgentList() {
		// TODO Auto-generated constructor stub
	}
	
	public void addAgent(Agent agent){
		map.put(agent.id, agent);
	}

}
