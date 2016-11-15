package network;

public class WattsStrogatz {
	int n;
	int k;
	double beta;
	
	public WattsStrogatz() {
		// TODO Auto-generated constructor stub
	}
	
	public Network createSmallWorld(int n, int k, double beta){//Number of nodes, average degree (should be even?), spatial param.
		this.n=n;
		this.k=k;
		this.beta=beta;
		
		if(k % 2 == 1){
			System.out.println("WattsTrogatz: k is univen that might cause a problem");
		}
		
		
		Network network = new Network();
		
		//Create n agents
		for(int i=0; i<n; i++){	
			network.addAgent(new Agent(i));
		}
		
		//Create circular edges
		System.out.println("start building circular edges");
		for(int i=0; i<n; i++){//Not efficient not all of them needed anyways doubles and loops are refused by network class
			for(int dist = -k/2; dist<= k; dist++){
				int other = circleId(i+dist);
				network.addEdgeByIDs(i, other);

			}
			System.out.println("Edges for verted "+i+" done");
		}
		
		
		
		
		return network;
	}
	
	int circleId(int id){
		if(id >= 0 && id<n){
			return id;
		}
		if(id<0){
			return n+id;
		}
		if(id>n-1){
			return id-n;
		}
		return 0;
	}
	
	void reWire(){
		
	}

}
