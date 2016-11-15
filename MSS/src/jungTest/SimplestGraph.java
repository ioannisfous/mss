package jungTest;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import network.Agent;
import network.Network;
import network.MEdge;
import edu.uci.ics.jung.*;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.decorators.GradientEdgePaintTransformer;
import edu.uci.ics.jung.visualization.decorators.PickableVertexPaintTransformer;

import org.apache.commons.collections15.Transformer;


//import com.google.common.base.Function;


import com.google.common.base.Function;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.util.Random;

public class SimplestGraph {

	public SimplestGraph() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Agent, MEdge> myG = new SparseMultigraph<Agent, MEdge>();
		Network list = new Network();
		Random rand = new Random();
		for(int newId=1; newId < 20; newId++){
			Agent agent = new Agent(newId);
			list.addAgent(agent);
			if(rand.nextBoolean()){
				agent.setOpinion(1.0);
			}
		}
		
		for(Agent agent:list.agentMap.values()){
			myG.addVertex(agent);
		}


		myG.addEdge(new MEdge(), list.agentMap.get(1), list.agentMap.get(2));
		
		System.out.println(myG.toString());
		

        JFrame jf = new JFrame();
		Graph g = myG;
		CircleLayout<Agent, MEdge> myLayout = new CircleLayout<Agent, MEdge>(g);


        Function<Agent, Paint> vertexPaintTrans = new Function<Agent, Paint>() {
        	  public Paint apply(Agent a) {
        		  if(a.getOpinion()>0){
        			  return Color.RED;
        		  }
        		  return Color.GREEN;
        	  }
        	};

        
		VisualizationViewer vv = new VisualizationViewer(myLayout);
        //VisualizationViewer vv = new VisualizationViewer(new FRLayout(g));
		//vv.getRenderContext().getVertexFillPaintTransformer();
		vv.getRenderContext().setVertexFillPaintTransformer(vertexPaintTrans);
        jf.getContentPane().add(vv);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
		
		
	}


}
