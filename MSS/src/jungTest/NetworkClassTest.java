package jungTest;

import java.util.Random;

import util.Viewer;
import network.Agent;
import network.Network;
import network.WattsStrogatz;

public class NetworkClassTest {

	public NetworkClassTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Network network = new Network();
		
//		Random rand = new Random();
//		for(int newId=0; newId < 20; newId++){
//			Agent agent = new Agent(newId);
//			network.addAgent(agent);
//			if(rand.nextBoolean()){
//				agent.setOpinion(1.0);
//			}
//		}
//		
//		for(int edgeCount = 0; edgeCount <20; edgeCount++){
//			int a = rand.nextInt(network.agentMap.values().size()-1);
//			int b = rand.nextInt(network.agentMap.values().size()-1);
//			network.addEdgeByIDs(a, b);
//		}
		
		WattsStrogatz watts = new WattsStrogatz();
		network = watts.createSmallWorld(20, 2, 0.5);
		
		Viewer viewer = new Viewer();
		viewer.showGraph(network);
		
	}

}
