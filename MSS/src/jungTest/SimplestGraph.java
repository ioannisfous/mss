package jungTest;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import network.Agent;
import network.AgentList;
import network.MEdge;
import	edu.uci.ics.jung.*;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.decorators.GradientEdgePaintTransformer;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;

public class SimplestGraph {

	public SimplestGraph() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Agent, MEdge> myG = new SparseMultigraph<Agent, MEdge>();
		AgentList list = new AgentList();
		
		for(int newId=1; newId < 20; newId++){
			Agent agent = new Agent(newId);
			list.addAgent(agent);
		}
		
		for(Agent agent:list.map.values()){
			myG.addVertex(agent);
		}

		//
		myG.addEdge(new MEdge(), list.map.get(1), list.map.get(2));
		
		System.out.println(myG.toString());
		

        JFrame jf = new JFrame();
		Graph g = myG;
		CircleLayout<Agent, MEdge> myLayout = new CircleLayout<Agent, MEdge>(g);

		
        // Transformer maps the vertex number to a vertex property
//        Transformer<Integer,Paint> vertexColor = new Transformer<Integer,Paint>() {
//            public Paint transform(Integer i) {
//                if(i == 1) return Color.GREEN;
//                return Color.RED;
//            }
//        };
//		
		VisualizationViewer vv = new VisualizationViewer(myLayout);
        //VisualizationViewer vv = new VisualizationViewer(new FRLayout(g));
        jf.getContentPane().add(vv);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
		
		
	}

}
