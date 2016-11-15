package network;

public class Agent {
int id;
double opinion;
	public Agent(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.opinion=0;
	}
	
	public double getOpinion(){
		return opinion;
	}

	public void setOpinion(double d) {
		// TODO Auto-generated method stub
		opinion=d;
	}

}
