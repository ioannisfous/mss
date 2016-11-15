package util;

import java.awt.Color;
import java.awt.Paint;

import javax.swing.JFrame;

import com.google.common.base.Function;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import network.Agent;
import network.MEdge;
import network.Network;

public class Viewer {

	public Viewer() {
		// TODO Auto-generated constructor stub
	}
	
	public void showGraph(Network network){
		// Color Transformer
        Function<Agent, Paint> vertexPaintTrans = new Function<Agent, Paint>() {
      	  public Paint apply(Agent a) {
      		  if(a.getOpinion()>0){
      			  return Color.RED;
      		  }
      		  return Color.GREEN;
      	  }
      	};
      	
      	JFrame jf = new JFrame();
		Graph g = network.graph;
		CircleLayout<Agent, MEdge> myLayout = new CircleLayout<Agent, MEdge>(g);
		VisualizationViewer vv = new VisualizationViewer(myLayout);
		vv.getRenderContext().setVertexFillPaintTransformer(vertexPaintTrans);
        jf.getContentPane().add(vv);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
      	
      	
	}

}
